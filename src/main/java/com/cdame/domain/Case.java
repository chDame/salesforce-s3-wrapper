package com.cdame.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Case {

    private String id;

    private Long number;

    private String subject;

    private String description;
    
	private String type;

    private Date createdDatetime;

    private Date lastPublicCommentDatetime;

    private String status;

    private String environment;

    private String didWeHelpYou;

    private String rate;
    
    private String rateProduct;

    private String severity;

    private String bosRelease;

    private String os;

    private String appServer;

    private String javaVersion;

    private String database;

    private String browser;
    
    private String emailcc;
    
    private boolean hidden;

    private List<CaseComment> comments;

    private List<Attachment> attachments;

    private List<Patch> patches;
    
    private String contactId;
    
    private Contact contact;
	
    private String subscriptionId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public List<CaseComment> getComments() {
		return comments;
	}

	public void setComments(List<CaseComment> comments) {
		this.comments = comments;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<Patch> getPatches() {
		return patches;
	}

	public void setPatches(List<Patch> patches) {
		this.patches = patches;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
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
