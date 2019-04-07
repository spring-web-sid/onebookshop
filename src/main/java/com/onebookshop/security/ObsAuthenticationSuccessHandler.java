package com.onebookshop.security;

import com.onebookshop.model.CartModel;
import com.onebookshop.model.UserModel;
import com.onebookshop.service.CartService;
import com.onebookshop.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ObsAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    /**
     * Called when a user has been successfully authenticated.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during the authentication process.
     */
    private UserService userService;
    private CartService cartService;

    public ObsAuthenticationSuccessHandler(String defaultTargetUrl) {
        super(defaultTargetUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        CartModel sessionCart = (CartModel) session.getAttribute("cart");
        UserModel user = getUserService().getCurrentUser();
        CartModel modifiedCart = mergeOrCreateCart(sessionCart, user);
        modifiedCart.setUser(user);
        cartService.updateOrCreateCart(modifiedCart);
        session.setAttribute("cart", modifiedCart);
        super.onAuthenticationSuccess(request, response, authentication);
    }

    private CartModel mergeOrCreateCart(CartModel cart, UserModel user){
        CartModel modifiedCart = new CartModel();
        if(null != cart) {
            modifiedCart.getEntries().addAll(cart.getEntries());
        }
        modifiedCart.getEntries().addAll(cartService.loadCart(user.getUserId()).getEntries());
        return modifiedCart;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CartService getCartService() {
        return cartService;
    }

    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }
}
