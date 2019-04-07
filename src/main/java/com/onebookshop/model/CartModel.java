package com.onebookshop.model;

import com.onebookshop.model.generators.UserIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="cart_table")
public class CartModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
    @GenericGenerator(name = "cart_seq", strategy = "com.onebookshop.model.generators.CartIdGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = UserIdGenerator.INCREMENT_PARAM, value = "50"),
            @org.hibernate.annotations.Parameter(name = UserIdGenerator.VALUE_PREFIX_PARAMETER, value = "CART"),
            @org.hibernate.annotations.Parameter(name = UserIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")})
    private String cartId;

    @OneToOne
    private UserModel user;

    @OneToMany(mappedBy = "cart")
    private List<CartEntryModel> entries = new ArrayList<>();

    private Double cartTotal;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<CartEntryModel> getEntries() {
        return entries;
    }

    public void setEntries(List<CartEntryModel> entries) {
        this.entries = entries;
    }

    public Double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(Double cartTotal) {
        this.cartTotal = cartTotal;
    }
}
