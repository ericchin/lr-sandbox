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

import com.ericwchin.liferay.pwa.exception.NoSuchBrowserSubscriptionException;
import com.ericwchin.liferay.pwa.model.BrowserSubscription;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the browser subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrowserSubscriptionUtil
 * @generated
 */
@ProviderType
public interface BrowserSubscriptionPersistence
	extends BasePersistence<BrowserSubscription> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BrowserSubscriptionUtil} to access the browser subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the browser subscriptions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching browser subscriptions
	 */
	public java.util.List<BrowserSubscription> findByGroupId(long groupId);

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
	public java.util.List<BrowserSubscription> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<BrowserSubscription> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrowserSubscription>
			orderByComparator);

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
	public java.util.List<BrowserSubscription> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrowserSubscription>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	public BrowserSubscription findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException;

	/**
	 * Returns the first browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	public BrowserSubscription fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<BrowserSubscription>
			orderByComparator);

	/**
	 * Returns the last browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	public BrowserSubscription findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException;

	/**
	 * Returns the last browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	public BrowserSubscription fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<BrowserSubscription>
			orderByComparator);

	/**
	 * Returns the browser subscriptions before and after the current browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param browserSubscriptionId the primary key of the current browser subscription
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	public BrowserSubscription[] findByGroupId_PrevAndNext(
			long browserSubscriptionId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException;

	/**
	 * Removes all the browser subscriptions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of browser subscriptions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching browser subscriptions
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the browser subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching browser subscriptions
	 */
	public java.util.List<BrowserSubscription> findByUserId(long userId);

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
	public java.util.List<BrowserSubscription> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<BrowserSubscription> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrowserSubscription>
			orderByComparator);

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
	public java.util.List<BrowserSubscription> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrowserSubscription>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	public BrowserSubscription findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException;

	/**
	 * Returns the first browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	public BrowserSubscription fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<BrowserSubscription>
			orderByComparator);

	/**
	 * Returns the last browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	public BrowserSubscription findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException;

	/**
	 * Returns the last browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	public BrowserSubscription fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<BrowserSubscription>
			orderByComparator);

	/**
	 * Returns the browser subscriptions before and after the current browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param browserSubscriptionId the primary key of the current browser subscription
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	public BrowserSubscription[] findByUserId_PrevAndNext(
			long browserSubscriptionId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException;

	/**
	 * Removes all the browser subscriptions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of browser subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching browser subscriptions
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the browser subscription in the entity cache if it is enabled.
	 *
	 * @param browserSubscription the browser subscription
	 */
	public void cacheResult(BrowserSubscription browserSubscription);

	/**
	 * Caches the browser subscriptions in the entity cache if it is enabled.
	 *
	 * @param browserSubscriptions the browser subscriptions
	 */
	public void cacheResult(
		java.util.List<BrowserSubscription> browserSubscriptions);

	/**
	 * Creates a new browser subscription with the primary key. Does not add the browser subscription to the database.
	 *
	 * @param browserSubscriptionId the primary key for the new browser subscription
	 * @return the new browser subscription
	 */
	public BrowserSubscription create(long browserSubscriptionId);

	/**
	 * Removes the browser subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription that was removed
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	public BrowserSubscription remove(long browserSubscriptionId)
		throws NoSuchBrowserSubscriptionException;

	public BrowserSubscription updateImpl(
		BrowserSubscription browserSubscription);

	/**
	 * Returns the browser subscription with the primary key or throws a <code>NoSuchBrowserSubscriptionException</code> if it could not be found.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	public BrowserSubscription findByPrimaryKey(long browserSubscriptionId)
		throws NoSuchBrowserSubscriptionException;

	/**
	 * Returns the browser subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription, or <code>null</code> if a browser subscription with the primary key could not be found
	 */
	public BrowserSubscription fetchByPrimaryKey(long browserSubscriptionId);

	/**
	 * Returns all the browser subscriptions.
	 *
	 * @return the browser subscriptions
	 */
	public java.util.List<BrowserSubscription> findAll();

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
	public java.util.List<BrowserSubscription> findAll(int start, int end);

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
	public java.util.List<BrowserSubscription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrowserSubscription>
			orderByComparator);

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
	public java.util.List<BrowserSubscription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BrowserSubscription>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the browser subscriptions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of browser subscriptions.
	 *
	 * @return the number of browser subscriptions
	 */
	public int countAll();

}