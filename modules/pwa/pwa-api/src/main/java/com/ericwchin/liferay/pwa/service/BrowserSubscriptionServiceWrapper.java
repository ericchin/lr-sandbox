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
 * Provides a wrapper for {@link BrowserSubscriptionService}.
 *
 * @author Brian Wing Shun Chan
 * @see BrowserSubscriptionService
 * @generated
 */
public class BrowserSubscriptionServiceWrapper
	implements BrowserSubscriptionService,
			   ServiceWrapper<BrowserSubscriptionService> {

	public BrowserSubscriptionServiceWrapper(
		BrowserSubscriptionService browserSubscriptionService) {

		_browserSubscriptionService = browserSubscriptionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _browserSubscriptionService.getOSGiServiceIdentifier();
	}

	@Override
	public BrowserSubscriptionService getWrappedService() {
		return _browserSubscriptionService;
	}

	@Override
	public void setWrappedService(
		BrowserSubscriptionService browserSubscriptionService) {

		_browserSubscriptionService = browserSubscriptionService;
	}

	private BrowserSubscriptionService _browserSubscriptionService;

}