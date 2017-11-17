package com.business.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.business.dao.ShopMasterDao;
import com.business.form.ProductFormBean;
import com.business.form.ShopRegistrationFormBean;

@Controller
public class ShopRegistrationController {
	
	@Autowired
	private ShopMasterDao shopMasterDao;
	
	@RequestMapping(value="/shopDescription")
	public ModelAndView shopDescriptionView(@ModelAttribute("shop") ShopRegistrationFormBean shopForm) {
		ModelAndView model = new ModelAndView("shopRegistration");
		Map<Long, String> categoryMap = null;// shopMasterDao.getCategoryNamesForms(productForm);
		List<ProductFormBean> categoryList = new ArrayList(categoryMap.values());
		//shopForm.setCategoryMaster(categoryMap);
		model.addObject("categoryMap", shopForm);
		model.addObject("categoryId", categoryMap);
		model.addObject("categoryMaster", shopForm);
		return model;
	}
	
}
