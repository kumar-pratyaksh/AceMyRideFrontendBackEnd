package com.avizva.service.impl;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.UserDao;
import com.avizva.model.User;
import com.avizva.service.LoginAuthService;





@Service
public class LoginAuthServiceImpl implements LoginAuthService{
	
	@Autowired
	private UserDao userDao;
	
	public User authenticate(String email,String password)
	{
		User user=userDao.view(email);
		userDao.reactivate(user.getId());
		return user;
			
	}

}
