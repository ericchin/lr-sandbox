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

package com.ericwchin.liferay.pwa.service.impl;

import com.ericwchin.liferay.pwa.model.BrowserSubscription;
import com.ericwchin.liferay.pwa.service.base.BrowserSubscriptionLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the browser subscription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ericwchin.liferay.pwa.service.BrowserSubscriptionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrowserSubscriptionLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ericwchin.liferay.pwa.model.BrowserSubscription",
	service = AopService.class
)
public class BrowserSubscriptionLocalServiceImpl
	extends BrowserSubscriptionLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ericwchin.liferay.pwa.service.BrowserSubscriptionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ericwchin.liferay.pwa.service.BrowserSubscriptionLocalServiceUtil</code>.
	 */

	public BrowserSubscription addSubscription(
		String auth, String key, String endpoint,
		ServiceContext serviceContext) {

		long subscriptionId = counterLocalService.increment(
			BrowserSubscription.class.getName());

		BrowserSubscription browserSubscription =
			browserSubscriptionPersistence.create(subscriptionId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.fetchUser(userId);

		if (Objects.nonNull(user)) {
			browserSubscription.setUserId(user.getUserId());
			browserSubscription.setUserName(user.getFullName());
		}

		browserSubscription.setCompanyId(serviceContext.getCompanyId());
		browserSubscription.setGroupId(serviceContext.getScopeGroupId());

		Date date = new Date();

		browserSubscription.setCreateDate(date);
		browserSubscription.setModifiedDate(date);

		browserSubscription.setAuth(auth);
		browserSubscription.setKey(key);
		browserSubscription.setEndpoint(endpoint);

		return browserSubscriptionPersistence.update(browserSubscription);
	}

}