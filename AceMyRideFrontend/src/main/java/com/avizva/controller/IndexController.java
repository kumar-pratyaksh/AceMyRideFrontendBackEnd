package com.avizva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.pojo.SecurityQuestions;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView showIndex(){
		return new ModelAndView("home");
	}
	
	@RequestMapping("/aboutUs")
	public ModelAndView showAboutUs() {
		return new ModelAndView("aboutUs");
	}
	
	@RequestMapping("/contactUs")
	public ModelAndView showContactUs() {
		return new ModelAndView("contactUs");
	}

	@RequestMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login").addObject("securityQuestions", SecurityQuestions.securityQuestions);
	}
	
	
}
