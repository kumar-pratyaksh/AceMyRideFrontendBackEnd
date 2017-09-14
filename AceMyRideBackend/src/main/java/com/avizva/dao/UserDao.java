package com.avizva.dao;

import java.util.List;

import com.avizva.model.User;

public interface UserDao {

	public User save(User user);

	public User delete(int id);

	public User update(User user);

	public User view(int id);

	public User view(String email);

	public List<User> viewAll();
	
	public User deactivate(int id);
	
	public User reactivate(int id);

}
