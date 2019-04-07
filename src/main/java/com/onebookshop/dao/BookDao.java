package com.onebookshop.dao;

import com.onebookshop.model.BookModel;
import com.onebookshop.model.CategoryModel;

import java.util.List;


public interface BookDao {
	List<BookModel> getBooksForCategory(CategoryModel category);
	int saveBook(BookModel book);
	List<BookModel> allBooks();
	String getCategoryNameForBook(int book);
	BookModel getBookDetails(int bookid);
    List<BookModel> getBooksForUser(String userId);

    List<BookModel> searchBookByCategory(String categoryName);

    BookModel getBookById(String bookId);
}
