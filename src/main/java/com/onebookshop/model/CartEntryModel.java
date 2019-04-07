package com.onebookshop.model;

import javax.persistence.*;

@Entity
@Table(name="cartEntry_table")
public class CartEntryModel {
    @Id
    private String entryName;

    private Integer quantity;

    @OneToOne
    private BookModel book;

    @ManyToOne
    private CartModel cart;

    private Double price;

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }

    public CartModel getCart() {
        return cart;
    }

    public void setCart(CartModel cart) {
        this.cart = cart;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
