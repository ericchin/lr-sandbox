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

package com.ericwchin.liferay.pwa.model.impl;

import com.ericwchin.liferay.pwa.model.BrowserSubscription;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BrowserSubscription in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrowserSubscriptionCacheModel
	implements CacheModel<BrowserSubscription>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BrowserSubscriptionCacheModel)) {
			return false;
		}

		BrowserSubscriptionCacheModel browserSubscriptionCacheModel =
			(BrowserSubscriptionCacheModel)object;

		if (browserSubscriptionId ==
				browserSubscriptionCacheModel.browserSubscriptionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, browserSubscriptionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{browserSubscriptionId=");
		sb.append(browserSubscriptionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", endpoint=");
		sb.append(endpoint);
		sb.append(", auth=");
		sb.append(auth);
		sb.append(", key=");
		sb.append(key);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BrowserSubscription toEntityModel() {
		BrowserSubscriptionImpl browserSubscriptionImpl =
			new BrowserSubscriptionImpl();

		browserSubscriptionImpl.setBrowserSubscriptionId(browserSubscriptionId);
		browserSubscriptionImpl.setGroupId(groupId);
		browserSubscriptionImpl.setCompanyId(companyId);
		browserSubscriptionImpl.setUserId(userId);

		if (userName == null) {
			browserSubscriptionImpl.setUserName("");
		}
		else {
			browserSubscriptionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			browserSubscriptionImpl.setCreateDate(null);
		}
		else {
			browserSubscriptionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			browserSubscriptionImpl.setModifiedDate(null);
		}
		else {
			browserSubscriptionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (endpoint == null) {
			browserSubscriptionImpl.setEndpoint("");
		}
		else {
			browserSubscriptionImpl.setEndpoint(endpoint);
		}

		if (auth == null) {
			browserSubscriptionImpl.setAuth("");
		}
		else {
			browserSubscriptionImpl.setAuth(auth);
		}

		if (key == null) {
			browserSubscriptionImpl.setKey("");
		}
		else {
			browserSubscriptionImpl.setKey(key);
		}

		browserSubscriptionImpl.resetOriginalValues();

		return browserSubscriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		browserSubscriptionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		endpoint = objectInput.readUTF();
		auth = objectInput.readUTF();
		key = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(browserSubscriptionId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (endpoint == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(endpoint);
		}

		if (auth == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(auth);
		}

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}
	}

	public long browserSubscriptionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String endpoint;
	public String auth;
	public String key;

}