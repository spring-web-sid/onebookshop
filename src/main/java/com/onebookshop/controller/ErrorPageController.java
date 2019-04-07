package com.onebookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {

	@RequestMapping(value = "/error/{code}/{dummy}")
	public String renderErrorPage(@PathVariable("code") Integer code) {
		String errorPage = null;
		switch (code) {
		case 403:
			errorPage = "/error/error403";
			break;
		case 404:
			errorPage = "/error/error404";
			break;
		case 500:
			errorPage = "/error/error500";

		}
		return errorPage;
	}
}
