package com.shashank.ecom.ecommerece.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.shashank.ecom.ecommerece.exceptions.ResourceNotFoundException;
import com.shashank.ecom.ecommerece.model.Category;
import com.shashank.ecom.ecommerece.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

//	private List<Category> categories = new ArrayList<Category>();
	
	@Autowired
	private CategoryRepository cRepository;
	
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cRepository.findAll();
	}

	@Override
	public String add(Category category) {
		// TODO Auto-generated method stub
		cRepository.save(category);
		return "Added Successfully";
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		// TODO Auto-generated method stub
		List<Category> categories = cRepository.findAll();
		Optional<Category> optionalCategory = categories.stream()
				.filter(p -> p.getCategoryId().equals(id))
				.findFirst();
		if(optionalCategory.isPresent()) {
			Category existingCategory = optionalCategory.get();
			existingCategory.setCategoryDescription(category.getCategoryDescription());
			Category savedCategory = cRepository.save(existingCategory);
			return savedCategory;
		}
		else {
			throw new ResourceNotFoundException("Category","Category Id",id);
		}
	}

	@Override
	public String deleteCategory(Long id) {
		// TODO Auto-generated method stub
		List<Category> categories = cRepository.findAll();
		Category optionalCategory = categories.stream()
				.filter(p -> p.getCategoryId().equals(id))
				.findFirst()
				.orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",id));
			
		cRepository.delete(optionalCategory);
			return "Removed Successfully";
	}


}
