package com.onebookshop.controller;

import com.onebookshop.dto.Role;
import com.onebookshop.dto.UserData;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginPageController {

	//Handler methods for user
	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public String loginUser(Model model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}

		return "user/userLoginPage";

	}

	@RequestMapping(value = "/user/welcome", method = RequestMethod.GET)
	public String defaultPage(Model model, HttpServletRequest request) {
		setUserInSession(request);
		return "redirect:/user/book/all";
	}

	//Handler methods for seller

	@RequestMapping(value = "/loginSeller", method = RequestMethod.GET)
	public String loginSeller(Model model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}

		return "seller/sellerLoginPage";

	}

	@RequestMapping(value = "/seller/welcome", method = RequestMethod.GET)
	public String adminPage(HttpServletRequest request) {
		UserData user = (UserData)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = user.getUserId();
		//redirectAttributes.addFlashAttribute("userid", userId);
		setUserInSession(request);
		return "redirect:/seller/" + userId;
	}
	
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Model model) {

		return "redirect:/home";

	}

	protected void setUserInSession(HttpServletRequest request) {
		List<Role> role = (List<Role>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		UserData user = (UserData)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = user.getUserId();
		HttpSession session = request.getSession(false);
		session.setAttribute("loggedInUser", userId);
		if(role.size() != 0) {
			session.setAttribute("ROLE", role.get(0));
		}
	}
}