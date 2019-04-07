package com.onebookshop.service.impl;

import java.util.List;

import com.onebookshop.dao.CategoryDao;
import com.onebookshop.dto.CategoryData;
import com.onebookshop.model.CategoryModel;
import com.onebookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<CategoryData> getAllCategories() {
		return null;
	}
	@Override
	public String rootCategory(String category) {
		return categoryDao.rootCategory(category);
	}


}
