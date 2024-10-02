package com.shashank.ecom.ecommerece.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shashank.ecom.ecommerece.model.Category;
import com.shashank.ecom.ecommerece.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/public/category/list")
	public List<Category> getAll(){
		return categoryService.findAll();
	}
	
	@PostMapping("/admin/category/list")
	public String addCategory(@Valid @RequestBody Category category) {
		return categoryService.add(category);
	}
	
	@PutMapping("/admin/category/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category category) {
		try {
			Category status = categoryService.updateCategory(id,category);
			if(status != null)
				return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
			else
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found!");
		}
		catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getReason(),e.getStatusCode());
		}
	}
	
	@DeleteMapping("/admin/category/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id){
		try {
			String status = categoryService.deleteCategory(id);
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getReason(),e.getStatusCode());
		}
	}
}
