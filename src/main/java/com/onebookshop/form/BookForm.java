package com.onebookshop.form;

import com.onebookshop.validation.NumberOnly;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookForm {
	
	@NotNull @NotBlank
	private String name;

	@NotNull @NotBlank
	private String author;

	@NotNull @NotBlank
	private String description;

	
	private String image;

	@NotNull @NotBlank
	@NumberOnly
	private String basePrice;
	
	@NumberOnly
	private String tax;
	
	@NumberOnly
	private String discount;
	
	@NumberOnly
	private String specialDiscount;

	private String rootCategory;

	private String subCategory;

	private String subSubcategory;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	//price settings
	
	public String getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getSpecialDiscount() {
		return specialDiscount;
	}

	public void setSpecialDiscount(String specialDiscount) {
		this.specialDiscount = specialDiscount;
	}

	public String getRootCategory() {
		return rootCategory;
	}

	public void setRootCategory(String rootCategory) {
		this.rootCategory = rootCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getSubSubcategory() {
		return subSubcategory;
	}

	public void setSubSubcategory(String subSubcategory) {
		this.subSubcategory = subSubcategory;
	}
}
