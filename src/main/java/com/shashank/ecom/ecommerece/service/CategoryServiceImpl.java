package com.shashank.ecom.ecommerece.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.shashank.ecom.ecommerece.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{

	private List<Category> categories = new ArrayList<Category>();
	
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public String add(Category category) {
		// TODO Auto-generated method stub
		categories.add(category);
		return "Added Successfully";
	}

	@Override
	public String updateCategory(Integer id, Category category) {
		// TODO Auto-generated method stub
		Category cat = categories.stream()
				.filter(p -> p.getCategoryId().equals(id))
				.findFirst()
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found!"));
		cat.setCategoryDescription(category.getCategoryDescription());
		return "Updated Successfully";
	}

	@Override
	public String deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		Category cat = categories.stream()
				.filter(p -> p.getCategoryId().equals(id))
				.findFirst()
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found!"));
		categories.remove(cat);
		return "Removed Successfully";
	}

}
