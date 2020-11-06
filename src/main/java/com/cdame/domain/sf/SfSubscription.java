package com.cdame.domain.sf;

import java.util.Date;
import java.util.List;

import com.cdame.domain.sf.cases.SfCase;
import com.cdame.domain.sf.tech.SalesForceObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SfSubscription extends SalesForceObject {

	@JsonProperty("Id")
	private String id;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Edition__c")
	private String edition;
	@JsonProperty("Support_Level__c")
	private String supportlevel;
	@JsonProperty("Active__c")
	private boolean active;
	@JsonProperty("Start_Date__c")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonProperty("End_Date__c")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate;
	@JsonProperty("ProductionDeclarationDate__c")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date productionDate;
	@JsonProperty("PhoneCallBack__c")
	private boolean phoneCallback;
	@JsonProperty("CPU_Cores_Bought__c")
	private Long prodCoresTotal;
	@JsonProperty("CPUCoresUsed__c")
	private Long prodCoresUsed;
	@JsonProperty("SUMofQualifLicenceCoresAuthorized__c")
	private Long qualifCoresTotal;
	@JsonProperty("SUMofQualifLicenceCoresUsed__c")
	private Long qualifCoresUsed;
	@JsonProperty("RemainingDevelopmentLicences__c")
	private Long remainingDevelopmentLicenses;
	@JsonProperty("RemainingTrainingLicences__c")
	private Long remainingTrainingLicenses;
	@JsonProperty("RemainingProductionLicences__c")
	private Long remainingProductionLicenses;
	@JsonProperty("RemainingPartnerLicences__c")
	private Long remainingPartnerLicenses;
	@JsonProperty("RemainingInternalLicences__c")
	private Long remainingInternalLicenses;
	@JsonProperty("RemainingTrialLicences__c")
	private Long remainingTrialLicenses;
	@JsonProperty("RemainingQualificationLicences__c")
	private Long remainingQualificationLicenses;
	@JsonProperty("AuthorizedDevelopmentLicencesCores__c")
	private Long developmentCoresMax;
	@JsonProperty("AuthorizedInternalLicencesCores__c")
	private Long internalCoresMax;
	@JsonProperty("AuthorizedTrainingLicencesCores__c")
	private Long trainingCoresMax;
	@JsonProperty("AuthorizedPartnerLicencesCores__c")
	private Long partnerCoresMax;
	@JsonProperty("AuthorizedTrialLicencesCores__c")
	private Long trialCoresMax;
	@JsonProperty("AuthorizeDevelopmentLicences__c")
	private boolean authorizeDevelopmentLicenses;
	@JsonProperty("AuthorizeTrainingLicences__c")
	private boolean authorizeTrainingLicenses;
	@JsonProperty("AuthorizeProductionLicences__c")
	private boolean authorizeProductionLicenses;
	@JsonProperty("AuthorizePartnerLicences__c")
	private boolean authorizePartnerLicenses;
	@JsonProperty("AuthorizeInternalLicences__c")
	private boolean authorizeInternalLicenses;
	@JsonProperty("AuthorizeTrialLicences__c")
	private boolean authorizeTrialLicenses;
	@JsonProperty("AuthorizeQualificationLicences__c")
	private boolean authorizeQualificationLicenses;
	@JsonProperty("CanGenerateBetaLicense__c")
	private boolean canGenerateBetaLicense;
	@JsonProperty("Account__c")
	private String accountId;
	@JsonProperty("SLA_Timezone__c")
	private String slaTimezone;

	/*
	public SfSubscription(Map<String, Object> body) {
		id = (String) body.get("Id");
		name = (String) body.get("Name");
		edition = (String) body.get("Edition__c");
		supportlevel = (String) body.get("Support_Level__c");
		active = (Boolean) body.get("Active__c");
		startDate = TimeUtils.toDate((String) body.get("Start_Date__c")); 
		endDate = TimeUtils.toDate((String) body.get("End_Date__c")); 
		productionDate = TimeUtils.toDate((String) body.get("ProductionDeclarationDate__c"));
		phoneCallback = (Boolean) body.get("PhoneCallBack__c");

		prodCoresTotal= Math.round((Double) body.get("CPU_Cores_Bought__c"));
		prodCoresUsed = Math.round((Double) body.get("CPUCoresUsed__c"));

		qualifCoresTotal = Math.round((Double) body.get("SUMofQualifLicenceCoresAuthorized__c"));
		qualifCoresUsed = Math.round((Double) body.get("SUMofQualifLicenceCoresUsed__c"));

		remainingDevelopmentLicenses = Math.round((Double) body.get("RemainingDevelopmentLicences__c"));
		remainingTrainingLicenses = Math.round((Double) body.get("RemainingTrainingLicences__c"));
		remainingProductionLicenses = Math.round((Double) body.get("RemainingProductionLicences__c"));
		remainingPartnerLicenses = Math.round((Double) body.get("RemainingPartnerLicences__c"));
		remainingInternalLicenses = Math.round((Double) body.get("RemainingInternalLicences__c"));
		remainingTrialLicenses = Math.round((Double) body.get("RemainingTrainingLicences__c"));
		remainingQualificationLicenses = Math.round((Double) body.get("RemainingQualificationLicences__c"));

		developmentCoresMax = Math.round((Double) body.get("AuthorizedDevelopmentLicencesCores__c"));
		internalCoresMax = Math.round((Double) body.get("AuthorizedInternalLicencesCores__c"));
		trainingCoresMax = Math.round((Double) body.get("AuthorizedTrainingLicencesCores__c"));
		partnerCoresMax = Math.round((Double) body.get("AuthorizedPartnerLicencesCores__c"));
		trialCoresMax  = Math.round((Double) body.get("AuthorizedTrialLicencesCores__c"));
		
		authorizeDevelopmentLicenses = (Boolean) body.get("AuthorizeDevelopmentLicences__c");
		authorizeTrainingLicenses = (Boolean) body.get("AuthorizeTrainingLicences__c");
		authorizeProductionLicenses = (Boolean) body.get("AuthorizeProductionLicences__c");
		authorizePartnerLicenses = (Boolean) body.get("AuthorizePartnerLicences__c");
		authorizeInternalLicenses = (Boolean) body.get("AuthorizeInternalLicences__c");
		authorizeTrialLicenses = (Boolean) body.get("AuthorizeTrialLicences__c");
		authorizeQualificationLicenses = (Boolean) body.get("AuthorizeQualificationLicences__c");
		canGenerateBetaLicense = (Boolean) body.get("CanGenerateBetaLicense__c");
		
		accountId = (String) body.get("Account__c");
	}*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getSupportlevel() {
		return supportlevel;
	}

	public void setSupportlevel(String supportlevel) {
		this.supportlevel = supportlevel;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public boolean isPhoneCallback() {
		return phoneCallback;
	}

	public void setPhoneCallback(boolean phoneCallback) {
		this.phoneCallback = phoneCallback;
	}

	public Long getProdCoresTotal() {
		return prodCoresTotal;
	}

	public void setProdCoresTotal(Long prodCoresTotal) {
		this.prodCoresTotal = prodCoresTotal;
	}

	public Long getProdCoresUsed() {
		return prodCoresUsed;
	}

	public void setProdCoresUsed(Long prodCoresUsed) {
		this.prodCoresUsed = prodCoresUsed;
	}

	public Long getQualifCoresTotal() {
		return qualifCoresTotal;
	}

	public void setQualifCoresTotal(Long qualifCoresTotal) {
		this.qualifCoresTotal = qualifCoresTotal;
	}

	public Long getQualifCoresUsed() {
		return qualifCoresUsed;
	}

	public void setQualifCoresUsed(Long qualifCoresUsed) {
		this.qualifCoresUsed = qualifCoresUsed;
	}

	public Long getRemainingDevelopmentLicenses() {
		return remainingDevelopmentLicenses;
	}

	public void setRemainingDevelopmentLicenses(Long remainingDevelopmentLicenses) {
		this.remainingDevelopmentLicenses = remainingDevelopmentLicenses;
	}

	public Long getRemainingTrainingLicenses() {
		return remainingTrainingLicenses;
	}

	public void setRemainingTrainingLicenses(Long remainingTrainingLicenses) {
		this.remainingTrainingLicenses = remainingTrainingLicenses;
	}

	public Long getRemainingProductionLicenses() {
		return remainingProductionLicenses;
	}

	public void setRemainingProductionLicenses(Long remainingProductionLicenses) {
		this.remainingProductionLicenses = remainingProductionLicenses;
	}

	public Long getRemainingPartnerLicenses() {
		return remainingPartnerLicenses;
	}

	public void setRemainingPartnerLicenses(Long remainingPartnerLicenses) {
		this.remainingPartnerLicenses = remainingPartnerLicenses;
	}

	public Long getRemainingInternalLicenses() {
		return remainingInternalLicenses;
	}

	public void setRemainingInternalLicenses(Long remainingInternalLicenses) {
		this.remainingInternalLicenses = remainingInternalLicenses;
	}

	public Long getRemainingTrialLicenses() {
		return remainingTrialLicenses;
	}

	public void setRemainingTrialLicenses(Long remainingTrialLicenses) {
		this.remainingTrialLicenses = remainingTrialLicenses;
	}

	public Long getRemainingQualificationLicenses() {
		return remainingQualificationLicenses;
	}

	public void setRemainingQualificationLicenses(Long remainingQualificationLicenses) {
		this.remainingQualificationLicenses = remainingQualificationLicenses;
	}

	public Long getDevelopmentCoresMax() {
		return developmentCoresMax;
	}

	public void setDevelopmentCoresMax(Long developmentCoresMax) {
		this.developmentCoresMax = developmentCoresMax;
	}

	public Long getInternalCoresMax() {
		return internalCoresMax;
	}

	public void setInternalCoresMax(Long internalCoresMax) {
		this.internalCoresMax = internalCoresMax;
	}

	public Long getTrainingCoresMax() {
		return trainingCoresMax;
	}

	public void setTrainingCoresMax(Long trainingCoresMax) {
		this.trainingCoresMax = trainingCoresMax;
	}

	public Long getPartnerCoresMax() {
		return partnerCoresMax;
	}

	public void setPartnerCoresMax(Long partnerCoresMax) {
		this.partnerCoresMax = partnerCoresMax;
	}

	public Long getTrialCoresMax() {
		return trialCoresMax;
	}

	public void setTrialCoresMax(Long trialCoresMax) {
		this.trialCoresMax = trialCoresMax;
	}

	public boolean isAuthorizeDevelopmentLicenses() {
		return authorizeDevelopmentLicenses;
	}

	public void setAuthorizeDevelopmentLicenses(boolean authorizeDevelopmentLicenses) {
		this.authorizeDevelopmentLicenses = authorizeDevelopmentLicenses;
	}

	public boolean isAuthorizeTrainingLicenses() {
		return authorizeTrainingLicenses;
	}

	public void setAuthorizeTrainingLicenses(boolean authorizeTrainingLicenses) {
		this.authorizeTrainingLicenses = authorizeTrainingLicenses;
	}

	public boolean isAuthorizeProductionLicenses() {
		return authorizeProductionLicenses;
	}

	public void setAuthorizeProductionLicenses(boolean authorizeProductionLicenses) {
		this.authorizeProductionLicenses = authorizeProductionLicenses;
	}

	public boolean isAuthorizePartnerLicenses() {
		return authorizePartnerLicenses;
	}

	public void setAuthorizePartnerLicenses(boolean authorizePartnerLicenses) {
		this.authorizePartnerLicenses = authorizePartnerLicenses;
	}

	public boolean isAuthorizeInternalLicenses() {
		return authorizeInternalLicenses;
	}

	public void setAuthorizeInternalLicenses(boolean authorizeInternalLicenses) {
		this.authorizeInternalLicenses = authorizeInternalLicenses;
	}

	public boolean isAuthorizeTrialLicenses() {
		return authorizeTrialLicenses;
	}

	public void setAuthorizeTrialLicenses(boolean authorizeTrialLicenses) {
		this.authorizeTrialLicenses = authorizeTrialLicenses;
	}

	public boolean isAuthorizeQualificationLicenses() {
		return authorizeQualificationLicenses;
	}

	public void setAuthorizeQualificationLicenses(boolean authorizeQualificationLicenses) {
		this.authorizeQualificationLicenses = authorizeQualificationLicenses;
	}

	public boolean isCanGenerateBetaLicense() {
		return canGenerateBetaLicense;
	}

	public void setCanGenerateBetaLicense(boolean canGenerateBetaLicense) {
		this.canGenerateBetaLicense = canGenerateBetaLicense;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getSlaTimezone() {
		return slaTimezone;
	}

	public void setSlaTimezone(String slaTimezone) {
		this.slaTimezone = slaTimezone;
	}
}
