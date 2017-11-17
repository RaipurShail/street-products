package com.business.form;

import java.util.Map;

public class ShopRegistrationFormBean {

	private static final long serialVersionUID = 453693552059515150L;
	private Long shopId;
	private String shopName;
	private String snNumber;
	private String buildingName;
	private String streetName;
	private String landmarkName;
	private String localityName;
	private String country;
	private String state;
	private String district;
	private String city;
	private String pincode;
	private String ownerName;
	private String ownerGender;
	private String registrationNumber;
	private String primaryContactNumber;
	private String contactNumber;
	private Map<String, String> ownership; /*RENTAL, SELF*/
	private String tenantName;
	private String tenantGender;
	private String establishDate;
	private Map<String, String> establishType; /*SELF OWNED, PARTNERSHIP, PVT LTD, CO OPERATIVE, PUBLIC LTD, RENTAL, TRUST*/
	private String userId;
	private Map<String, String> businessSector; /*PRIVATE, PUBLIC*/
	private String locationCoOrdinates;
	private String workingHours;
	private String workingDays;
	private String workingOffDays;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	
	public ShopRegistrationFormBean() {
		// TODO Auto-generated constructor stub
	}

	public ShopRegistrationFormBean(Long shopId, String shopName, String snNumber, String buildingName,
			String streetName, String landmarkName, String localityName, String country, String state, String district,
			String city, String pincode, String ownerName, String ownerGender, String registrationNumber,
			String primaryContactNumber, String contactNumber, Map<String, String> ownership, String tenantName,
			String tenantGender, String establishDate, Map<String, String> establishType, String userId,
			Map<String, String> businessSector, String locationCoOrdinates, String workingHours, String workingDays,
			String workingOffDays, String createdDate, String createdBy, String modifiedDate, String modifiedBy) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.snNumber = snNumber;
		this.buildingName = buildingName;
		this.streetName = streetName;
		this.landmarkName = landmarkName;
		this.localityName = localityName;
		this.country = country;
		this.state = state;
		this.district = district;
		this.city = city;
		this.pincode = pincode;
		this.ownerName = ownerName;
		this.ownerGender = ownerGender;
		this.registrationNumber = registrationNumber;
		this.primaryContactNumber = primaryContactNumber;
		this.contactNumber = contactNumber;
		this.ownership = ownership;
		this.tenantName = tenantName;
		this.tenantGender = tenantGender;
		this.establishDate = establishDate;
		this.establishType = establishType;
		this.userId = userId;
		this.businessSector = businessSector;
		this.locationCoOrdinates = locationCoOrdinates;
		this.workingHours = workingHours;
		this.workingDays = workingDays;
		this.workingOffDays = workingOffDays;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getSnNumber() {
		return snNumber;
	}

	public void setSnNumber(String snNumber) {
		this.snNumber = snNumber;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLandmarkName() {
		return landmarkName;
	}

	public void setLandmarkName(String landmarkName) {
		this.landmarkName = landmarkName;
	}

	public String getLocalityName() {
		return localityName;
	}

	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerGender() {
		return ownerGender;
	}

	public void setOwnerGender(String ownerGender) {
		this.ownerGender = ownerGender;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}

	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Map<String, String> getOwnership() {
		return ownership;
	}

	public void setOwnership(Map<String, String> ownership) {
		this.ownership = ownership;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getTenantGender() {
		return tenantGender;
	}

	public void setTenantGender(String tenantGender) {
		this.tenantGender = tenantGender;
	}

	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}

	public Map<String, String> getEstablishType() {
		return establishType;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setEstablishType(Map<String, String> establishType) {
		this.establishType = establishType;
	}

	public Map<String, String> getBusinessSector() {
		return businessSector;
	}

	public void setBusinessSector(Map<String, String> businessSector) {
		this.businessSector = businessSector;
	}

	public String getLocationCoOrdinates() {
		return locationCoOrdinates;
	}

	public void setLocationCoOrdinates(String locationCoOrdinates) {
		this.locationCoOrdinates = locationCoOrdinates;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public String getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}

	public String getWorkingOffDays() {
		return workingOffDays;
	}

	public void setWorkingOffDays(String workingOffDays) {
		this.workingOffDays = workingOffDays;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
