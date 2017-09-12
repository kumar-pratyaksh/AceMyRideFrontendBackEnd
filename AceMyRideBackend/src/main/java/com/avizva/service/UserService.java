package com.avizva.service;

import com.avizva.model.User;

public interface UserService {

	public User saveUser(User user);

	public User updateUser(User user);

	public boolean deleteUser(int id);

	public User getUser(int id);

	public User getUser(String email);

}
