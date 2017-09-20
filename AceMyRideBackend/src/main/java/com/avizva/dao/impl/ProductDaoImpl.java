package com.avizva.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.dao.ProductDao;
import com.avizva.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Product save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		try {
			product.setEnabled(true);
			session.save(product);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public Product delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Product product = session.get(Product.class, id);
			if(product!=null){
				product.setEnabled(false);
			}
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Transactional
	public Product update(Product product) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(product);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Transactional
	public Product view(String productId) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createCriteria(Product.class).add(Restrictions.eq("productId", productId)).list();
		if (products.isEmpty())
			return null;
		return products.get(0);
		
	}
	
	@Transactional
	public List<Product> viewAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Product.class).list();
	}

	@Transactional
	public Product view(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Transactional
	public List<Product> getCategorizedProduct(String categoryName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product where belongsToCategoryName=:belongsToCategoryName");
		query.setParameter("belongsToCategoryName", categoryName);
		List<Product> list = query.list();
		return list;
	}
}
