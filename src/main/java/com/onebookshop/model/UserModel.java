package com.onebookshop.model;

import com.onebookshop.model.generators.UserIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -8326618951827326082L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @GenericGenerator(name = "user_seq", strategy = "com.onebookshop.model.generators.UserIdGenerator", parameters = {
            @Parameter(name = UserIdGenerator.INCREMENT_PARAM, value = "50"),
            @Parameter(name = UserIdGenerator.VALUE_PREFIX_PARAMETER, value = "USR"),
            @Parameter(name = UserIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")

    })
    @Column(name = "userid", updatable = false, nullable = false)
    private String userId;
    @Column(name = "username")
    private String name;
    @Column(nullable = false, length = 60)
    private String password;
    private boolean enabled;

    @Column(name = "email")
    private String mailId;
    @Column(name = "phone")
    private long phoneNo;

    private String address1;
    private String address2;

    @OneToMany(mappedBy = "user")
    private List<BookModel> books = new ArrayList<>();

    @Transient
    private RoleModel role;

    @OneToOne
    private CartModel cart;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }

    public CartModel getCart() {
        return cart;
    }

    public void setCart(CartModel cart) {
        this.cart = cart;
    }
}
