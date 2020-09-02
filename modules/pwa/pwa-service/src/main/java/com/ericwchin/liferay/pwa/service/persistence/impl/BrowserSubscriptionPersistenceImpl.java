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

package com.ericwchin.liferay.pwa.service.persistence.impl;

import com.ericwchin.liferay.pwa.exception.NoSuchBrowserSubscriptionException;
import com.ericwchin.liferay.pwa.model.BrowserSubscription;
import com.ericwchin.liferay.pwa.model.impl.BrowserSubscriptionImpl;
import com.ericwchin.liferay.pwa.model.impl.BrowserSubscriptionModelImpl;
import com.ericwchin.liferay.pwa.service.persistence.BrowserSubscriptionPersistence;
import com.ericwchin.liferay.pwa.service.persistence.impl.constants.PWAPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the browser subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BrowserSubscriptionPersistence.class)
public class BrowserSubscriptionPersistenceImpl
	extends BasePersistenceImpl<BrowserSubscription>
	implements BrowserSubscriptionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BrowserSubscriptionUtil</code> to access the browser subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BrowserSubscriptionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the browser subscriptions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching browser subscriptions
	 */
	@Override
	public List<BrowserSubscription> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BrowserSubscription> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<BrowserSubscription> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<BrowserSubscription> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<BrowserSubscription> list = null;

		if (useFinderCache) {
			list = (List<BrowserSubscription>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BrowserSubscription browserSubscription : list) {
					if (groupId != browserSubscription.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BROWSERSUBSCRIPTION_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BrowserSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<BrowserSubscription>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	@Override
	public BrowserSubscription findByGroupId_First(
			long groupId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException {

		BrowserSubscription browserSubscription = fetchByGroupId_First(
			groupId, orderByComparator);

		if (browserSubscription != null) {
			return browserSubscription;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchBrowserSubscriptionException(sb.toString());
	}

	/**
	 * Returns the first browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	@Override
	public BrowserSubscription fetchByGroupId_First(
		long groupId,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		List<BrowserSubscription> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	@Override
	public BrowserSubscription findByGroupId_Last(
			long groupId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException {

		BrowserSubscription browserSubscription = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (browserSubscription != null) {
			return browserSubscription;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchBrowserSubscriptionException(sb.toString());
	}

	/**
	 * Returns the last browser subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	@Override
	public BrowserSubscription fetchByGroupId_Last(
		long groupId,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<BrowserSubscription> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BrowserSubscription[] findByGroupId_PrevAndNext(
			long browserSubscriptionId, long groupId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException {

		BrowserSubscription browserSubscription = findByPrimaryKey(
			browserSubscriptionId);

		Session session = null;

		try {
			session = openSession();

			BrowserSubscription[] array = new BrowserSubscriptionImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, browserSubscription, groupId, orderByComparator, true);

			array[1] = browserSubscription;

			array[2] = getByGroupId_PrevAndNext(
				session, browserSubscription, groupId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BrowserSubscription getByGroupId_PrevAndNext(
		Session session, BrowserSubscription browserSubscription, long groupId,
		OrderByComparator<BrowserSubscription> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BROWSERSUBSCRIPTION_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BrowserSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						browserSubscription)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BrowserSubscription> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the browser subscriptions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (BrowserSubscription browserSubscription :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(browserSubscription);
		}
	}

	/**
	 * Returns the number of browser subscriptions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching browser subscriptions
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BROWSERSUBSCRIPTION_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"browserSubscription.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the browser subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching browser subscriptions
	 */
	@Override
	public List<BrowserSubscription> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BrowserSubscription> findByUserId(
		long userId, int start, int end) {

		return findByUserId(userId, start, end, null);
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
	@Override
	public List<BrowserSubscription> findByUserId(
		long userId, int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<BrowserSubscription> findByUserId(
		long userId, int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<BrowserSubscription> list = null;

		if (useFinderCache) {
			list = (List<BrowserSubscription>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BrowserSubscription browserSubscription : list) {
					if (userId != browserSubscription.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BROWSERSUBSCRIPTION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BrowserSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<BrowserSubscription>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	@Override
	public BrowserSubscription findByUserId_First(
			long userId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException {

		BrowserSubscription browserSubscription = fetchByUserId_First(
			userId, orderByComparator);

		if (browserSubscription != null) {
			return browserSubscription;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchBrowserSubscriptionException(sb.toString());
	}

	/**
	 * Returns the first browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	@Override
	public BrowserSubscription fetchByUserId_First(
		long userId, OrderByComparator<BrowserSubscription> orderByComparator) {

		List<BrowserSubscription> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a matching browser subscription could not be found
	 */
	@Override
	public BrowserSubscription findByUserId_Last(
			long userId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException {

		BrowserSubscription browserSubscription = fetchByUserId_Last(
			userId, orderByComparator);

		if (browserSubscription != null) {
			return browserSubscription;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchBrowserSubscriptionException(sb.toString());
	}

	/**
	 * Returns the last browser subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching browser subscription, or <code>null</code> if a matching browser subscription could not be found
	 */
	@Override
	public BrowserSubscription fetchByUserId_Last(
		long userId, OrderByComparator<BrowserSubscription> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<BrowserSubscription> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BrowserSubscription[] findByUserId_PrevAndNext(
			long browserSubscriptionId, long userId,
			OrderByComparator<BrowserSubscription> orderByComparator)
		throws NoSuchBrowserSubscriptionException {

		BrowserSubscription browserSubscription = findByPrimaryKey(
			browserSubscriptionId);

		Session session = null;

		try {
			session = openSession();

			BrowserSubscription[] array = new BrowserSubscriptionImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, browserSubscription, userId, orderByComparator, true);

			array[1] = browserSubscription;

			array[2] = getByUserId_PrevAndNext(
				session, browserSubscription, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BrowserSubscription getByUserId_PrevAndNext(
		Session session, BrowserSubscription browserSubscription, long userId,
		OrderByComparator<BrowserSubscription> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BROWSERSUBSCRIPTION_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BrowserSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						browserSubscription)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BrowserSubscription> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the browser subscriptions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (BrowserSubscription browserSubscription :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(browserSubscription);
		}
	}

	/**
	 * Returns the number of browser subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching browser subscriptions
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BROWSERSUBSCRIPTION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"browserSubscription.userId = ?";

	public BrowserSubscriptionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BrowserSubscription.class);

		setModelImplClass(BrowserSubscriptionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the browser subscription in the entity cache if it is enabled.
	 *
	 * @param browserSubscription the browser subscription
	 */
	@Override
	public void cacheResult(BrowserSubscription browserSubscription) {
		entityCache.putResult(
			entityCacheEnabled, BrowserSubscriptionImpl.class,
			browserSubscription.getPrimaryKey(), browserSubscription);

		browserSubscription.resetOriginalValues();
	}

	/**
	 * Caches the browser subscriptions in the entity cache if it is enabled.
	 *
	 * @param browserSubscriptions the browser subscriptions
	 */
	@Override
	public void cacheResult(List<BrowserSubscription> browserSubscriptions) {
		for (BrowserSubscription browserSubscription : browserSubscriptions) {
			if (entityCache.getResult(
					entityCacheEnabled, BrowserSubscriptionImpl.class,
					browserSubscription.getPrimaryKey()) == null) {

				cacheResult(browserSubscription);
			}
			else {
				browserSubscription.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all browser subscriptions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BrowserSubscriptionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the browser subscription.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BrowserSubscription browserSubscription) {
		entityCache.removeResult(
			entityCacheEnabled, BrowserSubscriptionImpl.class,
			browserSubscription.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BrowserSubscription> browserSubscriptions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BrowserSubscription browserSubscription : browserSubscriptions) {
			entityCache.removeResult(
				entityCacheEnabled, BrowserSubscriptionImpl.class,
				browserSubscription.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, BrowserSubscriptionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new browser subscription with the primary key. Does not add the browser subscription to the database.
	 *
	 * @param browserSubscriptionId the primary key for the new browser subscription
	 * @return the new browser subscription
	 */
	@Override
	public BrowserSubscription create(long browserSubscriptionId) {
		BrowserSubscription browserSubscription = new BrowserSubscriptionImpl();

		browserSubscription.setNew(true);
		browserSubscription.setPrimaryKey(browserSubscriptionId);

		browserSubscription.setCompanyId(CompanyThreadLocal.getCompanyId());

		return browserSubscription;
	}

	/**
	 * Removes the browser subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription that was removed
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	@Override
	public BrowserSubscription remove(long browserSubscriptionId)
		throws NoSuchBrowserSubscriptionException {

		return remove((Serializable)browserSubscriptionId);
	}

	/**
	 * Removes the browser subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the browser subscription
	 * @return the browser subscription that was removed
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	@Override
	public BrowserSubscription remove(Serializable primaryKey)
		throws NoSuchBrowserSubscriptionException {

		Session session = null;

		try {
			session = openSession();

			BrowserSubscription browserSubscription =
				(BrowserSubscription)session.get(
					BrowserSubscriptionImpl.class, primaryKey);

			if (browserSubscription == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBrowserSubscriptionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(browserSubscription);
		}
		catch (NoSuchBrowserSubscriptionException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected BrowserSubscription removeImpl(
		BrowserSubscription browserSubscription) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(browserSubscription)) {
				browserSubscription = (BrowserSubscription)session.get(
					BrowserSubscriptionImpl.class,
					browserSubscription.getPrimaryKeyObj());
			}

			if (browserSubscription != null) {
				session.delete(browserSubscription);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (browserSubscription != null) {
			clearCache(browserSubscription);
		}

		return browserSubscription;
	}

	@Override
	public BrowserSubscription updateImpl(
		BrowserSubscription browserSubscription) {

		boolean isNew = browserSubscription.isNew();

		if (!(browserSubscription instanceof BrowserSubscriptionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(browserSubscription.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					browserSubscription);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in browserSubscription proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BrowserSubscription implementation " +
					browserSubscription.getClass());
		}

		BrowserSubscriptionModelImpl browserSubscriptionModelImpl =
			(BrowserSubscriptionModelImpl)browserSubscription;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (browserSubscription.getCreateDate() == null)) {
			if (serviceContext == null) {
				browserSubscription.setCreateDate(now);
			}
			else {
				browserSubscription.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!browserSubscriptionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				browserSubscription.setModifiedDate(now);
			}
			else {
				browserSubscription.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (browserSubscription.isNew()) {
				session.save(browserSubscription);

				browserSubscription.setNew(false);
			}
			else {
				browserSubscription = (BrowserSubscription)session.merge(
					browserSubscription);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				browserSubscriptionModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {browserSubscriptionModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((browserSubscriptionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					browserSubscriptionModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {browserSubscriptionModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((browserSubscriptionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					browserSubscriptionModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {browserSubscriptionModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, BrowserSubscriptionImpl.class,
			browserSubscription.getPrimaryKey(), browserSubscription, false);

		browserSubscription.resetOriginalValues();

		return browserSubscription;
	}

	/**
	 * Returns the browser subscription with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the browser subscription
	 * @return the browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	@Override
	public BrowserSubscription findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBrowserSubscriptionException {

		BrowserSubscription browserSubscription = fetchByPrimaryKey(primaryKey);

		if (browserSubscription == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBrowserSubscriptionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return browserSubscription;
	}

	/**
	 * Returns the browser subscription with the primary key or throws a <code>NoSuchBrowserSubscriptionException</code> if it could not be found.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription
	 * @throws NoSuchBrowserSubscriptionException if a browser subscription with the primary key could not be found
	 */
	@Override
	public BrowserSubscription findByPrimaryKey(long browserSubscriptionId)
		throws NoSuchBrowserSubscriptionException {

		return findByPrimaryKey((Serializable)browserSubscriptionId);
	}

	/**
	 * Returns the browser subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param browserSubscriptionId the primary key of the browser subscription
	 * @return the browser subscription, or <code>null</code> if a browser subscription with the primary key could not be found
	 */
	@Override
	public BrowserSubscription fetchByPrimaryKey(long browserSubscriptionId) {
		return fetchByPrimaryKey((Serializable)browserSubscriptionId);
	}

	/**
	 * Returns all the browser subscriptions.
	 *
	 * @return the browser subscriptions
	 */
	@Override
	public List<BrowserSubscription> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BrowserSubscription> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<BrowserSubscription> findAll(
		int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<BrowserSubscription> findAll(
		int start, int end,
		OrderByComparator<BrowserSubscription> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<BrowserSubscription> list = null;

		if (useFinderCache) {
			list = (List<BrowserSubscription>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BROWSERSUBSCRIPTION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BROWSERSUBSCRIPTION;

				sql = sql.concat(BrowserSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BrowserSubscription>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the browser subscriptions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BrowserSubscription browserSubscription : findAll()) {
			remove(browserSubscription);
		}
	}

	/**
	 * Returns the number of browser subscriptions.
	 *
	 * @return the number of browser subscriptions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_BROWSERSUBSCRIPTION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "browserSubscriptionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BROWSERSUBSCRIPTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BrowserSubscriptionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the browser subscription persistence.
	 */
	@Activate
	public void activate() {
		BrowserSubscriptionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		BrowserSubscriptionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			BrowserSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			BrowserSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			BrowserSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			BrowserSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			BrowserSubscriptionModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			BrowserSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			BrowserSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			BrowserSubscriptionModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(BrowserSubscriptionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = PWAPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ericwchin.liferay.pwa.model.BrowserSubscription"),
			true);
	}

	@Override
	@Reference(
		target = PWAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PWAPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BROWSERSUBSCRIPTION =
		"SELECT browserSubscription FROM BrowserSubscription browserSubscription";

	private static final String _SQL_SELECT_BROWSERSUBSCRIPTION_WHERE =
		"SELECT browserSubscription FROM BrowserSubscription browserSubscription WHERE ";

	private static final String _SQL_COUNT_BROWSERSUBSCRIPTION =
		"SELECT COUNT(browserSubscription) FROM BrowserSubscription browserSubscription";

	private static final String _SQL_COUNT_BROWSERSUBSCRIPTION_WHERE =
		"SELECT COUNT(browserSubscription) FROM BrowserSubscription browserSubscription WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "browserSubscription.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BrowserSubscription exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BrowserSubscription exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BrowserSubscriptionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

	static {
		try {
			Class.forName(PWAPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}