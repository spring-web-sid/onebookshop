package com.onebookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("**/**")
public class HomePageController {

	@ModelAttribute("contextPath")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}


	@RequestMapping (value= {"user", "seller", "guest"},  method=RequestMethod.GET)
	public String get(Model model)
	{
		return "homePage";
	}
}
