package com.business.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.business.dao.CategoryMasterDao;
import com.business.form.ProductFormBean;

@Controller
public class RegisterBusiness {
	
	@Autowired
	private CategoryMasterDao categoryMasterDao;
	
	@RequestMapping(value="/registerBusiness")
	//public ModelAndView watchBusiness(@ModelAttribute("product") ProductMaster product, ProductFormBean bean) {
	public ModelAndView watchBusiness(@ModelAttribute("product") ProductFormBean productForm) {
		ModelAndView model = new ModelAndView("addProductsView");
		Map<Long, String> categoryMap = categoryMasterDao.getCategoryNamesForms(productForm);
		List<ProductFormBean> categoryList = new ArrayList(categoryMap.values());
		productForm.setCategoryMaster(categoryMap);
		model.addObject("categoryMap", productForm);
		model.addObject("categoryId", categoryMap);
		//model.addObject("categoryName", productForm);
		model.addObject("categoryMaster", productForm);
		return model;
	}
	
}
