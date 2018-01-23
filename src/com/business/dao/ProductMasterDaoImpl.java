package com.business.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
	Logger log = Logger.getLogger(ProductMasterDaoImpl.class);

	public ProductMasterDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		log.info("ENTER - Constructor ProductMasterDaoImpl - Initialized sessionFactory");
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProducts(ProductMaster product) {
		// TODO Auto-generated method stub
		log.info("ENTER - Method addProducts");
		Session session = sessionFactory.getCurrentSession();
		try {
			log.info("ENTER - Method addProducts - try block");
			session.getTransaction().begin();
			session.save(product);
			session.getTransaction().commit();
			log.info("ENTER - Method addProducts - try block - Record Inserted Successfully");
		} catch (HibernateException e) {
			log.error("EXCEPTION Hibernate - Method addProducts", e);
			session.getTransaction().rollback();
		}
		log.info("EXIT - Method addProducts");
	}

	@Override
	public List<ProductMaster> getProductList() {
		// TODO Auto-generated method stub
		log.info("ENTER - Method getProductList");
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		List<ProductMaster> products = null;
		// Integer categoryId = product.getCategoryId().intValue();

		try {
			log.info("ENTER - Method getProductList - try block");
			products = (List<ProductMaster>) session.createQuery("from ProductMaster").list();
			session.getTransaction().commit();
			/*
			 * Criteria criteria = session.createCriteria(CategoryMaster.class)
			 * .add(Restrictions.eq("categoryId", product.getCategoryId()));
			 * products = criteria.list();
			 */
			log.info("ENTER - Method getProductList - try block - Fetched Data Successfully");
		} catch (HibernateException e) {
			log.error("EXCEPTION Hibernate - Method getProductList", e);
			session.getTransaction().rollback();
		}
		log.info("EXIT - Method getProductList");
		return products;
	}

	@Override
	public ProductMaster getProduct(Long productId) {
		// TODO Auto-generated method stub
		log.info("ENTER - Method getProduct");
		Session session = sessionFactory.getCurrentSession();
		ProductMaster product = null;
		try {
			log.info("ENTER - Method getProduct - try block");
			session.getTransaction().begin();
			product = (ProductMaster) session.get(ProductMaster.class, productId);
			log.info("ENTER - Method getProduct - try block - Fetched Data Successfully");
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("EXCEPTION Hibernate - Method getProduct", e);
			session.getTransaction().rollback();
		}
		log.info("EXIT - Method getProduct");
		return product;
	}

	@Override
	public void deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		log.info("ENTER - Method deleteProduct");
		Session session = sessionFactory.getCurrentSession();
		ProductMaster product = null;
		try {
			log.info("ENTER - Method deleteProduct - try block");
			session.getTransaction().begin();
			product = (ProductMaster) session.get(ProductMaster.class, productId);
			if (null != product) {
				log.info("ENTER - Method deleteProduct - try block - product is not NULL");
				session.delete(product);
			}
			log.info("ENTER - Method deleteProduct - try block - Data deleted Successfully");
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("EXCEPTION Hibernate - Method deleteProduct", e);
			session.getTransaction().rollback();
		}
		log.info("EXIT - Method deleteProduct");
	}

	@Override
	public void updateProducts(ProductMaster product) {
		// TODO Auto-generated method stub
		log.info("ENTER - Method updateProducts");
		String hql = "";
		int updatedResult = 0;
		Transaction transaction = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			log.info("ENTER - Method updateProducts - try block");
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
			log.info("ENTER - Method updateProducts - try block - Record updated Successfully");
		} catch (HibernateException e) {
			log.error("EXCEPTION Hibernate - Method updateProducts", e);
			session.getTransaction().rollback();
		}
		log.info("EXIT - Method updateProducts");
	}
	
	@Override
	public Map<Long, String> getCategoryNamesForms(ProductFormBean product) {
		// TODO Auto-generated method stub
		log.info("ENTER - Method getCategoryNamesForms");
		Transaction transaction = null;
		Criteria criteria = null;
		
		List<CategoryMaster> categoryList = null;
		Map<Long, String> categoryMap = new HashMap<>();
		
		Long categoryId =  null;
		String productName = null;
		
		Session session = sessionFactory.getCurrentSession();
		try{
			log.info("ENTER - Method getCategoryNamesForms - try block");
			session.getTransaction().begin();
			if(null != product.getCategoryId() && product.getCategoryId() != 0){
				log.info("ENTER - Method getCategoryNamesForms - try block - If block - categoryId is not NULL");
				categoryId = product.getCategoryId();
				criteria = session.createCriteria(CategoryMaster.class)
						.add(Restrictions.eq("categoryId", categoryId));
			} else {
				log.info("ENTER - Method getCategoryNamesForms - try block - Else block - categoryId is NULL");
				criteria = session.createCriteria(CategoryMaster.class);
			}
			
			categoryList = criteria.list();
			session.getTransaction().commit();
			
			if(!categoryList.isEmpty()){
				log.info("ENTER - Method getCategoryNamesForms - try block - If block - categoryList is not EMPTY");
				for (CategoryMaster master : categoryList) {
					
					categoryId = master.getCategoryId();
					productName = master.getCategoryName();
					
					categoryMap.put(categoryId, productName);
				}
			}
			log.info("ENTER - Method getCategoryNamesForms - try block - Fetched Data Successfully");
		} catch(HibernateException e){
			log.error("EXCEPTION Hibernate - Method getCategoryNamesForms", e);
			session.getTransaction().rollback();
		}
		log.info("EXIT - Method getCategoryNamesForms");
		return categoryMap;
	}

	@Override
	public List<ProductMaster> getSearchResult(String searchValue) {
		// TODO Auto-generated method stub
		log.info("ENTER - Method getSearchResult");
		List<ProductMaster> searchResult = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		try {
			log.info("ENTER - Method getSearchResult - try block");
			session.getTransaction().begin();
			searchResult = session.createCriteria(ProductMaster.class)
					           .add(Restrictions.or(
					        		   Restrictions.like("manufacturer", searchValue+"%")
					        		  ).add(Restrictions.or(Restrictions.like("productName", searchValue+"%")))).list();
					 
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("EXCEPTION Hibernate - Method getCategoryNamesForms", e);
			session.getTransaction().rollback();
		}
		log.info("EXIT - Method getSearchResult");
		return searchResult;
	}
}