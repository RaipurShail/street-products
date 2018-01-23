package com.business.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.business.dao.ShopMasterDao;
import com.business.form.ShopRegistrationFormBean;
import com.business.pojo.ShopMaster;
import com.business.util.CommonOperation;

@Controller
public class ShopRegistrationController {
	
	@Autowired
	private ShopMasterDao shopMasterDao;
	
	CommonOperation commonOperation = new CommonOperation();
	Logger log = Logger.getLogger(ShopRegistrationController.class);
	
	@RequestMapping(value="/shopDescription")
	public ModelAndView shopDescriptionView(@ModelAttribute("shop") ShopRegistrationFormBean shopForm) {
		log.info("ENTER - Method shopDescriptionView");
		ModelAndView model = new ModelAndView("shopRegistration");
		Map<Long, String> categoryMap = null;// shopMasterDao.getCategoryNamesForms(productForm);
		//List<ProductFormBean> categoryList = new ArrayList(categoryMap.values());
		model.addObject("shop", shopForm);
		log.info("EXIT - Method shopDescriptionView");
		return model;
	}
	
	@RequestMapping(value="/shopRegistration", method=RequestMethod.POST)
	public ModelAndView shopRegistration(@ModelAttribute("shop") ShopMaster shop, BindingResult result) {
		log.info("ENTER - Method shopRegistration");
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
		
		if(null != shop){
			log.info("ENTER - Method shopRegistration - If block - shop is not NULL");
			shop.setCreatedDate(timeStamp);
			shop.setCreatedBy(commonOperation.getHostName());
			shop.setModifiedDate(timeStamp);
			shop.setModifiedBy(commonOperation.getHostName());
			shopMasterDao.registerShop(shop);
		}

		ModelAndView model = new ModelAndView("shopRegistration");
		model.addObject("shop", shop);
		log.info("EXIT - Method shopRegistration");
		return model;
	}
	
}
