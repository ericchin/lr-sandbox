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

package com.ericwchin.liferay.pwa.service.persistence;

import com.ericwchin.liferay.pwa.model.BrowserSubscription;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the browser subscription service. This utility wraps <code>com.ericwchin.liferay.pwa.service.persistence.impl.BrowserSubscriptionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrowserSubscriptionPersistence
 * @generated
 */
public class BrowserSubscriptionUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(BrowserSubscription browserSubscription) {
		getPersistence().clearCache(browserSubscription);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BrowserSubscription> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BrowserSubscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BrowserSubscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BrowserSubscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BrowserSubscription update(
		BrowserSubscription browserSubscription) {

		return getPersistence().update(browserSubscription);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BrowserSubscription update(
		BrowserSubscription browserSubscription,
		ServiceContext serviceContext) {

		return getPersistence().update(browserSubscription, serviceContext);
	}

	/**
	 * Returns all the browser subscriptions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching browser subscriptions
	 */
	public static List<BrowserSubscription> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the browser subscriptions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of browser subscriptions
	 * @param end the upper bound of the range of browser subscriptions (not inclusive)
	 * @return the range of matching browser subscriptions
	 */
	public static List<BrowserSubscription> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the browser subscriptions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of browser subscriptions
	 * @param end the upper bound of the range of browser subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching browser subscriptions
	 */
	public static List<BrowserSubscription> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the browser subscriptions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of browser subscriptions
	 * @param end the upper bound of the range of browser subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching browser subscriptions
	 */
	public static List<BrowserSubscription> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	public static BrowserSubscription findByGroupId_First(
			long groupId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws com.ericwchin.liferay.pwa.exception.
			NoSuchBrowserSubscriptionException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	public static BrowserSubscription fetchByGroupId_First(
		long groupId,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	public static BrowserSubscription findByGroupId_Last(
			long groupId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws com.ericwchin.liferay.pwa.exception.
			NoSuchBrowserSubscriptionException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	public static BrowserSubscription fetchByGroupId_Last(
		long groupId,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the browser subscriptions before and after the current browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param browserSubscriptionId the primary key of the current browser subscription
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	public static BrowserSubscription[] findByGroupId_PrevAndNext(
			long browserSubscriptionId, long groupId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws com.ericwchin.liferay.pwa.exception.
			NoSuchBrowserSubscriptionException {

		return getPersistence().findByGroupId_PrevAndNext(
			browserSubscriptionId, groupId, orderByComparator);
	}

	/**
	 * Removes all the browser subscriptions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of browser subscriptions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching browser subscriptions
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the browser subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching browser subscriptions
	 */
	public static List<BrowserSubscription> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the browser subscriptions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of browser subscriptions
	 * @param end the upper bound of the range of browser subscriptions (not inclusive)
	 * @return the range of matching browser subscriptions
	 */
	public static List<BrowserSubscription> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the browser subscriptions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of browser subscriptions
	 * @param end the upper bound of the range of browser subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching browser subscriptions
	 */
	public static List<BrowserSubscription> findByUserId(
		long userId, int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the browser subscriptions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of browser subscriptions
	 * @param end the upper bound of the range of browser subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching browser subscriptions
	 */
	public static List<BrowserSubscription> findByUserId(
		long userId, int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	public static BrowserSubscription findByUserId_First(
			long userId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws com.ericwchin.liferay.pwa.exception.
			NoSuchBrowserSubscriptionException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	public static BrowserSubscription fetchByUserId_First(
		long userId, OrderByComparator<BrowserSubscription> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	public static BrowserSubscription findByUserId_Last(
			long userId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws com.ericwchin.liferay.pwa.exception.
			NoSuchBrowserSubscriptionException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	public static BrowserSubscription fetchByUserId_Last(
		long userId, OrderByComparator<BrowserSubscription> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the browser subscriptions before and after the current browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param browserSubscriptionId the primary key of the current browser subscription
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	public static BrowserSubscription[] findByUserId_PrevAndNext(
			long browserSubscriptionId, long userId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws com.ericwchin.liferay.pwa.exception.
			NoSuchBrowserSubscriptionException {

		return getPersistence().findByUserId_PrevAndNext(
			browserSubscriptionId, userId, orderByComparator);
	}

	/**
	 * Removes all the browser subscriptions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of browser subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching browser subscriptions
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the browser subscription in the entity cache if it is enabled.
	 *
	 * @param browserSubscription the browser subscription
	 */
	public static void cacheResult(BrowserSubscription browserSubscription) {
		getPersistence().cacheResult(browserSubscription);
	}

	/**
	 * Caches the browser subscriptions in the entity cache if it is enabled.
	 *
	 * @param browserSubscriptions the browser subscriptions
	 */
	public static void cacheResult(
		List<BrowserSubscription> browserSubscriptions) {

		getPersistence().cacheResult(browserSubscriptions);
	}

	/**
	 * Creates a new browser subscription with the primary key. Does not add the browser subscription to the database.
	 *
	 * @param browserSubscriptionId the primary key for the new browser subscription
	 * @return the new browser subscription
	 */
	public static BrowserSubscription create(long browserSubscriptionId) {
		return getPersistence().create(browserSubscriptionId);
	}

	/**
	 * Removes the browser subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription that was removed
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	public static BrowserSubscription remove(long browserSubscriptionId)
		throws com.ericwchin.liferay.pwa.exception.
			NoSuchBrowserSubscriptionException {

		return getPersistence().remove(browserSubscriptionId);
	}

	public static BrowserSubscription updateImpl(
		BrowserSubscription browserSubscription) {

		return getPersistence().updateImpl(browserSubscription);
	}

	/**
	 * Returns the browser subscription with the primary key or throws a <code>NoSuchBrowserSubscriptionException</code> if it could not be found.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	public static BrowserSubscription findByPrimaryKey(
			long browserSubscriptionId)
		throws com.ericwchin.liferay.pwa.exception.
			NoSuchBrowserSubscriptionException {

		return getPersistence().findByPrimaryKey(browserSubscriptionId);
	}

	/**
	 * Returns the browser subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription, or <code>null</code> if a browser subscription with the primary key could not be found
	 */
	public static BrowserSubscription fetchByPrimaryKey(
		long browserSubscriptionId) {

		return getPersistence().fetchByPrimaryKey(browserSubscriptionId);
	}

	/**
	 * Returns all the browser subscriptions.
	 *
	 * @return the browser subscriptions
	 */
	public static List<BrowserSubscription> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the browser subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of browser subscriptions
	 * @param end the upper bound of the range of browser subscriptions (not inclusive)
	 * @return the range of browser subscriptions
	 */
	public static List<BrowserSubscription> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the browser subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of browser subscriptions
	 * @param end the upper bound of the range of browser subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of browser subscriptions
	 */
	public static List<BrowserSubscription> findAll(
		int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the browser subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrowserSubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of browser subscriptions
	 * @param end the upper bound of the range of browser subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of browser subscriptions
	 */
	public static List<BrowserSubscription> findAll(
		int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the browser subscriptions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of browser subscriptions.
	 *
	 * @return the number of browser subscriptions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BrowserSubscriptionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<BrowserSubscriptionPersistence, BrowserSubscriptionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			BrowserSubscriptionPersistence.class);

		ServiceTracker
			<BrowserSubscriptionPersistence, BrowserSubscriptionPersistence>
				serviceTracker =
					new ServiceTracker
						<BrowserSubscriptionPersistence,
						 BrowserSubscriptionPersistence>(
							 bundle.getBundleContext(),
							 BrowserSubscriptionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}