package com.avizva.dao;

import java.util.List;

import com.avizva.model.Address;

/**
 * 
 * Dao for Address model
 * 
 * @author Pratyaksh Kumar
 *
 */
public interface AddressDao {

	/**
	 * Persists the given address object
	 * 
	 * @param address
	 *            address to be saved
	 * @return Address saved address object
	 */
	public Address save(Address address);


	public Address update(Address address);

	public Address delete(Address address);

	public Address get(int id);

	public List<Address> getActiveAddressesByUserId(int userId);

}
