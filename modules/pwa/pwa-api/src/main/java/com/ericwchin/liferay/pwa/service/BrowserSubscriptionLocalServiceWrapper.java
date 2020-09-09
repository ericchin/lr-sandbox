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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BrowserSubscriptionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BrowserSubscriptionLocalService
 * @generated
 */
public class BrowserSubscriptionLocalServiceWrapper
	implements BrowserSubscriptionLocalService,
			   ServiceWrapper<BrowserSubscriptionLocalService> {

	public BrowserSubscriptionLocalServiceWrapper(
		BrowserSubscriptionLocalService browserSubscriptionLocalService) {

		_browserSubscriptionLocalService = browserSubscriptionLocalService;
	}

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
	@Override
	public com.ericwchin.liferay.pwa.model.BrowserSubscription
		addBrowserSubscription(
			com.ericwchin.liferay.pwa.model.BrowserSubscription
				browserSubscription) {

		return _browserSubscriptionLocalService.addBrowserSubscription(
			browserSubscription);
	}

	@Override
	public com.ericwchin.liferay.pwa.model.BrowserSubscription addSubscription(
		String auth, String key, String endpoint,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _browserSubscriptionLocalService.addSubscription(
			auth, key, endpoint, serviceContext);
	}

	/**
	 * Creates a new browser subscription with the primary key. Does not add the browser subscription to the database.
	 *
	 * @param browserSubscriptionId the primary key for the new browser subscription
	 * @return the new browser subscription
	 */
	@Override
	public com.ericwchin.liferay.pwa.model.BrowserSubscription
		createBrowserSubscription(long browserSubscriptionId) {

		return _browserSubscriptionLocalService.createBrowserSubscription(
			browserSubscriptionId);
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
	@Override
	public com.ericwchin.liferay.pwa.model.BrowserSubscription
		deleteBrowserSubscription(
			com.ericwchin.liferay.pwa.model.BrowserSubscription
				browserSubscription) {

		return _browserSubscriptionLocalService.deleteBrowserSubscription(
			browserSubscription);
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
	@Override
	public com.ericwchin.liferay.pwa.model.BrowserSubscription
			deleteBrowserSubscription(long browserSubscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _browserSubscriptionLocalService.deleteBrowserSubscription(
			browserSubscriptionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _browserSubscriptionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _browserSubscriptionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _browserSubscriptionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _browserSubscriptionLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _browserSubscriptionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _browserSubscriptionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _browserSubscriptionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ericwchin.liferay.pwa.model.BrowserSubscription
		fetchBrowserSubscription(long browserSubscriptionId) {

		return _browserSubscriptionLocalService.fetchBrowserSubscription(
			browserSubscriptionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _browserSubscriptionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the browser subscription with the primary key.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription
	 * @throws PortalException if a browser subscription with the primary key could not be found
	 */
	@Override
	public com.ericwchin.liferay.pwa.model.BrowserSubscription
			getBrowserSubscription(long browserSubscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _browserSubscriptionLocalService.getBrowserSubscription(
			browserSubscriptionId);
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
	@Override
	public java.util.List<com.ericwchin.liferay.pwa.model.BrowserSubscription>
		getBrowserSubscriptions(int start, int end) {

		return _browserSubscriptionLocalService.getBrowserSubscriptions(
			start, end);
	}

	/**
	 * Returns the number of browser subscriptions.
	 *
	 * @return the number of browser subscriptions
	 */
	@Override
	public int getBrowserSubscriptionsCount() {
		return _browserSubscriptionLocalService.getBrowserSubscriptionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _browserSubscriptionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _browserSubscriptionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _browserSubscriptionLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.List<com.ericwchin.liferay.pwa.model.BrowserSubscription>
		getSubscriptionsByGroup(long groupId) {

		return _browserSubscriptionLocalService.getSubscriptionsByGroup(
			groupId);
	}

	@Override
	public java.util.List<com.ericwchin.liferay.pwa.model.BrowserSubscription>
		getSubscriptionsByUser(long userId) {

		return _browserSubscriptionLocalService.getSubscriptionsByUser(userId);
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
	@Override
	public com.ericwchin.liferay.pwa.model.BrowserSubscription
		updateBrowserSubscription(
			com.ericwchin.liferay.pwa.model.BrowserSubscription
				browserSubscription) {

		return _browserSubscriptionLocalService.updateBrowserSubscription(
			browserSubscription);
	}

	@Override
	public BrowserSubscriptionLocalService getWrappedService() {
		return _browserSubscriptionLocalService;
	}

	@Override
	public void setWrappedService(
		BrowserSubscriptionLocalService browserSubscriptionLocalService) {

		_browserSubscriptionLocalService = browserSubscriptionLocalService;
	}

	private BrowserSubscriptionLocalService _browserSubscriptionLocalService;

}