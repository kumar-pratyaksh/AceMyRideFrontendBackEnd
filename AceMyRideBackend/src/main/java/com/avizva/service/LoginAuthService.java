package com.avizva.service;

import com.avizva.model.User;

/**
 * Service for authenticating user login
 * 
 * @author Prateek
 *
 */
public interface LoginAuthService {
	
	/**
	 * Method to authenticate the user
	 * 
	 * @param email
	 *            Email address of the user
	 * @param password
	 *            Password of the user
	 * @return User user object of the authenticated user
	 */
	public User authenticate(String email,String password);

}
