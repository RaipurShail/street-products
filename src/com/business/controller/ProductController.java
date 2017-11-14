package com.business.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.business.dao.ProductMasterDao;
import com.business.pojo.ProductMaster;
import com.business.util.ProductOperation;

@Controller
public class ProductController {
	
	@Autowired
	private ProductMasterDao productMasterDao;
	
	ProductOperation productOperation = new ProductOperation();
		
	@RequestMapping(value="/addProduct")
	public ModelAndView addProducts(@ModelAttribute("product") ProductMaster product, BindingResult result) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
		product.setCreatedDate(timeStamp);
		product.setCreatedBy(productOperation.getHostName());
		product.setModifiedDate(timeStamp);
		product.setModifiedBy(productOperation.getHostName());
		System.out.println(product.getProductName());
		if(null != product ) 
			productMasterDao.addProducts(product);

		ModelAndView model = new ModelAndView("addProductsView");
		product=new ProductMaster();
		model.addObject("product", product);
		List<ProductMaster> productList = productMasterDao.getProductList();
		model.addObject("productList", productList);
		return model;
	}
	
	@RequestMapping(value="/updateProduct")
	public ModelAndView updateProducts(@ModelAttribute("product") ProductMaster product) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
		product.setModifiedDate(timeStamp);
		product.setModifiedBy(productOperation.getHostName());
		if(null != product ) 
			productMasterDao.updateProducts(product);

		ModelAndView model = new ModelAndView("addProductsView");
		product=new ProductMaster();
		model.addObject("product", product);
		List<ProductMaster> productList = productMasterDao.getProductList();
		model.addObject("productList", productList);
		return model;
	}
	
	@RequestMapping(value="/showAllProducts")
	public ModelAndView showProducts(@ModelAttribute("product") ProductMaster product) {
		ModelAndView model = new ModelAndView("addProductsView");
		product=new ProductMaster();
		model.addObject("product", product);
		List<ProductMaster> productList = productMasterDao.getProductList();
		model.addObject("productList", productList);
		return model;
	}
	
	@RequestMapping(value="/editProducts")
	public ModelAndView editProduct(@RequestParam(value="productId", required=true) Long productId) {
		ProductMaster product = productMasterDao.getProduct(productId);
		ModelAndView model = new ModelAndView("addProductsView");
		model.addObject("product", product);
		List<ProductMaster> productList = productMasterDao.getProductList();
		model.addObject("productList", productList);
		return model;
	}
	
	@RequestMapping(value="/deleteProducts")
	public ModelAndView deleteProduct(@RequestParam(value="productId", required=true) Long productId, @ModelAttribute("product") ProductMaster product) {
		productMasterDao.deleteProduct(productId);
		product=new ProductMaster();
		ModelAndView model = new ModelAndView("addProductsView");
		List<ProductMaster> productList = productMasterDao.getProductList();
		model.addObject("productList", productList);
		return model;
	}
}