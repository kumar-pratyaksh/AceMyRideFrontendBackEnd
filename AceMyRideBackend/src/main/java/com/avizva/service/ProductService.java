package com.avizva.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.avizva.model.Product;



public interface ProductService {

	public Product saveProduct(Product product,MultipartFile file);

	public Product updateProduct(Product product, MultipartFile file);

	public boolean deleteProduct(int id);

	public Product getProduct(int id);

	public Product getProduct(String productId);	
	
	public List<Product> getAllProducts();

	public List<Product> getProductUsingCategory(String categoryName);

}
