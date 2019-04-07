package com.onebookshop.service;

import com.onebookshop.model.BookModel;
import com.onebookshop.model.CartEntryModel;
import com.onebookshop.model.CartModel;

public interface CartService {
    void updateOrCreateCart(CartModel modifiedCart);
    CartModel loadCart(String userId);
    CartModel createAnonymousCart();
    CartEntryModel createEntry(BookModel book, Integer quantity);
    Double calculate(CartModel cart);
}
