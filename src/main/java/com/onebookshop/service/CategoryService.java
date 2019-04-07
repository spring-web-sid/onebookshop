package com.onebookshop.service;

import java.util.List;

import com.onebookshop.dto.CategoryData;
import com.onebookshop.model.CategoryModel;

public interface CategoryService {
List<CategoryData> getAllCategories();
String rootCategory(String category);
}
