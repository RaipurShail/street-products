package com.business.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.business.dao.UserLoginRegistrationDao;
import com.business.form.HomePageFormBean;
import com.business.util.CommonOperation;

@Controller
public class HomePageController {

	@Autowired
	private UserLoginRegistrationDao userLoginRegistrationDao;

	CommonOperation commonOperation = new CommonOperation();
	Logger log = Logger.getLogger(HomePageController.class);

	@RequestMapping("/")
	public ModelAndView onStartup(@ModelAttribute("homePageDetails") HomePageFormBean homePageForm,
			HttpSession session) {
		// TODO Auto-generated constructor stub
		log.info("ENTER - Method onStartup");
		ModelAndView model = new ModelAndView("index");
		try {
			log.info("ENTER - Method onStartup - try block");
			
			Map<String, String> languageMap = commonOperation.getI18Language();
			homePageForm.setLocaleFileName("com.properties.ApplicationMessages_en_IN");
			homePageForm.setLocaleLanguage("ENGLISH");
			Map<String, String> homePageFormMap = new ConcurrentHashMap<String, String>();
			homePageFormMap.put("language", homePageForm.getLocaleLanguage());
			homePageFormMap.put("languageFile", homePageForm.getLocaleFileName());
			session.setAttribute("homePageDetails", homePageFormMap);
			model.addObject("langMap", languageMap);
			model.addObject("homePageFormBean", homePageForm);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("EXCEPTION - Method onStartup", e);
		}
		log.info("EXIT - Method onStartup");
		return model;
	}

	@RequestMapping(value = "/homePageFormDetails")
	public ModelAndView setI18Language(@ModelAttribute("homePageDetails") HomePageFormBean homePageForm,
			BindingResult result, HttpSession session) {
		log.info("ENTER - Method setI18Language");
		String localeLang = null;
		Map<String, String> homePageFormMap = new ConcurrentHashMap<String, String>();
		ModelAndView model = new ModelAndView("index");
		if (null != homePageForm && homePageForm != null) {
			log.info("ENTER - Method setI18Language - If block - homePageForm is not NULL");
			localeLang = homePageForm.getLocaleLanguage();//guj
		} else {
			log.info("ENTER - Method setI18Language - Else block - homePageForm is NULL, set DEFAULT "
					+ "Language ENGLISH");
			localeLang = "ENGLISH";
		}
		if (localeLang != null) {
			log.info("ENTER - Method setI18Language - If block - localeLang is not NULL");
			if (localeLang.toLowerCase().equals("eng")) {
				log.info("ENTER - Method setI18Language - If block - localeLang ENGLISH");
				homePageForm.setLocaleLanguage("ENGLISH");
				homePageForm.setLocaleFileName("com.properties.ApplicationMessages_en_IN");
			} else if (localeLang.toLowerCase().equals("guj")) {
				log.info("ENTER - Method setLocaleLanguage - If block - localeLang GUJARATI");
				homePageForm.setLocaleLanguage("GUJARATI");
				homePageForm.setLocaleFileName("com.properties.ApplicationMessages_guj_IN");
			} else if (localeLang.toLowerCase().equals("hin")) {
				log.info("ENTER - Method setLocaleLanguage - If block - localeLang HINDI");
				homePageForm.setLocaleLanguage("HINDI");
				homePageForm.setLocaleFileName("com.properties.ApplicationMessages_hin_IN");
			} else {
				log.info("ENTER - Method setLocaleLanguage - If block - localeLang ENGLISH");
				homePageForm.setLocaleLanguage("ENGLISH");
				homePageForm.setLocaleFileName("com.properties.ApplicationMessages_en_IN");
			}
			homePageFormMap.put("language", homePageForm.getLocaleLanguage());
			homePageFormMap.put("languageFile", homePageForm.getLocaleFileName());
			session.setAttribute("homePageDetails", homePageFormMap);
		}
		Map<String, String> languageMap = commonOperation.getI18Language();
		model.addObject("langMap", languageMap);
		model.addObject("homePageFormBean", homePageForm);
		log.info("EXIT - Method setI18Language");
		return model;
	}

	@RequestMapping(value = "/userLogin")
	public ModelAndView userSignIn(@ModelAttribute("homePageDetails") HomePageFormBean homePageForm,
			BindingResult result, HttpSession session) {
		log.info("ENTER - Method userSignIn");
		ModelAndView model = null;
		Map<String, String> homePageUserDtlsMap = null;
		if(null != session){
			homePageUserDtlsMap = (Map<String, String>) session.getAttribute("homePageDetails");
			if(null != homePageUserDtlsMap && !homePageUserDtlsMap.isEmpty()){
				Iterator itr = homePageUserDtlsMap.entrySet().iterator();
				while (itr.hasNext()) {
					Map.Entry<String, String> map = (Map.Entry<String, String>) itr.next();
					if(map.getKey().equals("language")){
						homePageForm.setLocaleLanguage(map.getValue());
					} else if(map.getKey().equals("languageFile")){
						homePageForm.setLocaleFileName(map.getValue());
					}
				}
			}
		}

		ResourceBundle bundle = commonOperation.getResourceLanguage(homePageForm.getLocaleLanguage());

		String emailId = null;
		String password = null;
		String loginAs = null;
		if (null != homePageForm) {
			emailId = homePageForm.getEmailId();
			loginAs = homePageForm.getLoginAs();
			Map<String, String> homePageFormMap = new ConcurrentHashMap<String, String>();
			if (loginAs != null && loginAs.equals("C")) {
				password = homePageForm.getCustomerPassword();
			} else if (loginAs != null && loginAs.equals("S")) {
				password = homePageForm.getShopOwnerPassword();
			}
			homePageFormMap = userLoginRegistrationDao.validateLogin(emailId, password, loginAs);
			if (null != homePageFormMap && !homePageFormMap.isEmpty()) {
				model = new ModelAndView("index");
				homePageFormMap = userLoginRegistrationDao.getRegisteredUserInfo(emailId, loginAs);
				homePageFormMap.putAll(homePageUserDtlsMap);
				session.setAttribute("homePageDetails", homePageFormMap);
				System.out.println("Login Allowed");
			} else {
				model = new ModelAndView("index");
				System.out.println("Invalid Details");
			}
		} else {
			// model = new ModelAndView("common/errorPage", "errorAttribute",
			// "Site Has an Error");
			String errorMessage = bundle.getString("common.error.message");
			model = new ModelAndView("common/errorPage");
			model.addObject("errorMsg", errorMessage);
		}
		return model;
	}

	@RequestMapping(value = "/userRegistration")
	public ModelAndView userRegistration(@ModelAttribute("homePageDetails") HomePageFormBean homePageForm,
			BindingResult result, HttpSession session) {
		log.info("ENTER - Method userRegistration");
		ModelAndView model = null;
		Map<String, String> homePageUserDtlsMap = null;
		String localeLang = null;
		String emailId = null;
		String mobileNumber = null;
		if(null != session){
			homePageUserDtlsMap = (Map<String, String>) session.getAttribute("homePageDetails");
		}

		Map<String, String> homePageFormMap = new HashMap<String, String>();

		if (null != homePageForm) {
			emailId = homePageForm.getEmailId();
			mobileNumber = homePageForm.getMobileNumber();
			homePageFormMap = userLoginRegistrationDao.validateUser(emailId, mobileNumber);
			if (null != homePageFormMap && homePageFormMap.get("Success").equals("Success")) {
				userLoginRegistrationDao.registerUser(homePageForm);
				userLoginRegistrationDao.registerLogin(homePageForm);
			} else {
				Iterator itr = homePageFormMap.entrySet().iterator();
				while (itr.hasNext()) {
					Map.Entry<String, String> map = (Map.Entry<String, String>) itr.next();
					System.out.println(map.getKey());
					System.out.println(map.getValue());
				}
			}
			model = new ModelAndView("index");
		} else {
			model = new ModelAndView("errorPage");
		}
		return model;
	}

	@RequestMapping(value = "/errorPage")
	public ModelAndView handleErrorMessage(@ModelAttribute("errorAttribute") HomePageFormBean homePageForm) {
		log.info("ENTER - Method handleErrorMessage");
		ModelAndView model = new ModelAndView("index");
		return model;
	}

}
