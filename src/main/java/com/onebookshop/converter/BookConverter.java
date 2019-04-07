package com.onebookshop.converter;

import com.onebookshop.dto.BookData;
import com.onebookshop.model.BookModel;
import com.onebookshop.resolver.BookImageUrlResolver;
import com.onebookshop.resolver.BookUrlResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookConverter implements Converter<BookModel, BookData>{

	@Autowired
	private BookImageUrlResolver bookImageUrlResolver;
	@Autowired
	private BookUrlResolver bookUrlResolver;

	@Override
	public BookData convert(BookModel source) {
		return fillTarget(source);
	}

	@Override
	public List<BookData> convertAll(List<BookModel> sources) {
		List<BookData> targetList = new ArrayList<>();
		for(BookModel source : sources) {
			targetList.add(fillTarget(source));
		}
		return targetList;
	}

	private BookData fillTarget(BookModel source) {
		BookData target = new BookData();
		target.setBookId(source.getBookid());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setImage(bookImageUrlResolver.resolve(source.getImage()));
		target.setBookUrl(bookUrlResolver.resolve(source.getBookid()));
		target.setAuthor(source.getAuthor());
		return target;
	}

}
