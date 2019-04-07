package com.onebookshop.controller;

import com.onebookshop.model.CartEntryModel;
import com.onebookshop.model.CartModel;
import com.onebookshop.service.BookService;
import com.onebookshop.service.CartService;
import com.onebookshop.service.UserService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AddToCartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;


@RequestMapping("/user/book/addToCart")
@ResponseBody
public String addToCart(HttpServletRequest request){

    try {
        HttpSession session = request.getSession(false);
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(request.getParameter("book"));

        CartEntryModel cartEntry = cartService.createEntry(bookService.getBookById((String) object.get("bookId")),
                Integer.parseInt((String) object.get("quantity")));


        CartModel cart = (CartModel) session.getAttribute("cart");
        List<CartEntryModel> entries = cart.getEntries();
        entries.add(cartEntry);
        cart.setEntries(entries);
        //cartService.updateOrCreateCart(cart);
        session.removeAttribute("cart");
        //CartModel savedCart = cartService.loadCart(userService.getCurrentUser().getUserId());
        session.setAttribute("cart", cart);
        Map map = new HashMap<>();
        map.put("status", "success");
        map.put("cartQuantity", cart.getEntries().size());
        JSONObject obj = new JSONObject(map);
        return obj.toJSONString();
    }
    catch (Exception e){
        System.out.println("Product was not added to cart" + e.getMessage());
        Map map = new HashMap<>();
        map.put("status", "success");
        JSONObject obj = new JSONObject(map);
        return obj.toJSONString();
    }
    }
}
