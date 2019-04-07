package com.onebookshop.resolver;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class BookImageUrlResolver {

    private static final String defaultDirLoc = "images";

    public String resolve(String imgName){
        return defaultDirLoc + File.separator + imgName;
    }
}
