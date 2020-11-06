package com.cdame.domain.sf;

import java.util.Date;

import com.cdame.domain.sf.tech.SalesForceObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SfLicense extends SalesForceObject{

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Type__c")
	private String type;
	@JsonProperty("Version__c")
	private String version;
	@JsonProperty("CPU_Cores__c")
	private Long cpuCores;
	@JsonProperty("Start_Date__c")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonProperty("End_Date__c")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate;
	@JsonProperty("Instances__c")
	private Long instances;
	@JsonProperty("Host_Name__c")
	private String hostname;
	@JsonProperty("Contact__c")
	private String contactId;
	@JsonProperty("LicenseeName__c")
	private String assignee;
	@JsonProperty("Licensee_Email__c")
	private String assigneeMail;
	@JsonProperty("NotifyEmail__c")
	private String notifyEmail;
	@JsonProperty("Request_key__c")
	private String requestKey;
	@JsonProperty("Edition__c")
	private String edition;
	@JsonProperty("Status__c")
	private String status;
	@JsonProperty("Active__c")
	private Boolean active;
	@JsonProperty("LicenseeCompany__c")
	private String licenseeCompany;
	@JsonProperty("Delivery_Date_Time__c")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deliveryDateTime;
	@JsonProperty("Subscription__c")
	private String subscriptionId;
	@JsonProperty("DisableChecks__c")
	private String disableChecks;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Long getCpuCores() {
		return cpuCores;
	}
	public void setCpuCores(Long cpuCores) {
		this.cpuCores = cpuCores;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getInstances() {
		return instances;
	}
	public void setInstances(Long instances) {
		this.instances = instances;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getAssigneeMail() {
		return assigneeMail;
	}
	public void setAssigneeMail(String assigneeMail) {
		this.assigneeMail = assigneeMail;
	}
	public String getRequestKey() {
		return requestKey;
	}
	public void setRequestKey(String requestKey) {
		this.requestKey = requestKey;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getDeliveryDateTime() {
		return deliveryDateTime;
	}
	public void setDeliveryDateTime(Date deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getNotifyEmail() {
		return notifyEmail;
	}
	public void setNotifyEmail(String notifyEmail) {
		this.notifyEmail = notifyEmail;
	}
	public String getLicenseeCompany() {
		return licenseeCompany;
	}
	public void setLicenseeCompany(String licenseeCompany) {
		this.licenseeCompany = licenseeCompany;
	}
	public String getDisableChecks() {
		return disableChecks;
	}
	public void setDisableChecks(String disableChecks) {
		this.disableChecks = disableChecks;
	}
	
}
