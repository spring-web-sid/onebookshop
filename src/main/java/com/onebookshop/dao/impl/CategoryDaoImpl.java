package com.onebookshop.dao.impl;

import com.onebookshop.converter.CategoryConverter;
import com.onebookshop.dao.CategoryDao;
import com.onebookshop.model.CategoryModel;
import com.onebookshop.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionUtil session;
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public void save(CategoryModel category) {
		session.getSession().save(category);
	}

	@Override
	public String rootCategory(String category) {
		return null;
	}
}
