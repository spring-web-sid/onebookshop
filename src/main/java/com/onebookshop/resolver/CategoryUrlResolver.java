package com.onebookshop.resolver;

public class CategoryUrlResolver {

    private static final String urlSlash = "/";
    public String resolve(String category){
        return category.replace(".", "/");
    }
}
