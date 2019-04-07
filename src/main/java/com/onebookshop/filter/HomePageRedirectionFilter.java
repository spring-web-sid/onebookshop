package com.onebookshop.filter;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePageRedirectionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //boolean toRedirect = false;
        if (null == SecurityContextHolder.getContext().getAuthentication() && !notGuestRequest(req.getRequestURI())) {
            res.sendRedirect(req.getContextPath() + "/guest");
        }
        else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

    protected boolean notGuestRequest(String url){
        boolean flag = false;
        List<String> excludePattern = new ArrayList<>();
        excludePattern.add("images");
        excludePattern.add("resources");
        excludePattern.add("loginUser");
        excludePattern.add("loginSeller");
        excludePattern.add("register");

        for (String s : excludePattern) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}