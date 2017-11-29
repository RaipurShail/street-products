package com.business.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.business.dao.ProductMasterDao;
import com.business.form.HomePageFormBean;
import com.business.form.ProductFormBean;
import com.business.pojo.ProductMaster;
import com.business.util.CommonOperation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ProductController {
	
	@Autowired
	private ProductMasterDao productMasterDao;
	
	CommonOperation commonOperation = new CommonOperation();
	
	/*@RequestMapping(value="/addProduct")
	public ModelAndView addProducts(@ModelAttribute("product") ProductMaster product, BindingResult result) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
		product.setCreatedDate(timeStamp);
		product.setCreatedBy(productOperation.getHostName());
		product.setModifiedDate(timeStamp);
		product.setModifiedBy(productOperation.getHostName());
		product.setShopId(1L);
		product.setUserName("shailmodi@street.com");
		System.out.println(product.getProductName());
		if(null != product ) 
			productMasterDao.addProducts(product);

		ModelAndView model = new ModelAndView("addProductsView");
		product=new ProductMaster();
		model.addObject("product", product);
		List<ProductMaster> productList = productMasterDao.getProductList();
		model.addObject("productList", productList);
		return model;
	}*/
	@RequestMapping(value="/addProduct")
	public @ResponseBody String addProducts(@ModelAttribute("product") ProductMaster product, BindingResult result) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
		String jsonInString=null;
		ObjectMapper mapper = new ObjectMapper();
		ProductFormBean productFormBean = new ProductFormBean();
		if(!result.hasErrors() && null != product){
			try {
				product.setCreatedDate(timeStamp);
				product.setCreatedBy(commonOperation.getHostName());
				product.setModifiedDate(timeStamp);
				product.setModifiedBy(commonOperation.getHostName());
				product.setShopId(1L);
				product.setUserName("shailmodi@street.com");
				productMasterDao.addProducts(product); //Insertion to productmaster Table
				
				ModelAndView model = new ModelAndView("addProductsView");
				//product=new ProductMaster();
				model.addObject("product", product);
				List<ProductMaster> productList = productMasterDao.getProductList();
				model.addObject("productList", productList);
			
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productList);
				/*jsonInString=mapper.writeValueAsString(product);
				System.out.println("JSON 2--------");
				System.out.println(jsonInString);*/
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				productFormBean.setErroMessage("Failure: Record is not Inserted");
				e.printStackTrace();
			}
		} else {
			productFormBean.setErroMessage("Failure: Record is not Inserted");
			try {
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(java.util.Arrays.asList(productFormBean));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jsonInString;
	}
	
	/*@RequestMapping(value="/productDescription")
	public ModelAndView productDescriptionView(@ModelAttribute("product") ProductFormBean productForm) {
		ModelAndView model = new ModelAndView("addProductsView");
		Map<Long, String> categoryMap = productMasterDao.getCategoryNamesForms(productForm);
		List<ProductFormBean> categoryList = new ArrayList(categoryMap.values());
		productForm.setCategoryMaster(categoryMap);
		model.addObject("categoryMap", productForm);
		model.addObject("categoryId", categoryMap);
		//model.addObject("categoryName", productForm);
		model.addObject("categoryMaster", productForm);
		return model;
	}*/
	
	@RequestMapping(value="/productDescription")
	public ModelAndView productDescriptionView(@ModelAttribute("homePageDetails") HomePageFormBean homePageForm, HttpSession session) {
		ProductFormBean productForm = new ProductFormBean();
		ModelAndView model = new ModelAndView("addProductsView");
		Map<String, String> homePageFormMap =  (Map<String, String>) session.getAttribute("homePageDetails");
		Map<Long, String> categoryMap = productMasterDao.getCategoryNamesForms(productForm);
		List<ProductFormBean> categoryList = new ArrayList(categoryMap.values());
		
		productForm.setCategoryMaster(categoryMap);
		
		model.addObject("categoryMap", productForm);
		model.addObject("categoryId", categoryMap);
		//model.addObject("categoryName", productForm);
		model.addObject("categoryMaster", productForm);
		model.addObject("product", productForm);
		
		return model;
	}
	
	@RequestMapping(value="/updateProduct")
	public ModelAndView updateProducts(@ModelAttribute("product") ProductMaster product) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
		product.setModifiedDate(timeStamp);
		product.setModifiedBy(commonOperation.getHostName());
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
	public @ResponseBody String showProducts(@ModelAttribute("product") ProductFormBean productFormBean, BindingResult result, HttpSession session) {
		ModelAndView model = new ModelAndView("addProductsView");
		ProductMaster product = new ProductMaster();
		Map<String, String> homePageFormMap =  (Map<String, String>) session.getAttribute("homePageDetails");
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		product=new ProductMaster();
		
		try {
			model.addObject("product", product);
			List<ProductMaster> productList = productMasterDao.getProductList();
			model.addObject("productList", productList);
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			productFormBean.setErroMessage("Failure: Record is not Inserted");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return jsonInString;
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