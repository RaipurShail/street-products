package com.business.form;

public class HomePageFormBean {
	
	private String userName;
	private Character password;
	private String mobileNumber;
	private String emailId;
	private String localeLanguage;
	private String localeFileName;
	private String searchBox;
	private String currentLocation;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Character getPassword() {
		return password;
	}
	public void setPassword(Character password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLocaleLanguage() {
		return localeLanguage;
	}
	public void setLocaleLanguage(String localeLanguage) {
		this.localeLanguage = localeLanguage;
	}
	public String getLocaleFileName() {
		return localeFileName;
	}
	public void setLocaleFileName(String localeFileName) {
		this.localeFileName = localeFileName;
	}
	public String getSearchBox() {
		return searchBox;
	}
	public void setSearchBox(String searchBox) {
		this.searchBox = searchBox;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
}
