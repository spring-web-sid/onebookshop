package com.onebookshop.service.impl;

import com.onebookshop.converter.BookConverter;
import com.onebookshop.dao.BookDao;
import com.onebookshop.dto.BookData;
import com.onebookshop.model.BookModel;
import com.onebookshop.model.CategoryModel;
import com.onebookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookConverter bookConterver;
	
	@Override
	public List<BookData> getBooksForCategory(CategoryModel category) {
		return bookConterver.convertAll(bookDao.getBooksForCategory(category));
	}

	@Override
	public int saveBook(BookModel book) {
		return bookDao.saveBook(book);
	}

	@Override
	public List<BookData> allBooks() {		
		return bookConterver.convertAll(bookDao.allBooks());
	}

	@Override
	public String getCategoryNameForBook(int bookid) {
		return bookDao.getCategoryNameForBook(bookid);
	}

	@Override
	public BookData getBookDetails(int bookid) {
		BookModel book = bookDao.getBookDetails(bookid);
		return bookConterver.convert(book);
	}

	@Override
	public List<BookData> getBooksForUser(String userId) {
		return bookConterver.convertAll(bookDao.getBooksForUser(userId));
	}

	@Override
	public List<BookData> searchByCategory(String categoryName) {
		List<BookModel> bookList = bookDao.searchBookByCategory(categoryName);
		return bookConterver.convertAll(bookList);
	}

	@Override
	public BookModel getBookById(String bookId) {
		return bookDao.getBookById(bookId);
	}

}
