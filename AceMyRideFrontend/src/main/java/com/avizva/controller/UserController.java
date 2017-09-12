package com.avizva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.User;
import com.avizva.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/registerUser")
	public ModelAndView showRegister() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user) {
		User savedUser = userService.saveUser(user);
		if (savedUser == null) {
			return new ModelAndView("error");
		}
		return new ModelAndView("login").addObject("user", savedUser);

	}

}
