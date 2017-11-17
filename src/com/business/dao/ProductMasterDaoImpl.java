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
public class ProductMasterDaoImpl implements ProductMasterDao {

	private SessionFactory sessionFactory;

	public ProductMasterDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProducts(ProductMaster product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			session.save(product);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	@Override
	public List<ProductMaster> getProductList() {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		List<ProductMaster> products = null;
		// Integer categoryId = product.getCategoryId().intValue();

		try {
			System.out.println("IN LIST");
			products = (List<ProductMaster>) session.createQuery("from ProductMaster").list();
			/*
			 * Criteria criteria = session.createCriteria(CategoryMaster.class)
			 * .add(Restrictions.eq("categoryId", product.getCategoryId()));
			 * products = criteria.list();
			 */
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return products;
	}

	@Override
	public ProductMaster getProduct(Long productId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		ProductMaster product = null;
		try {
			session.getTransaction().begin();
			product = (ProductMaster) session.get(ProductMaster.class, productId);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return product;
	}

	@Override
	public void deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ProductMaster product = null;
		try {
			session.getTransaction().begin();
			product = (ProductMaster) session.get(ProductMaster.class, productId);
			if (null != product) {
				session.delete(product);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	@Override
	public void updateProducts(ProductMaster product) {
		// TODO Auto-generated method stub
		String hql = "";
		int updatedResult = 0;
		Transaction transaction = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();

			hql = "update ProductMaster p set p.productName = :updatedProductName, "
					+ "p.productCode = :updatedProductCode, p.price = :updatedPrice, "
					+ "p.manufacturer = :updatedManufaturer, p.availableStock = :updatedAvailableStock, "
					+ "p.categoryId = :updatedCategoryId, p.modifiedDate = :updatedModifiedDate, "
					+ "p.modifiedBy = :updatedModifiedBy where p.productId = :productId";

			updatedResult = session.createQuery(hql).setString("updatedProductName", product.getProductName())
					.setString("updatedProductCode", product.getProductCode())
					.setFloat("updatedPrice", product.getPrice())
					.setString("updatedManufaturer", product.getManufacturer())
					.setInteger("updatedAvailableStock", product.getAvailableStock())
					.setLong("updatedCategoryId", product.getCategoryId())
					.setString("updatedModifiedDate", product.getModifiedDate())
					.setString("updatedModifiedBy", product.getModifiedBy())
					.setLong("productId", product.getProductId()).executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
	@Override
	public Map<Long, String> getCategoryNamesForms(ProductFormBean product) {
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
			
			categoryList = criteria.list();
			session.getTransaction().commit();
			
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
}