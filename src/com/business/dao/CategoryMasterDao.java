package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.form.ProductFormBean;
import com.business.pojo.CategoryMaster;
import com.business.pojo.ProductMaster;

public interface CategoryMasterDao {
	public List<CategoryMaster> getCategories();
	public CategoryMaster getCategory(Long categoryId);
	public Map<Long, String>  getCategoryNames(ProductMaster product);
	Map<Long, String> getCategoryNamesForms(ProductFormBean product);
}
