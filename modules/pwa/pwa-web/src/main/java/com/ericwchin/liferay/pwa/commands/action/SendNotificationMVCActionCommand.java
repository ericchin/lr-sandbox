package com.ericwchin.liferay.pwa.commands.action;

import com.ericwchin.liferay.pwa.constants.PortletKeys;
import com.ericwchin.liferay.pwa.helper.PWANotificationHelper;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.PWA_PORTLET,
		"javax.portlet.name=" + PortletKeys.PWA_ADMIN_PORTLET,
		"mvc.command.name=/send_notification"
	},
	service = MVCActionCommand.class
)
public class SendNotificationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long browserSubscriptionId = ParamUtil.getLong(actionRequest,
			"browserSubscriptionId");

		String message = ParamUtil.getString(actionRequest, "message");

		_pwaNotificationHelper.sendNotification(browserSubscriptionId, message);
	}

	@Reference
	private PWANotificationHelper _pwaNotificationHelper;

}
