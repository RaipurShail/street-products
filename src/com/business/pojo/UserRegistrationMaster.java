package com.business.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userregistrationmaster")
public class UserRegistrationMaster {

	private static final long serialVersionUID = 453693552059515150L;
	private Long registerId;
	private String personName;
	private String password;
	private String loginAs;
	private String emailId;
	private String mobileNumber;
	private String localeLanguage;
	private String isActive;
	private String location;
	private String notificationFlag;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;

	public UserRegistrationMaster(String personName, String password, String loginAs, String emailId,
			String mobileNumber, String localeLanguage, String isActive, String location, String notificationFlag,
			String createdDate, String createdBy, String modifiedDate, String modifiedBy) {
		super();
		//this.registerId = registerId;
		this.personName = personName;
		this.password = password;
		this.loginAs = loginAs;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.localeLanguage = localeLanguage;
		this.isActive = isActive;
		this.location = location;
		this.notificationFlag = notificationFlag;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
	}
	
	public UserRegistrationMaster() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	@Column(name = "register_id")
	public Long getRegisterId() {
		return registerId;
	}
	public void setRegisterId(Long registerId) {
		this.registerId = registerId;
	}
	
	@Column(name = "person_name")
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "login_as")
	public String getLoginAs() {
		return loginAs;
	}
	public void setLoginAs(String loginAs) {
		this.loginAs = loginAs;
	}

	@Column(name = "email_id")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "mobile_number")
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "locale_language")
	public String getLocaleLanguage() {
		return localeLanguage;
	}
	public void setLocaleLanguage(String localeLanguage) {
		this.localeLanguage = localeLanguage;
	}
	
	@Column(name = "current_location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@Column(name = "notification_flag")
	public String getNotificationFlag() {
		return notificationFlag;
	}

	public void setNotificationFlag(String notificationFlag) {
		this.notificationFlag = notificationFlag;
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