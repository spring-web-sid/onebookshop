package com.onebookshop.service;
 
import com.onebookshop.dto.BookData;
import com.onebookshop.model.BookModel;
import com.onebookshop.model.CategoryModel;

import java.util.List;

public interface BookService {
List<BookData> getBooksForCategory(CategoryModel category);
int saveBook(BookModel book);
List<BookData> allBooks();
String getCategoryNameForBook(int bookid);
BookData getBookDetails(int bookid);
List<BookData> getBooksForUser(String userId);

List<BookData> searchByCategory(String categoryName);

BookModel getBookById(String bookId);
}
