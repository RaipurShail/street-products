package com.business.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userloginmaster")
public class UserLoginMaster {

	private static final long serialVersionUID = 453693552059515150L;
	private Long loginId;
	private String userName;
	private String password;
	private String loginAs;
	private String loginFlag;
	private String localeLanguage;
	private String isActive;
	private String location;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	
	
	public UserLoginMaster(String userName, String password, String loginAs, String loginFlag,
			String localeLanguage, String isActive, String location, String createdDate, String createdBy,
			String modifiedDate, String modifiedBy) {
		super();
		//this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.loginAs = loginAs;
		this.loginFlag = loginFlag;
		this.localeLanguage = localeLanguage;
		this.isActive = isActive;
		this.location = location;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
	}
	
	public UserLoginMaster() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	@Column(name = "login_id")
	public Long getLoginId() {
		return loginId;
	}
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	
	@Column(name = "username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	@Column(name = "login_flag")
	public String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	
	@Column(name = "locale_language")
	public String getLocaleLanguage() {
		return localeLanguage;
	}
	public void setLocaleLanguage(String localeLanguage) {
		this.localeLanguage = localeLanguage;
	}
	
	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@Column(name = "current_location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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