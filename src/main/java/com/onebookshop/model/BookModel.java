package com.onebookshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_table")
public class BookModel implements Serializable{

private static final long serialVersionUID = -9005322343609184204L;

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int bookid;

private String name;

private String author;

private String description;

@Embedded
private PriceModel price;

private String image;

@ManyToOne
private UserModel user;

@ManyToOne
private CategoryModel category;

public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

public PriceModel getPrice() {
	return price;
}
public void setPrice(PriceModel price) {
	this.price = price;
}
public UserModel getUser() {
	return user;
}
public void setUser(UserModel user) {
	this.user = user;
}

public CategoryModel getCategory() {
		return category;
	}
public void setCategory(CategoryModel category) {
		this.category = category;
	}
}
