package com.onebookshop.controller;

import com.onebookshop.dto.BookData;
import com.onebookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guest/**")
public class GuestPageController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/book/all")
    public String getBooks(Model model) {
        List<BookData> bookList = bookService.allBooks();
        model.addAttribute("bookList", bookList);
        return "user/userBookListingPage";
    }

    @RequestMapping("/category/{categoryName}")
    public String getBookByCategory(@PathVariable("categoryName") String categoryName, Model model){
        model.addAttribute("bookList", bookService.searchByCategory(categoryName));
        return "user/userBookListingPage";
    }

    @RequestMapping("/book/{category}/{subCategory}/{subSubCategory}/{bookId}")
    public String getBookDetails(@PathVariable("category") String category,@PathVariable("subCategory") String subCategory,@PathVariable("subSubCategory") String subSubCategory,@PathVariable("bookId") Integer bookId, Model model){
        model.addAttribute("bookData", bookService.getBookDetails(bookId));
        return "user/userBookDetailsPage";
    }
}
