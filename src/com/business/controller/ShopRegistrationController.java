package com.business.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

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
	
	@RequestMapping(value="/shopDescription")
	public ModelAndView shopDescriptionView(@ModelAttribute("shop") ShopRegistrationFormBean shopForm) {
		ModelAndView model = new ModelAndView("shopRegistration");
		Map<Long, String> categoryMap = null;// shopMasterDao.getCategoryNamesForms(productForm);
		//List<ProductFormBean> categoryList = new ArrayList(categoryMap.values());
		model.addObject("shop", shopForm);
		return model;
	}
	
	@RequestMapping(value="/shopRegistration", method=RequestMethod.POST)
	public ModelAndView shopRegistration(@ModelAttribute("shop") ShopMaster shop, BindingResult result) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
		
		if(null != shop){
			shop.setCreatedDate(timeStamp);
			shop.setCreatedBy(commonOperation.getHostName());
			shop.setModifiedDate(timeStamp);
			shop.setModifiedBy(commonOperation.getHostName());
			shopMasterDao.registerShop(shop);
		}

		ModelAndView model = new ModelAndView("shopRegistration");
		model.addObject("shop", shop);
		return model;
	}
	
}
