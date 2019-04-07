package com.onebookshop.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onebookshop.dto.CategoryData;
import com.onebookshop.model.CategoryModel;

@Component
public class CategoryConverter implements Converter<CategoryModel, CategoryData>{

@Autowired
private BookConverter bookConverter;

public CategoryData convert(CategoryModel source) {
	CategoryData target = new CategoryData();
	target.setCategoryName(source.getCategoryName());
	target.setBooks(bookConverter.convertAll(source.getBooks()));
	return target;
}

public List<CategoryData> convertAll(List<CategoryModel> sources){
	List<CategoryData> targetList = new ArrayList<>();
	for(CategoryModel source : sources) {
		CategoryData target = new CategoryData();
		target.setCategoryName(source.getCategoryName());
		target.setBooks(bookConverter.convertAll(source.getBooks()));
		targetList.add(target);
	}
	return targetList;
}
}
