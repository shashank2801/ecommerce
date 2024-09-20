package com.shashank.ecom.ecommerece.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shashank.ecom.ecommerece.model.Category;
import com.shashank.ecom.ecommerece.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/api/public/category/list")
	public List<Category> getAll(){
		return categoryService.findAll();
	}
	
	@PostMapping("/api/admin/category/list")
	public String addCategory(@RequestBody Category category) {
		return categoryService.add(category);
	}
	
	@PutMapping("/api/admin/category/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
		try {
			String status = categoryService.updateCategory(id,category);
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getReason(),e.getStatusCode());
		}
	}
	
	@DeleteMapping("/api/admin/category/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer id){
		try {
			String status = categoryService.deleteCategory(id);
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getReason(),e.getStatusCode());
		}
	}
}
