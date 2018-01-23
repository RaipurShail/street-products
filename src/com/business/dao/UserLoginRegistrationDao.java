package com.business.dao;

import java.util.Map;

import com.business.form.HomePageFormBean;

public interface UserLoginRegistrationDao {
	public void registerUser(HomePageFormBean homePageForm);
	public void registerLogin(HomePageFormBean homePageForm);
	public Map<String, String> validateUser(String emailId, String mobileNumber);
	public Map<String, String> validateLogin(String emailId, String password, String loginAs);
	Map<String, String> getRegisteredUserInfo(String emailId, String loginAs);
}
