package com.avizva.dao;

import java.util.List;

import com.avizva.model.User;

/**
 * 
 * Dao for User model
 * 
 * @author Pratyaksh Kumar
 * @author Raju Tikadar
 * @author Prateek
 *
 */
public interface UserDao {

	/**
	 * Persists the given user object in database
	 * 
	 * @param user
	 *            The user to be persisted
	 * @return User the saved user object
	 */
	public User save(User user);

	/**
	 * Deletes the user from the database
	 * 
	 * @param id
	 *            The id of the user
	 * @return User the deleted user object
	 */
	public User delete(int id);

	/**
	 * Updates the given user object in database
	 * 
	 * @param user
	 *            The user to be updated
	 * @return User the updated user object
	 */
	public User update(User user);

	/**
	 * Gets the user object with the given id
	 * 
	 * @param id
	 * @return User the user object
	 */
	public User view(int id);

	/**
	 * Gets the user object with the given email
	 * 
	 * @param email
	 *            the given email of the user
	 * @return User the user object
	 */
	public User view(String email);

	/**
	 * Gets all the user objects in the database
	 * 
	 * @return List<User> the list of all the users
	 */
	public List<User> viewAll();
	
	/**
	 * Deactivates the user with the given id
	 * 
	 * @param id
	 *            the given id of the user
	 * @return User the deactivated user object
	 */
	public User deactivate(int id);
	
	/**
	 * Reactivates the user with the given id
	 * 
	 * @param id
	 *            the given id of the user
	 * @return User the reactivated user object
	 */
	public User reactivate(int id);

	public User userWithAddresses(User user);

}
