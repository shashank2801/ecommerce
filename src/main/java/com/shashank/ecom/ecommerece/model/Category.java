package com.shashank.ecom.ecommerece.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long categoryId;
	
	@NotBlank
	@Size(min=5,message = "Category name must be atleast 5 characters.")
	private String categoryDescription;
	
//	public Category(Integer categoryId, String categoryDescription) {
//		this.categoryId = categoryId;
//		this.categoryDescription = categoryDescription;
//	}
//	
	public Category(String des) {
		this.categoryDescription = des;
	}
//
//	public Integer getCategoryId() {
//		return categoryId;
//	}
//	public void setCategoryId(Integer categoryId) {
//		this.categoryId = categoryId;
//	}
//	public String getCategoryDescription() {
//		return categoryDescription;
//	}
//	public void setCategoryDescription(String categoryDescription) {
//		this.categoryDescription = categoryDescription;
//	}
//
//	@Override
//	public String toString() {
//		return "Category [categoryId=" + categoryId + ", categoryDescription=" + categoryDescription + "]";
//	}
	
	
}
