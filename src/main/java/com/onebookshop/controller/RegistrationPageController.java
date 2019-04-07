package com.onebookshop.controller;

import com.onebookshop.form.RegistrationForm;
import com.onebookshop.model.RoleModel;
import com.onebookshop.model.UserModel;
import com.onebookshop.service.RegistrationService;
import com.onebookshop.util.OneBookShopPwdEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegistrationPageController {

	@ModelAttribute("contextPath")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private OneBookShopPwdEncoder passwordEncoder;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String registerUser(Model model, HttpServletRequest request) {
		model.addAttribute("registrationForm", new RegistrationForm());
		model.addAttribute("role", "ROLE_USER");
		return "registrationPage";
	}
	
	@RequestMapping(value="/seller", method=RequestMethod.GET)
	public String registerSeller(Model model) {
			model.addAttribute("registrationForm", new RegistrationForm());
			model.addAttribute("role", "ROLE_SELLER");
			return "registrationPage";
		}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String saveUser(Model model, @ModelAttribute("registrationForm") RegistrationForm registrationForm) {
		UserModel user = new UserModel();
		RoleModel role = new RoleModel();
		
		user.setName(registrationForm.getName());
		user.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
		user.setMailId(registrationForm.getMailId());
		user.setPhoneNo(registrationForm.getPhoneNo());
		user.setAddress1(registrationForm.getAddress1());
		user.setAddress2(registrationForm.getAddress2());
		user.setEnabled(true);
		
		role.setRole(registrationForm.getRole());
		user.setRole(role);
		String userId = registrationService.saveUser(user);
		model.addAttribute("userId", userId);
		model.addAttribute("userName", registrationForm.getName());
		return "registrationConfirmation";
	}
}