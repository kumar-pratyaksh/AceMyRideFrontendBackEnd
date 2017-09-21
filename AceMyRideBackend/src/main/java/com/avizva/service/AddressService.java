package com.avizva.service;

import java.util.List;

import com.avizva.model.Address;

public interface AddressService {

	public Address saveAddress(Address address);

	public Address updateAddress(Address address);

	public Address deactivateAddress(Address address);

	public Address getAddressById(int id);

	public List<Address> getActiveAddresssByUserId(int userId);

}
