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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BrowserSubscription}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrowserSubscription
 * @generated
 */
public class BrowserSubscriptionWrapper
	extends BaseModelWrapper<BrowserSubscription>
	implements BrowserSubscription, ModelWrapper<BrowserSubscription> {

	public BrowserSubscriptionWrapper(BrowserSubscription browserSubscription) {
		super(browserSubscription);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("browserSubscriptionId", getBrowserSubscriptionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("endpoint", getEndpoint());
		attributes.put("auth", getAuth());
		attributes.put("key", getKey());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long browserSubscriptionId = (Long)attributes.get(
			"browserSubscriptionId");

		if (browserSubscriptionId != null) {
			setBrowserSubscriptionId(browserSubscriptionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String endpoint = (String)attributes.get("endpoint");

		if (endpoint != null) {
			setEndpoint(endpoint);
		}

		String auth = (String)attributes.get("auth");

		if (auth != null) {
			setAuth(auth);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}
	}

	/**
	 * Returns the auth of this browser subscription.
	 *
	 * @return the auth of this browser subscription
	 */
	@Override
	public String getAuth() {
		return model.getAuth();
	}

	/**
	 * Returns the browser subscription ID of this browser subscription.
	 *
	 * @return the browser subscription ID of this browser subscription
	 */
	@Override
	public long getBrowserSubscriptionId() {
		return model.getBrowserSubscriptionId();
	}

	/**
	 * Returns the company ID of this browser subscription.
	 *
	 * @return the company ID of this browser subscription
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this browser subscription.
	 *
	 * @return the create date of this browser subscription
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the endpoint of this browser subscription.
	 *
	 * @return the endpoint of this browser subscription
	 */
	@Override
	public String getEndpoint() {
		return model.getEndpoint();
	}

	/**
	 * Returns the group ID of this browser subscription.
	 *
	 * @return the group ID of this browser subscription
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the key of this browser subscription.
	 *
	 * @return the key of this browser subscription
	 */
	@Override
	public String getKey() {
		return model.getKey();
	}

	/**
	 * Returns the modified date of this browser subscription.
	 *
	 * @return the modified date of this browser subscription
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this browser subscription.
	 *
	 * @return the primary key of this browser subscription
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this browser subscription.
	 *
	 * @return the user ID of this browser subscription
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this browser subscription.
	 *
	 * @return the user name of this browser subscription
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this browser subscription.
	 *
	 * @return the user uuid of this browser subscription
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the auth of this browser subscription.
	 *
	 * @param auth the auth of this browser subscription
	 */
	@Override
	public void setAuth(String auth) {
		model.setAuth(auth);
	}

	/**
	 * Sets the browser subscription ID of this browser subscription.
	 *
	 * @param browserSubscriptionId the browser subscription ID of this browser subscription
	 */
	@Override
	public void setBrowserSubscriptionId(long browserSubscriptionId) {
		model.setBrowserSubscriptionId(browserSubscriptionId);
	}

	/**
	 * Sets the company ID of this browser subscription.
	 *
	 * @param companyId the company ID of this browser subscription
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this browser subscription.
	 *
	 * @param createDate the create date of this browser subscription
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the endpoint of this browser subscription.
	 *
	 * @param endpoint the endpoint of this browser subscription
	 */
	@Override
	public void setEndpoint(String endpoint) {
		model.setEndpoint(endpoint);
	}

	/**
	 * Sets the group ID of this browser subscription.
	 *
	 * @param groupId the group ID of this browser subscription
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the key of this browser subscription.
	 *
	 * @param key the key of this browser subscription
	 */
	@Override
	public void setKey(String key) {
		model.setKey(key);
	}

	/**
	 * Sets the modified date of this browser subscription.
	 *
	 * @param modifiedDate the modified date of this browser subscription
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this browser subscription.
	 *
	 * @param primaryKey the primary key of this browser subscription
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this browser subscription.
	 *
	 * @param userId the user ID of this browser subscription
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this browser subscription.
	 *
	 * @param userName the user name of this browser subscription
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this browser subscription.
	 *
	 * @param userUuid the user uuid of this browser subscription
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected BrowserSubscriptionWrapper wrap(
		BrowserSubscription browserSubscription) {

		return new BrowserSubscriptionWrapper(browserSubscription);
	}

}