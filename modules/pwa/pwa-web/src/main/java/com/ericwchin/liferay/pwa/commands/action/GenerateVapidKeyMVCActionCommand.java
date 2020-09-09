package com.ericwchin.liferay.pwa.commands.action;

import com.ericwchin.liferay.pwa.configuration.PWAConfiguration;
import com.ericwchin.liferay.pwa.constants.PortletKeys;
import com.ericwchin.liferay.pwa.helper.PWANotificationHelper;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Dictionary;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(
	configurationPid = "com.ericwchin.liferay.pwa.configuration.PWAConfiguration",
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.PWA_ADMIN_PORTLET,
		"mvc.command.name=/generate_vapid_key"
	},
	service = MVCActionCommand.class
)
public class GenerateVapidKeyMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		KeyValuePair keyValuePair = _pwaNotificationHelper.generateVapidKeyPair();

		Dictionary<String, Object> configurationDict =
			new HashMapDictionary<>();

		configurationDict.put("publicKey", keyValuePair.getKey());
		configurationDict.put("privateKey", keyValuePair.getValue());

		_configurationProvider.saveCompanyConfiguration(
			PWAConfiguration.class, themeDisplay.getCompanyId(),
			configurationDict);
	}

	@Reference
	private ConfigurationProvider _configurationProvider;

	@Reference
	private PWANotificationHelper _pwaNotificationHelper;

}
