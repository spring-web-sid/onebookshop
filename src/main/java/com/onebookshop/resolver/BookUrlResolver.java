package com.onebookshop.resolver;

import com.onebookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookUrlResolver {
    @Autowired
    private CategoryUrlResolver categoryUrlResolver;
    @Autowired
    private BookService bookService;

    public String resolve(int bookId) {
        return categoryUrlResolver.resolve(bookService.getCategoryNameForBook(bookId)) + "/" + bookId;
    }
}
