package com.business.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.business.form.ProductFormBean;
import com.business.pojo.ProductMaster;

public class CommonOperation {

	public CommonOperation CommonOperation() {
		return new CommonOperation();
	}
	
	public String getHostName(){
		String hostName="";
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hostName;
	}
	
	public List<ProductFormBean> getHREFProducts(List<ProductMaster> list, ProductFormBean productBean) {
		String anchorTagOpen = "<a ";
		String href="";
		String anchorTagClose = "</a>";
		String productName = "";
		String manufacturer = "";
		String id=null;
		String action="";
		List<ProductFormBean> productFormList = new ArrayList<>();
		try {
			if(list != null && !list.isEmpty()){
				for (int i = 0; i < list.size(); i++) {
					ProductFormBean productFormBean = new ProductFormBean();
					id = list.get(i).getProductId().toString();
					
					productName=list.get(i).getProductName();
					manufacturer=list.get(i).getManufacturer();
					
					href="href=itemDetailsView.do?productId="+id;
					
					productName= anchorTagOpen+href+">"+productName+anchorTagClose;
					manufacturer= anchorTagOpen+href+">"+manufacturer+anchorTagClose;
					
					productFormBean.setProductId(list.get(i).getProductId().toString());
					productFormBean.setProductName(productName);
					productFormBean.setProductCode(list.get(i).getProductCode());
					productFormBean.setPrice(list.get(i).getPrice());
					productFormBean.setManufacturer(manufacturer);
					productFormBean.setAvailableStock(list.get(i).getAvailableStock());
					productFormBean.setProductCode(list.get(i).getProductCode());
					productFormBean.setShopId(list.get(i).getShopId());
					productFormBean.setProductCode(list.get(i).getProductCode());
					productFormBean.setUserName(list.get(i).getUserName());
					productFormBean.setCategoryId(list.get(i).getCategoryId());
					productFormBean.setCreatedDate(list.get(i).getCreatedDate());
					productFormBean.setCreatedBy(list.get(i).getCreatedBy());
					productFormBean.setModifiedDate(list.get(i).getModifiedDate());
					productFormBean.setModifiedBy(list.get(i).getModifiedBy());
					
					href="href=deleteProducts.do?productId="+id;
					action= anchorTagOpen+href+">"+"DELETE"+anchorTagClose;
					
					productFormBean.setAction(action);
					productFormList.add(productFormBean);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return productFormList;
	}
	
	public ResourceBundle getResourceLanguage(String localeLang){
		ResourceBundle bundle = null;
		if(localeLang != null){
			if(localeLang.toUpperCase().equals("ENGLISH")){
				localeLang = "en";
				Locale locale = new Locale(localeLang, "IN");
				bundle = ResourceBundle.getBundle("com.properties.ApplicationResources", locale);
			} else if(localeLang.toUpperCase().equals("GUJARATI")){
				localeLang = "guj";
				Locale locale = new Locale(localeLang, "IN");
				bundle = ResourceBundle.getBundle("com.properties.ApplicationResources", locale);
			} else if(localeLang.toUpperCase().equals("HINDI")){
				localeLang = "hin";
				Locale locale = new Locale(localeLang, "IN");
				bundle = ResourceBundle.getBundle("com.properties.ApplicationResources", locale);
			} else {
				localeLang = "en";
				Locale locale = new Locale(localeLang, "IN");
				bundle = ResourceBundle.getBundle("com.properties.ApplicationResources", locale);
			}
		} else {
			localeLang = "en";
			Locale locale = new Locale(localeLang, "IN");
			bundle = ResourceBundle.getBundle("com.properties.ApplicationResources", locale);
		}
		return bundle;
	}
	
	public Map<String, String> getI18Language(){
		Map<String, String> languageMap = new HashMap<String, String>();
		languageMap.put("eng", "English");
		languageMap.put("hin", "Hindi");
		languageMap.put("guj", "Gujarati");
		return languageMap;
	}
}