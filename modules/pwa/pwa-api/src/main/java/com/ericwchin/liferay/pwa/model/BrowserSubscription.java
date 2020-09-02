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

package com.ericwchin.liferay.pwa.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the BrowserSubscription service. Represents a row in the &quot;PWA_BrowserSubscription&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see BrowserSubscriptionModel
 * @generated
 */
@ImplementationClassName(
	"com.ericwchin.liferay.pwa.model.impl.BrowserSubscriptionImpl"
)
@ProviderType
public interface BrowserSubscription
	extends BrowserSubscriptionModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ericwchin.liferay.pwa.model.impl.BrowserSubscriptionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BrowserSubscription, Long>
		BROWSER_SUBSCRIPTION_ID_ACCESSOR =
			new Accessor<BrowserSubscription, Long>() {

				@Override
				public Long get(BrowserSubscription browserSubscription) {
					return browserSubscription.getBrowserSubscriptionId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<BrowserSubscription> getTypeClass() {
					return BrowserSubscription.class;
				}

			};

}