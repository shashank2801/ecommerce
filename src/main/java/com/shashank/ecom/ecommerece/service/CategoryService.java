package com.shashank.ecom.ecommerece.service;

import java.util.List;

import com.shashank.ecom.ecommerece.model.Category;

public interface CategoryService {
	public List<Category> findAll();
	
	public String add(Category category);
	
	public Category updateCategory(Long id, Category category);
	
	public String deleteCategory(Long id);
}
