package com.ericwchin.liferay.pwa.helper;

import com.ericwchin.liferay.pwa.configuration.PWAConfiguration;
import com.ericwchin.liferay.pwa.model.BrowserSubscription;
import com.ericwchin.liferay.pwa.service.BrowserSubscriptionLocalService;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.util.KeyValuePair;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.util.Objects;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import nl.martijndwars.webpush.Base64Encoder;
import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;
import nl.martijndwars.webpush.Subscription;
import nl.martijndwars.webpush.Utils;

import static nl.martijndwars.webpush.Utils.ALGORITHM;
import static nl.martijndwars.webpush.Utils.CURVE;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = PWANotificationHelper.class)
public class PWANotificationHelper {

	public KeyValuePair generateVapidKeyPair() throws Exception {
		ECNamedCurveParameterSpec parameterSpec =
			ECNamedCurveTable.getParameterSpec(CURVE);

		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(
			ALGORITHM, BouncyCastleProvider.PROVIDER_NAME);
		keyPairGenerator.initialize(parameterSpec);

		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		ECPublicKey publicKey = (ECPublicKey) keyPair.getPublic();
		ECPrivateKey privateKey = (ECPrivateKey) keyPair.getPrivate();

		byte[] encodedPublicKey = Utils.encode(publicKey);
		byte[] encodedPrivateKey = Utils.encode(privateKey);

		return new KeyValuePair(
			Base64Encoder.encodeUrl(encodedPublicKey),
			Base64Encoder.encodeUrl(encodedPrivateKey));
	}

	public void sendNotification(
			long browserSubscriptionId, String message)
		throws Exception {

		BrowserSubscription browserSubscription =
			_browserSubscriptionLocalService.fetchBrowserSubscription(
				browserSubscriptionId);

		if (Objects.isNull(browserSubscription)) {
			return;
		}

		PWAConfiguration pwaConfiguration =
			_configurationProvider.getCompanyConfiguration(
				PWAConfiguration.class, browserSubscription.getCompanyId());

		PushService pushService = new PushService(
			pwaConfiguration.publicKey(), pwaConfiguration.privateKey());

		Subscription subscription = new Subscription(
			browserSubscription.getEndpoint(),
			new Subscription.Keys(
				browserSubscription.getKey(), browserSubscription.getAuth()));

		Notification notification = new Notification(subscription, message);

		pushService.send(notification);
	}

	@Activate
	protected void activate() {
		_bouncyCastleProvider = new BouncyCastleProvider();

		Security.addProvider(_bouncyCastleProvider);
	}

	@Deactivate
	protected void deactivate() {
		if (Objects.nonNull(_bouncyCastleProvider)) {
			Security.removeProvider(_bouncyCastleProvider.getName());
		}
	}

	@Reference
	private BrowserSubscriptionLocalService _browserSubscriptionLocalService;

	@Reference
	private ConfigurationProvider _configurationProvider;

	private BouncyCastleProvider _bouncyCastleProvider;

}
