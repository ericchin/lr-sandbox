package com.ericwchin.liferay.pwa.internal.servlet;

import com.ericwchin.liferay.pwa.internal.util.PWAHelper;
import com.liferay.portal.kernel.util.ContentTypes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"osgi.http.whiteboard.context.path=/",
		"osgi.http.whiteboard.servlet.pattern=/pwa/manifest/*"
	},
	service = Servlet.class
)
public class PWAManifestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(ContentTypes.APPLICATION_JSON);
		resp.setStatus(HttpServletResponse.SC_OK);

		resp.getWriter().write(_pwaHelper.getManifestJSON());
	}

	@Reference
	private PWAHelper _pwaHelper;

}
