package com.onebookshop.dto;

import java.util.List;

public class CategoryData {
private String categoryName;
private List<BookData> books;

public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public List<BookData> getBooks() {
	return books;
}
public void setBooks(List<BookData> books) {
	this.books = books;
}

}
