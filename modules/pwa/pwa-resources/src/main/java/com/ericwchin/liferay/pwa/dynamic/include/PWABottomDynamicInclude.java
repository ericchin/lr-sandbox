package com.ericwchin.liferay.pwa.dynamic.include;

import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = DynamicInclude.class)
public class PWABottomDynamicInclude implements DynamicInclude {

	@Override
	public void include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String key)
		throws IOException {

		StringBundler sb = new StringBundler();

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

	private static final String _KEY = "/html/common/themes/bottom.jsp#post";

}
