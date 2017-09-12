package com.avizva.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.dao.FeedbackDao;
import com.avizva.model.Feedback;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Feedback save(Feedback feedback) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(feedback);
			return feedback;
		} catch (Exception e) {
			e.printStackTrace();
			return feedback;
		}
	}

	@Transactional
	public List<Feedback> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Feedback").list();
	}

	@Transactional
	public List<Feedback> get(String userEmail) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Feedback.class).add(Restrictions.eq("email", userEmail)).list();
	}

}
