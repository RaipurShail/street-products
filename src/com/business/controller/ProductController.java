package com.business.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class ProductController {
	
	@Autowired
	private ProductMasterDao productMasterDao;
	
	CommonOperation commonOperation = new CommonOperation();
	Logger log = Logger.getLogger(ProductController.class);
	
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
	
	@RequestMapping(value="/searchProduct")
	public @ResponseBody String searchProducts(@ModelAttribute("homePageDetails") HomePageFormBean homePageForm,
			HttpSession session, BindingResult result) {
		log.info("ENTER - Method searchProducts");
		List<ProductMaster> searchResult = null;
		String jsonInString=null;
		ObjectWriter o = null;
		ObjectMapper mapper = new ObjectMapper();
		
		String searchValue = homePageForm.getSearchProducthBar();
		System.out.println(searchValue);
		System.out.println(searchValue.trim());
		
		if(searchValue != null && !searchValue.isEmpty()){
			searchResult = productMasterDao.getSearchResult(searchValue.trim());
		}
				
		if(searchResult != null){
			try {
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(java.util.Arrays.asList(searchResult));
				System.out.println(jsonInString);
				
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(searchResult);
				System.out.println(jsonInString);
				
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return jsonInString;
	}
	
	@RequestMapping(value="/addProduct")
	public @ResponseBody String addProducts(@ModelAttribute("product") ProductMaster product, BindingResult result) {
		log.info("ENTER - Method addProducts");
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
		String jsonInString=null;
		ObjectMapper mapper = new ObjectMapper();
		ProductFormBean productFormBean = new ProductFormBean();
		if(!result.hasErrors() && null != product){
			log.info("ENTER - Method addProducts - If block - BindingResult Success");
			try {
				log.info("ENTER - Method addProducts - try block");
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
				List<ProductFormBean> productFormList =commonOperation.getHREFProducts(productList, productFormBean);
				model.addObject("productList", productFormList);
			
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productFormList);
				/*jsonInString=mapper.writeValueAsString(product);
				System.out.println("JSON 2--------");
				System.out.println(jsonInString);*/
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				log.error("EXCEPTION JSON - Method addProducts", e);
				productFormBean.setErroMessage("Failure: Record is not Inserted");
			}
		} else {
			log.info("ENTER - Method addProducts - Else block - BindingResult Failure");
			productFormBean.setErroMessage("Failure: Record is not Inserted");
			try {
				log.info("ENTER - Method addProducts - try block");
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(java.util.Arrays.asList(productFormBean));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				log.error("EXCEPTION JSON - Method addProducts", e);
				e.printStackTrace();
			}
		}
		log.info("EXIT - Method addProducts");
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
		log.info("ENTER - Method productDescriptionView");
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
		
		log.info("EXIT - Method productDescriptionView");
		return model;
	}
	
	@RequestMapping(value="/updateProduct")
	public ModelAndView updateProducts(@ModelAttribute("product") ProductMaster product) {
		log.info("ENTER - Method updateProducts");
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
		log.info("EXIT - Method updateProducts");
		return model;
	}
	
	@RequestMapping(value="/showAllProducts")
	public @ResponseBody String showProducts(@ModelAttribute("product") ProductFormBean productFormBean, BindingResult result, HttpSession session) {
		log.info("ENTER - Method showProducts");
		ModelAndView model = new ModelAndView("addProductsView");
		Map<String, String> homePageFormMap =  (Map<String, String>) session.getAttribute("homePageDetails");
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		
		try {
			log.info("ENTER - Method showProducts - try block");
			List<ProductMaster> productList = productMasterDao.getProductList();
			List<ProductFormBean> productFormList =commonOperation.getHREFProducts(productList, productFormBean);
			model.addObject("productList", productFormList);
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productFormList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("EXCEPTION JSON - Method showProducts", e);
			productFormBean.setErroMessage("Failure: Record is not Inserted");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("EXCEPTION - Method showProducts", e);
		}
		log.info("EXIT - Method showProducts");
		return jsonInString;
	}
	
	@RequestMapping(value="/editProducts")
	public ModelAndView editProduct(@RequestParam(value="productId", required=true) Long productId) {
		log.info("ENTER - Method editProduct");
		ProductMaster product = productMasterDao.getProduct(productId);
		ModelAndView model = new ModelAndView("addProductsView");
		model.addObject("product", product);
		List<ProductMaster> productList = productMasterDao.getProductList();
		model.addObject("productList", productList);
		log.info("EXIT - Method editProduct");
		return model;
	}
	
	@RequestMapping(value="/deleteProducts")
	public ModelAndView deleteProduct(@RequestParam(value="productId", required=true) Long productId, @ModelAttribute("product") ProductFormBean productFormBean) {
		log.info("ENTER - Method deleteProduct");
		productMasterDao.deleteProduct(productId);
		ModelAndView model = new ModelAndView("addProductsView");
		List<ProductMaster> productList = productMasterDao.getProductList();
		model.addObject("productList", productList);
		log.info("EXIT - Method deleteProduct");
		return model;
	}
	
	@RequestMapping(value="/itemDetailsView")
	public ModelAndView itemDescription(@RequestParam(value="productId", required=true) Long productId, @ModelAttribute("product") ProductMaster product) {
		log.info("ENTER - Method itemDescription");
		product=new ProductMaster();
		ModelAndView model = new ModelAndView("ItemMasterList");
		List<ProductMaster> productList = productMasterDao.getProductList();
		model.addObject("itemList", productList);
		log.info("EXIT - Method itemDescription");
		return model;
	}
}