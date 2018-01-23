package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.form.ProductFormBean;
import com.business.pojo.ProductMaster;

public interface ProductMasterDao {
	public void addProducts(ProductMaster product);
	public List<ProductMaster>  getProductList();
	public ProductMaster getProduct(Long productId);
	public void deleteProduct(Long productId);
	public void updateProducts(ProductMaster product);
	Map<Long, String> getCategoryNamesForms(ProductFormBean product);
	public List<ProductMaster> getSearchResult(String searchValue);
}
