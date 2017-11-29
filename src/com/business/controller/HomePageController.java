package com.business.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.business.form.HomePageFormBean;
import com.business.util.CommonOperation;

@Controller
public class HomePageController {
	
	CommonOperation commonOperation = new CommonOperation();
	
	@RequestMapping(value="/homePageFormDetails")
	public ModelAndView setLocaleLanguage(@ModelAttribute("homePageDetails") HomePageFormBean homePageForm, BindingResult result, HttpSession session) {
		String localeLang = null;
		Map<String, String> homePageFormMap = new ConcurrentHashMap<String, String>();
		ModelAndView model = new ModelAndView("index");
		if(null != homePageForm && homePageForm != null){
			localeLang = homePageForm.getLocaleLanguage();
		}
		if(localeLang != null){
			if(localeLang.equals("ENGLISH")){
				homePageForm.setLocaleLanguage("ENGLISH");
				homePageForm.setLocaleFileName("com.properties.ApplicationMessages");
			} else if(localeLang.equals("GUJARATI")){
				homePageForm.setLocaleLanguage("GUJARATI");
				homePageForm.setLocaleFileName("com.properties.ApplicationMessages_Guj");
			} else if(localeLang.equals("HINDI")){
				homePageForm.setLocaleLanguage("HINDI");
				homePageForm.setLocaleFileName("com.properties.ApplicationMessages_Hin");
			} else {
				homePageForm.setLocaleLanguage("ENGLISH");
				homePageForm.setLocaleFileName("com.properties.ApplicationMessages");
			}
			homePageFormMap.put("language", homePageForm.getLocaleLanguage());
			homePageFormMap.put("languageFile", homePageForm.getLocaleFileName());
			session.setAttribute("homePageDetails", homePageFormMap);
		}
		model.addObject("homePageFormBean", homePageForm);
		return model;
	}
}
