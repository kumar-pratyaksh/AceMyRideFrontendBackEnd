package com.avizva.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.dao.UserDao;
import com.avizva.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public User save(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(user);
			return user;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	@Transactional
	public User delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			User user = session.get(User.class, id);
			if (user != null) {
				user.setEnabled(false);
			}
			return user;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Transactional
	public User update(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(user);
			return user;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Transactional
	public User view(int id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Transactional
	public List<User> viewAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(User.class).list();
	}

	@Transactional
	public User view(String email) {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createCriteria(User.class).add(Restrictions.eq("email", email)).list();
		if (users.isEmpty())
			return null;
		return users.get(0);
	}
	@Transactional
	public User deactivate(int id) {

		Session session = sessionFactory.getCurrentSession();
		try {
			User user = session.get(User.class, id);
			if (user != null) {
				user.setEnabled(false);
			}
			return user;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}

	@Transactional
	public User reactivate(int id) {

		Session session = sessionFactory.getCurrentSession();
		try {
			User user = session.get(User.class, id);
			if (user != null) {
				user.setEnabled(true);
			}
			return user;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}

	}


}
