create table PWA_BrowserSubscription (
	browserSubscriptionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	endpoint VARCHAR(200) null,
	auth VARCHAR(2000) null,
	key_ VARCHAR(2000) null
);