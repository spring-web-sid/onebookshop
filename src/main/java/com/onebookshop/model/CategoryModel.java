package com.onebookshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category_table")
public class CategoryModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 950025492531984983L;
    @Id
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<BookModel> books = new ArrayList<>();

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }

}
