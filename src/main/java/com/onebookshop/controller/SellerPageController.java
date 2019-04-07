package com.onebookshop.controller;

import com.onebookshop.dto.BookData;
import com.onebookshop.form.BookForm;
import com.onebookshop.model.BookModel;
import com.onebookshop.model.CategoryModel;
import com.onebookshop.model.PriceModel;
import com.onebookshop.service.BookService;
import com.onebookshop.service.UserService;
import com.onebookshop.util.PropertiesConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
// @RequestMapping("/books")
public class SellerPageController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @ModelAttribute("rootCategoryList")
    public List subCategoryMap() {
        List catList = new LinkedList();
        catList.addAll(Arrays.asList(PropertiesConfig.getPropertyValue("root.category").split(", ")));
        return catList;
    }

/*    @RequestMapping(value = "/seller/book/save", method = RequestMethod.POST)
    public String saveBook(@RequestBody BookModel book) {
        bookService.saveBook(book);
        return "success";
    }*/

    @RequestMapping(value = "/seller/{userid}")
    public String getSellerBookPage(@PathVariable("userid") String userId, Model model){
        model.addAttribute("bookList", bookService.getBooksForUser(userId));
        return "seller/sellerBookListingPage";
    }

    @RequestMapping(value = "/seller/book/upload", method = RequestMethod.GET)
    public String upload(Model model) {
        model.addAttribute("bookForm", new BookForm());
        return "seller/uploadBookPage";
    }

    @RequestMapping(value = "/seller/book/upload", method = RequestMethod.POST)
    public String doUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file, @Valid @ModelAttribute("bookForm") BookForm bookForm, BindingResult bindingResult, Model model) {
        if(file.isEmpty()){
            ObjectError error = new ObjectError("","");
            bindingResult.addError(error);
            model.asMap().put("fileUploadErr", "No image is selected");
        }

        if (bindingResult.hasErrors() || file.isEmpty()) {
            return "seller/uploadBookPage";
        }
        PriceModel price = new PriceModel();
        CategoryModel category = new CategoryModel();
        BookModel book = new BookModel();

        price.setBasePrice(Double.parseDouble(bookForm.getBasePrice()));
        price.setTax(StringUtils.isNotBlank(bookForm.getTax()) ? Double.parseDouble(bookForm.getTax()) : 0.00d);
        price.setDiscount(StringUtils.isNotBlank(bookForm.getDiscount()) ? Double.parseDouble(bookForm.getDiscount()) : 0.00d);
        price.setSpecialDiscount(StringUtils.isNotBlank(bookForm.getSpecialDiscount()) ? Double.parseDouble(bookForm.getSpecialDiscount()) : 0.00d);

        category.setCategoryName(StringUtils.isNotEmpty(bookForm.getSubSubcategory()) ? bookForm.getSubSubcategory() : bookForm.getRootCategory());

        book.setCategory(category);
        book.setPrice(price);

        book.setName(bookForm.getName());
        book.setAuthor(bookForm.getAuthor());
        book.setDescription(bookForm.getDescription());
        book.setImage(uploadImage(file, request));

        book.setUser(userService.getCurrentUser());

        int bookid = bookService.saveBook(book);

        model.addAttribute("bookNumber", bookid);

        return "registrationConfirmation";
    }

    @RequestMapping(value = "/seller/c/{book}", method = RequestMethod.GET)
    public String bookDetails(@PathVariable("book") String bookUrl, Model model) {
        String[] arrBook = bookUrl.split("/");
        String bookid = arrBook[arrBook.length - 1];
        BookData data = bookService.getBookDetails(Integer.parseInt(bookid));
        model.addAttribute("bookData", data);
        return "bookDetailsPage";
    }

    private String uploadImage(MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String rootPath = PropertiesConfig.getPropertyValue("image.upload.dir"); //System.getProperty("catalina.home");
                File dir = new File(rootPath);
                if (!dir.exists())
                    dir.mkdirs();

                String fileName = String.valueOf(new Date().getTime()) + ".jpg";
                File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);

                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(serverFile));
                out.write(bytes);
                out.flush();
                out.close();
                return fileName;
            } catch (Exception e) {
                System.out.println("Put logger here...");
            }
        }
        return null;
    }


    @RequestMapping(value = "/seller/getSubCategory", method = RequestMethod.POST)
    public @ResponseBody
    String getSubCategory(@RequestParam("category") String category) {
        return getString(category);
    }

    @RequestMapping(value = "/seller/getSubSubCategory", method = RequestMethod.POST)
    public @ResponseBody
    String getSubSubCategory(@RequestParam("category") String category) {
        return getString(category);
    }

    private String getString(String category) {
        String configValue = PropertiesConfig.getPropertyValue("subcategory." + category);
        String returnString = "";
        if (!configValue.equals("")) {
            String[] arrSubCats = configValue.split(", ");
            for (int i = 0; i < arrSubCats.length; i++) {
                if (i != arrSubCats.length - 1)
                    returnString += arrSubCats[i].trim() + "|";
                else
                    returnString += arrSubCats[i].trim();
            }
        }
        return returnString;
    }
}
