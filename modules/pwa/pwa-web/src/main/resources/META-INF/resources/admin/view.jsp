<%@ include file="/init.jsp" %>

<%@ page import="com.ericwchin.liferay.pwa.model.BrowserSubscription" %>

<liferay-portlet:actionURL name="/generate_vapid_key" var="generateKeyURL" />

<aui:form method="post" action="<%= generateKeyURL %>" name="fm">
	<aui:button-row>
		<aui:button type="submit" value="generate-vapid-key" />
	</aui:button-row>
</aui:form>

<liferay-ui:search-container
	emptyResultsMessage="no-subscriptions-available"
	total="${browserSubscriptions.size()}">

	<liferay-ui:search-container-results results="${browserSubscriptions}" />

	<liferay-ui:search-container-row
		className="com.ericwchin.liferay.pwa.model.BrowserSubscription"
		modelVar="browserSubscription"
	>

		<liferay-ui:search-container-column-text
			name="browserSubscriptionId"
			property="browserSubscriptionId"
		/>

		<liferay-ui:search-container-column-text
			name="userName"
			property="userName"
		/>

		<liferay-ui:search-container-column-text name="action">

			<portlet:actionURL name="/send_notification" var="sendNotificationURL">
				<portlet:param name="browserSubscriptionId" value="${browserSubscription.browserSubscriptionId}" />
				<portlet:param name="message" value="test-hello-world"/>
			</portlet:actionURL>

			<aui:a href="<%= sendNotificationURL %>"><liferay-ui:message key="send-notification" /></aui:a>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>