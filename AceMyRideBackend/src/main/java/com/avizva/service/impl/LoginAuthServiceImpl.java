package com.avizva.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.UserDao;
import com.avizva.model.User;
import com.avizva.service.LoginAuthService;

@Service
public class LoginAuthServiceImpl implements LoginAuthService{
	
	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private UserDao userDao;
	
	public User authenticate(String email,String password)
	{
		LOGGER.info("Authenticating user with email:" + email);
		User user=userDao.view(email);
		
		if(user==null)
			return null;
		
		if(!(user.getPassword()).equals(password))
		{
			return null;
		}
		
		if(user.isEnabled()==false){
			userDao.reactivate(user.getId());
		}
		
		return user;
			
	}
	
	

}
