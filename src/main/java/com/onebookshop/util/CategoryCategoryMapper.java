package com.onebookshop.util;

import com.onebookshop.model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Transactional
public class CategoryCategoryMapper {
    @Autowired
    private SessionUtil session;

    private static final String ROOT_CAT = "root.category";
    private static final String SUB_CAT = "subcategory.";
    private static final String DOT = ".";
    private static final String TRACK_UPDATE = "updatedAll";

    public void map() {
        CategoryModel updater = (CategoryModel) session.getSession().get(CategoryModel.class, TRACK_UPDATE);
        if(null == updater) {
            List<String> rootCatList = new LinkedList<>();
            for (String root : PropertiesConfig.getPropertyValue(ROOT_CAT).split(", ")) {
                rootCatList.add(root);
                CategoryModel rootCat = new CategoryModel();
                rootCat.setCategoryName(root);
                session.getSession().save(rootCat);
            }
            for (String root : rootCatList) {
                if ("" != PropertiesConfig.getPropertyValue(SUB_CAT + root)) {
                    for (String sub : PropertiesConfig.getPropertyValue(SUB_CAT + root).split(", ")) {
                        CategoryModel subCat = new CategoryModel();
                        String subCatName = root + DOT + sub;
                        subCat.setCategoryName(subCatName);
                        session.getSession().save(subCat);

                        if ("" != PropertiesConfig.getPropertyValue(SUB_CAT + root + DOT + sub)) {
                            for (String subSub : PropertiesConfig.getPropertyValue(SUB_CAT + root + DOT + sub).split(", ")) {
                                CategoryModel subSubCat = new CategoryModel();
                                String subSubCatName = root + DOT + sub + DOT + subSub;
                                subSubCat.setCategoryName(subSubCatName);
                                session.getSession().save(subSubCat);
                            }
                        }
                    }
                }
            }

            CategoryModel model = new CategoryModel();
            model.setCategoryName(TRACK_UPDATE);
            session.getSession().save(model);
        }
    }
}
