package com.onebookshop.service.impl;

import com.onebookshop.dao.CartDao;
import com.onebookshop.model.*;
import com.onebookshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;
    @Override
    public void updateOrCreateCart(CartModel modifiedCart) {
        modifiedCart.setCartTotal(calculate(modifiedCart));
        cartDao.updateOrCreateCart(modifiedCart);
    }

    @Override
    public CartModel loadCart(String userId) {
        return cartDao.loadCart(userId);
    }

    @Override
    public CartModel createAnonymousCart() {
        CartModel cart = new CartModel();
        cart.setCartId("anonymous");
        return cart;
    }

    @Override
    public CartEntryModel createEntry(BookModel book, Integer quantity) {
        CartEntryModel cartEntryModel = new CartEntryModel();
        cartEntryModel.setEntryName("entry_" + book.getBookid());
        cartEntryModel.setQuantity(quantity);
        PriceModel price = book.getPrice();
        cartEntryModel.setPrice(((price.getBasePrice() + (price.getBasePrice()*price.getTax()/100)) - (price.getDiscount() + price.getSpecialDiscount()) * quantity));
        return cartEntryModel;
    }

    @Override
    public Double calculate(CartModel cart) {
        Double total = 0.0d;
        for(CartEntryModel cartEntry : cart.getEntries()){
            total += cartEntry.getPrice();
        }
        return total;
    }
}
