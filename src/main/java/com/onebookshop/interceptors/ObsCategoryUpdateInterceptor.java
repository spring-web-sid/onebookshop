package com.onebookshop.interceptors;

import com.onebookshop.util.CategoryCategoryMapper;
import com.onebookshop.util.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ObsCategoryUpdateInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CategoryCategoryMapper categoryMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //HttpSession session = request.getSession(true);
        if (PropertiesConfig.getPropertyValue("category.update.required").equals("true")) {
            categoryMapper.map();
        }
        return true;
    }
}
