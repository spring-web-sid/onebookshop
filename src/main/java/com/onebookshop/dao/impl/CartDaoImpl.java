package com.onebookshop.dao.impl;

import com.onebookshop.dao.CartDao;
import com.onebookshop.model.CartModel;
import com.onebookshop.model.UserModel;
import com.onebookshop.util.SessionUtil;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {
    @Autowired
    private SessionUtil session;
    @Override
    public void updateOrCreateCart(CartModel modifiedCart) {
        session.getSession().saveOrUpdate("CartModel", modifiedCart);
    }

    @Override
    public CartModel loadCart(String userId) {
        UserModel user = (UserModel) session.getSession().get(UserModel.class, userId);
        List<CartModel> cartList = null != user ? session.getSession().createCriteria(CartModel.class).add(Restrictions.eq("user", user)).list() : new ArrayList<>();
        if (cartList.size() == 0) {
            CartModel cart = new CartModel();
            return cart;
        } else {
            return cartList.stream().findFirst().get();
        }
    }
}

