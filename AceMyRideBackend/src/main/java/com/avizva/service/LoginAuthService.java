package com.avizva.service;

import com.avizva.model.User;

public interface LoginAuthService {
	
	public User authenticate(String email,String password);

}
