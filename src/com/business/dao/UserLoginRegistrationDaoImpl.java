package com.business.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.business.form.HomePageFormBean;
import com.business.pojo.UserLoginMaster;
import com.business.pojo.UserRegistrationMaster;

@Transactional
public class UserLoginRegistrationDaoImpl implements UserLoginRegistrationDao{
	
	private SessionFactory sessionFactory;
	
	public UserLoginRegistrationDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Map<String, String> validateUser(String emailId, String mobileNumber) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		List<UserRegistrationMaster> userDetailsList = null;
		Map<String, String> userDetailsMap = new HashMap<String, String>();
		try {
			session.getTransaction().begin();
			userDetailsList = (List<UserRegistrationMaster>)session.createCriteria(UserRegistrationMaster.class)
					.add(Restrictions.eq("mobileNumber", mobileNumber))
					.add(Restrictions.eq("emailId", emailId)).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		if(userDetailsList != null && !userDetailsList.isEmpty()){
			for(int i=0; i<userDetailsList.size(); i++){
				userDetailsMap.put("value"+i, userDetailsList.get(i).toString());
			}
		} else {
			userDetailsMap.put("Success", "Success");
		}
		
		session.getTransaction().commit();
		return userDetailsMap;
	}
	
	public void registerUser(HomePageFormBean homePageFormBean) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		String personName = homePageFormBean.getPersonName();
		String password = homePageFormBean.getPassword();
		String loginAs = "C";
		String emailId = homePageFormBean.getEmailId();
		String mobileNumber= homePageFormBean.getMobileNumber();
		String localeLanguage= "ENGLISH";
		String isActive= "Y";
		String location= "Pune";
		String notificationFlag= homePageFormBean.getNotification();
		String createdDate= "2017-09-13 20:13:12";
		String createdBy= "Shail-PC";
		String modifiedDate= "2017-09-13 20:13:12";
		String modifiedBy= "Shail-PC";
		
		UserRegistrationMaster regMaster = new UserRegistrationMaster(personName, password, loginAs, emailId, mobileNumber, localeLanguage, isActive, location, notificationFlag, createdDate, createdBy, modifiedDate, modifiedBy);
		
		try {
			session.getTransaction().begin();
			session.save(regMaster);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
	public void registerLogin(HomePageFormBean homePageFormBean) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		String userName = homePageFormBean.getEmailId();
		String password = homePageFormBean.getPassword();
		String loginAs = "C";
		String loginFlag = "N";
		String localeLanguage= "ENGLISH";
		String isActive= "Y";
		String location= "Pune";
		String createdDate= "2017-09-13 20:13:12";
		String createdBy= "Shail-PC";
		String modifiedDate= "2017-09-13 20:13:12";
		String modifiedBy= "Shail-PC";
		
		UserLoginMaster regMaster = new UserLoginMaster(userName, password, loginAs, loginFlag, localeLanguage, isActive, location, createdDate, createdBy, modifiedDate, modifiedBy);
		
		try {
			session.getTransaction().begin();
			session.save(regMaster);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	@Override
	public Map<String, String> validateLogin(String emailId, String password, String loginAs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		List<UserLoginMaster> userDetailsList = null;
		Map<String, String> userDetailsMap = new HashMap<String, String>();
		try {
			session.getTransaction().begin();
			userDetailsList = (List<UserLoginMaster>)session.createCriteria(UserLoginMaster.class)
					.add(Restrictions.eq("userName", emailId))
					.add(Restrictions.eq("password", password))
					.add(Restrictions.eq("loginAs", loginAs)).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		if(userDetailsList != null && !userDetailsList.isEmpty()){
			for (UserLoginMaster userLoginMaster : userDetailsList) {
				userDetailsMap.put("userName", userLoginMaster.getUserName());
				userDetailsMap.put("password",userLoginMaster.getPassword());
				userDetailsMap.put("loginAs",userLoginMaster.getLoginAs());
				userDetailsMap.put("loginFlag",userLoginMaster.getLoginFlag());
				userDetailsMap.put("localeLanguage",userLoginMaster.getLocaleLanguage());
				userDetailsMap.put("isActive",userLoginMaster.getIsActive());
				userDetailsMap.put("location",userLoginMaster.getLocation());
				userDetailsMap.put("createdDate",userLoginMaster.getCreatedDate());
				userDetailsMap.put("createdBy",userLoginMaster.getCreatedBy());
				userDetailsMap.put("modifiedDate",userLoginMaster.getModifiedDate());
				userDetailsMap.put("modifiedBy",userLoginMaster.getModifiedBy());
			}
		} else {
			System.out.println("Invalid Details...");
		}
		
		session.getTransaction().commit();
		return userDetailsMap;
	}
	
	@Override
	public Map<String, String> getRegisteredUserInfo(String emailId, String loginAs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		List<UserRegistrationMaster> regUserDetailsList = null;
		Map<String, String> userDetailsMap = new HashMap<String, String>();
		try {
			session.getTransaction().begin();
			regUserDetailsList = (List<UserRegistrationMaster>)session.createCriteria(UserRegistrationMaster.class)
					.add(Restrictions.eq("emailId", emailId))
					.add(Restrictions.eq("loginAs", loginAs)).list();
			
			if(regUserDetailsList != null && !regUserDetailsList.isEmpty()){
				
				for (UserRegistrationMaster userRegistrationMaster : regUserDetailsList) {
					userDetailsMap.put("personName", userRegistrationMaster.getPersonName());
					userDetailsMap.put("password",userRegistrationMaster.getPassword());
					userDetailsMap.put("loginAs",userRegistrationMaster.getLoginAs());
					userDetailsMap.put("emailId",userRegistrationMaster.getEmailId());
					userDetailsMap.put("mobileNumber",userRegistrationMaster.getMobileNumber());
					userDetailsMap.put("localeLanguage",userRegistrationMaster.getLocaleLanguage());
					userDetailsMap.put("isActive",userRegistrationMaster.getIsActive());
					userDetailsMap.put("location",userRegistrationMaster.getLocation());
					userDetailsMap.put("notificationFlag",userRegistrationMaster.getNotificationFlag());
					userDetailsMap.put("createdDate",userRegistrationMaster.getCreatedDate());
					userDetailsMap.put("createdBy",userRegistrationMaster.getCreatedBy());
					userDetailsMap.put("modifiedDate",userRegistrationMaster.getModifiedDate());
					userDetailsMap.put("modifiedBy",userRegistrationMaster.getModifiedBy());
				}
				
			} else {
				System.out.println("Invalid Details...");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}		
		session.getTransaction().commit();
		return userDetailsMap;
	}
}