package com.business.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopmaster")
public class ShopMaster {

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
	private String ownership; /*RENTAL, SELF*/
	private String tenantName;
	private String tenantGender;
	private String establishDate;
	private String establishType; /*SELF OWNED, PARTNERSHIP, PVT LTD, CO OPERATIVE, PUBLIC LTD, RENTAL, TRUST*/
	private String userId;
	private String businessSector; /*PRIVATE, PUBLIC*/
	private String locationCoOrdinates;
	private String workingHours;
	private String workingDays;
	private String workingOffDays;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	
	public ShopMaster() {
		// TODO Auto-generated constructor stub
	}

	public ShopMaster(Long shopId, String shopName, String snNumber, String buildingName,
			String streetName, String landmarkName, String localityName, String country, String state, String district,
			String city, String pincode, String ownerName, String ownerGender, String registrationNumber,
			String primaryContactNumber, String contactNumber, String ownership, String tenantName,
			String tenantGender, String establishDate, String establishType, String userId,
			String businessSector, String locationCoOrdinates, String workingHours, String workingDays,
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

	@Id
	@GeneratedValue
	@Column(name = "shop_id")
	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	@Column(name = "shop_name")
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Column(name = "sn_number")
	public String getSnNumber() {
		return snNumber;
	}

	public void setSnNumber(String snNumber) {
		this.snNumber = snNumber;
	}

	@Column(name = "building_name")
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Column(name = "street_name")
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@Column(name = "landmark_name")
	public String getLandmarkName() {
		return landmarkName;
	}

	public void setLandmarkName(String landmarkName) {
		this.landmarkName = landmarkName;
	}

	@Column(name = "locality_name")
	public String getLocalityName() {
		return localityName;
	}

	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "district")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "pincode")
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Column(name = "owner_name")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Column(name = "owner_gender")
	public String getOwnerGender() {
		return ownerGender;
	}

	public void setOwnerGender(String ownerGender) {
		this.ownerGender = ownerGender;
	}

	@Column(name = "registration_number", unique = true)
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@Column(name = "primary_contact_number")
	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}

	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}

	@Column(name = "contact_number")
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name = "ownership")
	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	@Column(name = "tenant_name")
	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	@Column(name = "tenant_gender")
	public String getTenantGender() {
		return tenantGender;
	}

	public void setTenantGender(String tenantGender) {
		this.tenantGender = tenantGender;
	}

	@Column(name = "establish_date")
	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}

	@Column(name = "establish_type")
	public String getEstablishType() {
		return establishType;
	}
	
	public void setEstablishType(String establishType) {
		this.establishType = establishType;
	}
	
	@Column(name = "user_id")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "business_sector")
	public String getBusinessSector() {
		return businessSector;
	}

	public void setBusinessSector(String businessSector) {
		this.businessSector = businessSector;
	}

	@Column(name = "location_coordinates")
	public String getLocationCoOrdinates() {
		return locationCoOrdinates;
	}

	public void setLocationCoOrdinates(String locationCoOrdinates) {
		this.locationCoOrdinates = locationCoOrdinates;
	}

	@Column(name = "working_hours")
	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	@Column(name = "working_days")
	public String getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}

	@Column(name = "working_off_days")
	public String getWorkingOffDays() {
		return workingOffDays;
	}

	public void setWorkingOffDays(String workingOffDays) {
		this.workingOffDays = workingOffDays;
	}

	@Column(name = "created_date")
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "modified_date")
	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "modified_by")
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