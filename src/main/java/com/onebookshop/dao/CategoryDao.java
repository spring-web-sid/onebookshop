package com.onebookshop.dao;

import com.onebookshop.model.CategoryModel;

public interface CategoryDao {
	void save(CategoryModel category);
	String rootCategory(String category);
}
