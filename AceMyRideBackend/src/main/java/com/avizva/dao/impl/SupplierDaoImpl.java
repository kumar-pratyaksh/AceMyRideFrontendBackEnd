package com.avizva.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.dao.SupplierDao;
import com.avizva.model.Supplier;


@Repository
public class SupplierDaoImpl implements SupplierDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Supplier save(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(supplier);
			return supplier;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public Supplier delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Supplier supplier = session.get(Supplier.class, id);
			if(supplier!=null){
				supplier.setEnabled(false);
			}
			return supplier;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Transactional
	public Supplier update(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(supplier);
			return supplier;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Transactional
	public Supplier view(String supplierId) {
		Session session = sessionFactory.getCurrentSession();
		List<Supplier> suppliers = session.createCriteria(Supplier.class).add(Restrictions.eq("supplierId", supplierId)).list();
		if (suppliers.isEmpty())
			return null;
		return suppliers.get(0);
		
	}
	
	@Transactional
	public List<Supplier> viewAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Supplier.class).list();
	}

	@Transactional
	public Supplier view(int id) {
		return sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

}
