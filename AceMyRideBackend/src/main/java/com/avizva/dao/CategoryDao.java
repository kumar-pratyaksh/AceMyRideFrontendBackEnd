package com.avizva.dao;

import java.util.List;

import com.avizva.model.Category;

public interface CategoryDao {
	
	public Category save(Category category);

	public Category delete(int id);

	public Category update(Category category);

	public Category view(int id);
	
	public Category view(String categoryId);

	public List<Category> viewAll();

}
