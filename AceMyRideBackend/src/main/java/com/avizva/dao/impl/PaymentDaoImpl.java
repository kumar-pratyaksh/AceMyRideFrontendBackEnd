package com.avizva.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.dao.PaymentDao;
import com.avizva.model.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Payment save(Payment payment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(payment);
		return payment;
	}

}
