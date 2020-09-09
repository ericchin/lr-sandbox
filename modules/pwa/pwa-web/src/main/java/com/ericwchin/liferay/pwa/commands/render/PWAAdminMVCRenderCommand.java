package com.ericwchin.liferay.pwa.commands.render;

import com.ericwchin.liferay.pwa.constants.PortletKeys;
import com.ericwchin.liferay.pwa.model.BrowserSubscription;
import com.ericwchin.liferay.pwa.service.BrowserSubscriptionLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.PWA_ADMIN_PORTLET,
		"mvc.command.name=/", "mvc.command.name=/view"
	},
	service = MVCRenderCommand.class
)
public class PWAAdminMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		List<BrowserSubscription> browserSubscriptions =
			_browserSubscriptionLocalService.getBrowserSubscriptions(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		renderRequest.setAttribute(
			"browserSubscriptions", browserSubscriptions);

		return "/admin/view.jsp";
	}

	@Reference
	private BrowserSubscriptionLocalService _browserSubscriptionLocalService;

}
