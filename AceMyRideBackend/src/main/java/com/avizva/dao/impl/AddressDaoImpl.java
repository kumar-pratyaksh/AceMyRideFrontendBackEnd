package com.avizva.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.dao.AddressDao;
import com.avizva.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Address save(Address address) {
		Session session = sessionFactory.getCurrentSession();
		try {
			LOGGER.info("Saving user address" + address.getUserId());
			session.save(address);
			return address;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	@Transactional
	public Address update(Address address) {
		Session session = sessionFactory.getCurrentSession();
		try {
			LOGGER.info("Updating user address" + address.getId());
			session.update(address);
			return address;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	@Transactional
	public Address delete(Address address) {
		Session session = sessionFactory.getCurrentSession();
		try {
			LOGGER.info("Deactivating user address" + address.getId());
			address.setActive(false);
			session.update(address);
			return address;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	@Transactional
	public Address get(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Address.class, id);
	}

	@Override
	@Transactional
	public List<Address> getActiveAddressesByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Address where active=1 and userId=:userId");
		query.setParameter("userId", userId);
		return query.list();
	}

}
