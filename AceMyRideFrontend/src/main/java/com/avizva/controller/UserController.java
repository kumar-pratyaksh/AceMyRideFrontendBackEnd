package com.avizva.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.User;
import com.avizva.service.MailService;
import com.avizva.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@RequestMapping("/registerUser")
	public ModelAndView showRegister() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute User user, BindingResult result) {
		System.out.println(result.getAllErrors());
		System.out.println(user);
		User savedUser = userService.saveUser(user);
		if (savedUser == null) {
			return new ModelAndView("error");
		}
		mailService.sendMail(savedUser.getEmail(), "Thanks for registration",
				"Thank you for registring on our site. We look forward to serve you in the future");
		return new ModelAndView("redirect:/").addObject("user", savedUser);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "birthDate", new CustomDateEditor(format, false));

	}

}
