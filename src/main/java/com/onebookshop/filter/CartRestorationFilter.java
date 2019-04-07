package com.onebookshop.filter;

import com.onebookshop.service.CartService;
import com.onebookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartRestorationFilter extends OncePerRequestFilter {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;
    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession();
        restore(request, session);
        filterChain.doFilter(request, response);
    }

    private void restore(HttpServletRequest request, HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(null != auth){
            if (userService.isCurrentUserAnonymous() && null == session.getAttribute("cart")) {
                session.setAttribute("cart", cartService.createAnonymousCart());
            } else if(null != session.getAttribute("cart") && !userService.isCurrentUserAnonymous() && null == session.getAttribute("loggedInUser")) {
                session.setAttribute("cart", cartService.loadCart(auth.getName()));
            }
        }
    }
}
