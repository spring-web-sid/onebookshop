package com.onebookshop.dao;

import com.onebookshop.model.CartModel;

public interface CartDao {
    void updateOrCreateCart(CartModel modifiedCart);
    CartModel loadCart(String userId);
}
