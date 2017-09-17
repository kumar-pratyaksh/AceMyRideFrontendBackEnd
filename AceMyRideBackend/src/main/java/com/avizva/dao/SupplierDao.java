package com.avizva.dao;

import java.util.List;

import com.avizva.model.Supplier;



public interface SupplierDao {

	public Supplier save(Supplier supplier);

	public Supplier delete(int id);

	public Supplier update(Supplier supplier);

	public Supplier view(int id);
	
	public Supplier view(String supplierId);

	public List<Supplier> viewAll();
}
