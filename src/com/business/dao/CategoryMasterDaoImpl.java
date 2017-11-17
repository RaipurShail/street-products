package com.business.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.business.form.ProductFormBean;
import com.business.pojo.CategoryMaster;
import com.business.pojo.ProductMaster;

@Transactional
public class CategoryMasterDaoImpl implements CategoryMasterDao{
	
	private SessionFactory sessionFactory;
	
	public CategoryMasterDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CategoryMaster> getCategories() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<CategoryMaster> category = null;
		try {
			session.getTransaction().begin();
			category = (List<CategoryMaster>)session.createQuery("from CategoryMaster").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return category;
	}

	@Override
	public Map<Long, String> getCategoryNames(ProductMaster product) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Criteria criteria = null;
		
		List<CategoryMaster> categoryList = null;
		Map<Long, String> categoryMap = new HashMap<>();
		
		Long categoryId =  null;
		String productName = null;
		
		Session session = sessionFactory.getCurrentSession();
		try{
			session.getTransaction().begin();
			if(null != product.getCategoryId() && product.getCategoryId() != 0){
				categoryId = product.getCategoryId();
				criteria = session.createCriteria(CategoryMaster.class)
						.add(Restrictions.eq("categoryId", categoryId));
			} else {
				criteria = session.createCriteria(CategoryMaster.class);
			}
			session.getTransaction().commit();
			
			categoryList = criteria.list();
			
			if(!categoryList.isEmpty()){
				for (CategoryMaster master : categoryList) {
					
					categoryId = master.getCategoryId();
					productName = master.getCategoryName();
					
					categoryMap.put(categoryId, productName);
				}
			}
		} catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return categoryMap;
	}

	@Override
	public CategoryMaster getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}
}