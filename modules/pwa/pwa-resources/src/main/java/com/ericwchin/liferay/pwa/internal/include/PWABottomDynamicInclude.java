package com.ericwchin.liferay.pwa.internal.include;

import com.ericwchin.liferay.pwa.configuration.PWAConfiguration;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(
	configurationPid = "com.ericwchin.liferay.pwa.configuration.PWAConfiguration",
	immediate = true,
	service = DynamicInclude.class
)
public class PWABottomDynamicInclude implements DynamicInclude {

	@Override
	public void include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String key)
		throws IOException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		StringBundler sb = new StringBundler();

		try {
			PWAConfiguration pwaConfiguration =
				_configurationProvider.getCompanyConfiguration(
					PWAConfiguration.class, themeDisplay.getCompanyId());

			String publicKey = pwaConfiguration.publicKey();

			if (Validator.isNotNull(publicKey)) {
				sb.append("<script type=\"text/javascript\">");
				sb.append("var applicationServerKey = '");
				sb.append(publicKey);
				sb.append("';");
				sb.append("</script>");
			}
		}
		catch (ConfigurationException ce) {
			_log.error(ce.getMessage(), ce);
		}

		sb.append("<script type=\"text/javascript\" ");
		sb.append("src=\"/o/liferay-pwa/js/registration.js\">");
		sb.append("</script>");

		PrintWriter printWriter = httpServletResponse.getWriter();

		printWriter.print(sb.toString());
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(_KEY);
	}

	@Reference
	private ConfigurationProvider _configurationProvider;

	private static final String _KEY = "/html/common/themes/bottom.jsp#post";

	private static final Log _log = LogFactoryUtil.getLog(
		PWABottomDynamicInclude.class);

}
