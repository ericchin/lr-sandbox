package com.ericwchin.liferay.pwa.internal.util;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = PWAHelper.class)
public class PWAHelper {

	public String getManifestJSON() {
		JSONObject manifestObj = JSONFactoryUtil.createJSONObject();

		manifestObj.put("name", "Liferay PWA");
		manifestObj.put("short_name", "PWA");
		manifestObj.put("description", "Liferay PWA");
		manifestObj.put("start_url", "/");
		manifestObj.put("background_color", "#3367D6");
		manifestObj.put("display", "standalone");
		manifestObj.put("scope", "/");
		manifestObj.put("theme_color", "#3367D6");
		manifestObj.put("orientation", "portrait");
		manifestObj.put("applicationServerKey", _APP_SERVER_KEY);

		JSONArray iconArray = JSONFactoryUtil.createJSONArray();

		JSONObject iconObj = JSONFactoryUtil.createJSONObject();

		iconObj.put("src", "/o/liferay-pwa/images/logo.svg");
		iconObj.put("sizes", "192x192");
		iconObj.put("type", "image/svg+xml");

		iconArray.put(iconObj);

		manifestObj.put("icons", iconArray);

		return manifestObj.toString();
	}

	private static final String _APP_SERVER_KEY = "AAAAl9HkVK4" +
		":APA91bEJEnIkC_R3mu0uQT3GQ2QsbggSCyqT3sFbur_qP" +
		"-5HN9il7EhM8debxamm9pPd7kvNQberag9phpLN6isZZZpvs" +
		"Rte4cE9QLUPznLNS1K1EtkYCxpX74-uaTQE94hjQrN8MErL";

}
