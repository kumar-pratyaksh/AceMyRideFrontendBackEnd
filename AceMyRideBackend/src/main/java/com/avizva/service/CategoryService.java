package com.avizva.service;

import java.util.List;

import com.avizva.model.Category;

public interface CategoryService {
	
	public Category saveCategory(Category category);

	public Category updateCategory(Category category);

	public boolean deleteCategory(int id);

	public Category getCategory(int id);

	public Category getCategory(String categoryId);	
	
	public List<Category> getAllCategories();


}
