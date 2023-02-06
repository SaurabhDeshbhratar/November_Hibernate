package com.jbk.hibernate.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jbk.hibernate.config.HibernateConfig;
import com.jbk.hibernate.entity.Product;

public class ProductDao {

	private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public boolean saveProduct(Product product) {
		Session session = sessionFactory.openSession();
		boolean isAdded = false;
		try {
			Product dbProduct = getProductById(product.getProductId());

			if (dbProduct == null) {
				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isAdded;
	}

	public Product getProductById(long productId) {
		Session session = sessionFactory.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return product;

	}

	public boolean deleteProductById(long productId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		try {
			Product dbProduct = getProductById(productId);
			if (dbProduct != null) {
				session.delete(dbProduct);
				transaction.commit();
				isDeleted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return isDeleted;
	}

	public boolean updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {
			Product dbProduct = getProductById(product.getProductId());
			if (dbProduct != null) {
				session.update(product);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isUpdated;
	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);

//		    Criteria
//			criteria.addOrder(Order.asc("productName"));
//			criteria.addOrder(Order.desc("productName"));
//			criteria.setFirstResult(1);// pagination
//			criteria.setMaxResults(3);

//		    Restrictions	
//			criteria.add(Restrictions.gt("productPrice", 150d));
//			criteria.add(Restrictions.ge("productPrice", 150.00));
//			criteria.add(Restrictions.le("productPrice", 150d));
//			criteria.add(Restrictions.ne("productId", 103l));
//			criteria.add(Restrictions.eq("productName", "tie"));
//			criteria.add(Restrictions.like("productName","ba%" ));
//			criteria.add(Restrictions.in("productName", "tie"));
//			criteria.add(Restrictions.between("productId", 102l, 104l));
//			criteria.add(Restrictions.isNull("productName"));
//			criteria.add(Restrictions.isNotNull("productName"));
			criteria.add(Restrictions.or(Restrictions.gt("productPrice", 150d),Restrictions.eq("productName", "tie")));
			
			
//			Map map = new HashMap();  
//			map.put("productName", "tie");  
//			map.put("productId", 105l); 
//			criteria.add(Restrictions.allEq(map));
			
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> getAllProducts(String exp) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", "%" + exp + "%"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
