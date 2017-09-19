package com.avizva.dao;

import java.util.List;

import com.avizva.model.Product;

public interface ProductDao {

	public Product save(Product product);

	public Product delete(int id);

	public Product update(Product product);

	public Product view(int id);
	
	public Product view(String productId);

	public List<Product> viewAll();

	public List<Product> getCategorizedProduct(String categoryName);
}
