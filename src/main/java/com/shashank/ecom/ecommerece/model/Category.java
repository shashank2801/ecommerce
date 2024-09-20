package com.shashank.ecom.ecommerece.model;

public class Category {
	private Integer categoryId;
	private String categoryDescription;
	
	public Category(Integer categoryId, String categoryDescription) {
		this.categoryId = categoryId;
		this.categoryDescription = categoryDescription;
	}
	
	public Category() {
		
	}

	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryDescription=" + categoryDescription + "]";
	}
	
	
}
