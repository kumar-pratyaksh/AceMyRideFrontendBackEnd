package com.avizva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.UserDao;
import com.avizva.model.User;
import com.avizva.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User saveUser(User user) {
		User savedUser = userDao.save(user);
		return savedUser;
	}

	public User updateUser(User user) {
		User updatedUser = userDao.update(user);
		return updatedUser;
	}

	public boolean deleteUser(int id) {
		User deletedUser = userDao.delete(id);
		if (deletedUser == null)
			return false;
		return true;
	}

	public User getUser(int id) {
		return userDao.view(id);
	}

	public User getUser(String email) {
		return userDao.view(email);
	}

}
