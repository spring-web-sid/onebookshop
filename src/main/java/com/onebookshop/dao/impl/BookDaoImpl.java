package com.onebookshop.dao.impl;

import com.onebookshop.dao.BookDao;
import com.onebookshop.model.BookModel;
import com.onebookshop.model.CategoryModel;
import com.onebookshop.util.SessionUtil;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	public static final String all_book_query = "select * from book_table";
	private static final String LIKE_OPERAND = "_%";

	@Autowired
	private SessionUtil session;


	@Override
	public List<BookModel> getBooksForCategory(CategoryModel category) {
		@SuppressWarnings("unchecked")
		List<BookModel> books = session.getSession().createCriteria(BookModel.class).add(Restrictions.eq("categoryName", category.getCategoryName())).list();
		return books;
	}

	@Override
	public int saveBook(BookModel book) {
		return (int)session.getSession().save(book);
	}

	@Override
	public List<BookModel> allBooks() {
		SQLQuery query = session.getSession().createSQLQuery(all_book_query);
		List<BookModel> books = (List<BookModel>)query.addEntity(BookModel.class).list();
		return books;
	}

	@Override
	public String getCategoryNameForBook(int bookid) {
		SQLQuery query = session.getSession().createSQLQuery("select CATEGORY_CATEGORYNAME from book_table where BOOKID =?");
		return (String)query.setInteger(0, bookid).uniqueResult();
	}

	@Override
	public BookModel getBookDetails(int bookid) {
		return (BookModel) session.getSession().get(BookModel.class, bookid);
	}

	@Override
	public List<BookModel> getBooksForUser(String userId) {
		final SQLQuery query = session.getSession().createSQLQuery("select * from book_table where user_userid=?");
		return query.addEntity(BookModel.class).setString(0, userId).list();
	}

	@Override
	public List<BookModel> searchBookByCategory(String categoryName) {
		List<BookModel> bookList = new ArrayList<>();
		final SQLQuery query = session.getSession().createSQLQuery("select categoryname from category_table where categoryName like :c");
		List<CategoryModel> catList = query.addEntity(CategoryModel.class).setString("c", categoryName + LIKE_OPERAND).list();
		catList.forEach(category -> bookList.addAll(category.getBooks()));
		System.out.println(bookList);
		return bookList;
	}

	@Override
	public BookModel getBookById(String bookId) {
		return (BookModel)session.getSession().get(BookModel.class, Integer.parseInt(bookId));
	}
}
