package com.cdame.domain.sf.cases;

import java.util.Date;

import com.cdame.domain.sf.tech.SalesForceObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class SfCase extends SalesForceObject {

	@JsonProperty(value = "CaseNumber", access = Access.WRITE_ONLY)
	private Long number;
	@JsonProperty("Subject")
	private String subject;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Type")
	private String type;
	@JsonProperty(value = "CreatedDate", access = Access.WRITE_ONLY)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdDatetime;
	@JsonProperty(value = "LastPublicCommentDateTime__c", access = Access.WRITE_ONLY)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date lastPublicCommentDatetime;
	@JsonProperty("Status")
	private String status;
	@JsonProperty("Environment_type__c")
	private String environment;
	@JsonProperty("Did_We_help_you_solve_your_problem__c")
	private String didWeHelpYou;
	@JsonProperty("satisfactionLevel__c")
	private String rate;
	@JsonProperty("ProductSatisfactionLevel__c")
	private String rateProduct;
	@JsonProperty("Severity__c")
	private String severity;
	@JsonProperty("BOS_release__c")
	private String bosRelease;
	@JsonProperty("OS_Name__c")
	private String os;
	@JsonProperty("Application_Server__c")
	private String appServer;
	@JsonProperty("Java_Version__c")
	private String javaVersion;
	@JsonProperty("Database__c")
	private String database;
	@JsonProperty("Web_Browser__c")
	private String browser;
	@JsonProperty("EmailCC__c")
	private String emailcc;
	@JsonProperty("isHidden__c")
	private boolean hidden;
	@JsonProperty("ContactId")
	private String contactId;
	@JsonProperty("Subscription__c")
    private String subscriptionId;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Date getLastPublicCommentDatetime() {
		return lastPublicCommentDatetime;
	}

	public void setLastPublicCommentDatetime(Date lastPublicCommentDatetime) {
		this.lastPublicCommentDatetime = lastPublicCommentDatetime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getDidWeHelpYou() {
		return didWeHelpYou;
	}

	public void setDidWeHelpYou(String didWeHelpYou) {
		this.didWeHelpYou = didWeHelpYou;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getRateProduct() {
		return rateProduct;
	}

	public void setRateProduct(String rateProduct) {
		this.rateProduct = rateProduct;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getBosRelease() {
		return bosRelease;
	}

	public void setBosRelease(String bosRelease) {
		this.bosRelease = bosRelease;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getAppServer() {
		return appServer;
	}

	public void setAppServer(String appServer) {
		this.appServer = appServer;
	}

	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getEmailcc() {
		return emailcc;
	}

	public void setEmailcc(String emailcc) {
		this.emailcc = emailcc;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
