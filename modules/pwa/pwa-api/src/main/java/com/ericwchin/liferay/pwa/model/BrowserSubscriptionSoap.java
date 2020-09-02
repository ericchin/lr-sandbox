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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ericwchin.liferay.pwa.service.http.BrowserSubscriptionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrowserSubscriptionSoap implements Serializable {

	public static BrowserSubscriptionSoap toSoapModel(
		BrowserSubscription model) {

		BrowserSubscriptionSoap soapModel = new BrowserSubscriptionSoap();

		soapModel.setBrowserSubscriptionId(model.getBrowserSubscriptionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEndpoint(model.getEndpoint());
		soapModel.setAuth(model.getAuth());
		soapModel.setKey(model.getKey());

		return soapModel;
	}

	public static BrowserSubscriptionSoap[] toSoapModels(
		BrowserSubscription[] models) {

		BrowserSubscriptionSoap[] soapModels =
			new BrowserSubscriptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BrowserSubscriptionSoap[][] toSoapModels(
		BrowserSubscription[][] models) {

		BrowserSubscriptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new BrowserSubscriptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BrowserSubscriptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BrowserSubscriptionSoap[] toSoapModels(
		List<BrowserSubscription> models) {

		List<BrowserSubscriptionSoap> soapModels =
			new ArrayList<BrowserSubscriptionSoap>(models.size());

		for (BrowserSubscription model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new BrowserSubscriptionSoap[soapModels.size()]);
	}

	public BrowserSubscriptionSoap() {
	}

	public long getPrimaryKey() {
		return _browserSubscriptionId;
	}

	public void setPrimaryKey(long pk) {
		setBrowserSubscriptionId(pk);
	}

	public long getBrowserSubscriptionId() {
		return _browserSubscriptionId;
	}

	public void setBrowserSubscriptionId(long browserSubscriptionId) {
		_browserSubscriptionId = browserSubscriptionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
	}

	public String getAuth() {
		return _auth;
	}

	public void setAuth(String auth) {
		_auth = auth;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	private long _browserSubscriptionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _endpoint;
	private String _auth;
	private String _key;

}