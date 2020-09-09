/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ericwchin.liferay.pwa.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for BrowserSubscription. This utility wraps
 * <code>com.ericwchin.liferay.pwa.service.impl.BrowserSubscriptionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BrowserSubscriptionLocalService
 * @generated
 */
public class BrowserSubscriptionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ericwchin.liferay.pwa.service.impl.BrowserSubscriptionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the browser subscription to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrowserSubscriptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param browserSubscription the browser subscription
	 * @return the browser subscription that was added
	 */
	public static com.ericwchin.liferay.pwa.model.BrowserSubscription
		addBrowserSubscription(
			com.ericwchin.liferay.pwa.model.BrowserSubscription
				browserSubscription) {

		return getService().addBrowserSubscription(browserSubscription);
	}

	public static com.ericwchin.liferay.pwa.model.BrowserSubscription
		addSubscription(
			String auth, String key, String endpoint,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addSubscription(
			auth, key, endpoint, serviceContext);
	}

	/**
	 * Creates a new browser subscription with the primary key. Does not add the browser subscription to the database.
	 *
	 * @param browserSubscriptionId the primary key for the new browser subscription
	 * @return the new browser subscription
	 */
	public static com.ericwchin.liferay.pwa.model.BrowserSubscription
		createBrowserSubscription(long browserSubscriptionId) {

		return getService().createBrowserSubscription(browserSubscriptionId);
	}

	/**
	 * Deletes the browser subscription from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrowserSubscriptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param browserSubscription the browser subscription
	 * @return the browser subscription that was removed
	 */
	public static com.ericwchin.liferay.pwa.model.BrowserSubscription
		deleteBrowserSubscription(
			com.ericwchin.liferay.pwa.model.BrowserSubscription
				browserSubscription) {

		return getService().deleteBrowserSubscription(browserSubscription);
	}

	/**
	 * Deletes the browser subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrowserSubscriptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription that was removed
	 * @throws PortalException if a browser subscription with the primary key could not be found
	 */
	public static com.ericwchin.liferay.pwa.model.BrowserSubscription
			deleteBrowserSubscription(long browserSubscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteBrowserSubscription(browserSubscriptionId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ericwchin.liferay.pwa.model.impl.BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ericwchin.liferay.pwa.model.impl.BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ericwchin.liferay.pwa.model.BrowserSubscription
		fetchBrowserSubscription(long browserSubscriptionId) {

		return getService().fetchBrowserSubscription(browserSubscriptionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the browser subscription with the primary key.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription
	 * @throws PortalException if a browser subscription with the primary key could not be found
	 */
	public static com.ericwchin.liferay.pwa.model.BrowserSubscription
			getBrowserSubscription(long browserSubscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getBrowserSubscription(browserSubscriptionId);
	}

	/**
	 * Returns a range of all the browser subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ericwchin.liferay.pwa.model.impl.BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of browser subscriptions
	 * @param end the upper bound of the range of browser subscriptions (not inclusive)
	 * @return the range of browser subscriptions
	 */
	public static java.util.List
		<com.ericwchin.liferay.pwa.model.BrowserSubscription>
			getBrowserSubscriptions(int start, int end) {

		return getService().getBrowserSubscriptions(start, end);
	}

	/**
	 * Returns the number of browser subscriptions.
	 *
	 * @return the number of browser subscriptions
	 */
	public static int getBrowserSubscriptionsCount() {
		return getService().getBrowserSubscriptionsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List
		<com.ericwchin.liferay.pwa.model.BrowserSubscription>
			getSubscriptionsByGroup(long groupId) {

		return getService().getSubscriptionsByGroup(groupId);
	}

	public static java.util.List
		<com.ericwchin.liferay.pwa.model.BrowserSubscription>
			getSubscriptionsByUser(long userId) {

		return getService().getSubscriptionsByUser(userId);
	}

	/**
	 * Updates the browser subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BrowserSubscriptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param browserSubscription the browser subscription
	 * @return the browser subscription that was updated
	 */
	public static com.ericwchin.liferay.pwa.model.BrowserSubscription
		updateBrowserSubscription(
			com.ericwchin.liferay.pwa.model.BrowserSubscription
				browserSubscription) {

		return getService().updateBrowserSubscription(browserSubscription);
	}

	public static BrowserSubscriptionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<BrowserSubscriptionLocalService, BrowserSubscriptionLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			BrowserSubscriptionLocalService.class);

		ServiceTracker
			<BrowserSubscriptionLocalService, BrowserSubscriptionLocalService>
				serviceTracker =
					new ServiceTracker
						<BrowserSubscriptionLocalService,
						 BrowserSubscriptionLocalService>(
							 bundle.getBundleContext(),
							 BrowserSubscriptionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}