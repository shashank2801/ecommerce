package com.shashank.ecom.ecommerece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shashank.ecom.ecommerece.model.Category;
import com.shashank.ecom.ecommerece.service.CategoryService;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner{
	
	@Autowired
	private CategoryService categoryService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		categoryService.add(new Category("Default category"));
	}

}
