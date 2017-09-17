package com.avizva.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
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

	@RequestMapping("/profile")
	public ModelAndView showUser(HttpSession session) {
		int id=(Integer) session.getAttribute("userId");
		session.setAttribute("user", userService.getUser(id));
		return new ModelAndView("userProfile");
	}
	
	
	@RequestMapping(value="/submitUpdate", method = RequestMethod.POST)
	public ModelAndView submitUpdate(HttpSession session,@ModelAttribute User user) {
		User updatedUser=userService.updateUser(user);
		
		session.setAttribute("user", updatedUser);
		return new ModelAndView("userProfile");
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
	
	@RequestMapping("/deactivateUser")
	public ModelAndView showDeactication() {
		return new ModelAndView("deactivate");
	}
	
	@RequestMapping(value = "/deactivate")
	public ModelAndView deactivation(HttpSession session)
	{
		if(session.getAttribute("isLoggedIn")==null)
		{
			return new ModelAndView("redirect:/login");
		}
		else
		{
			int id=(Integer) session.getAttribute("userId");
			System.out.println(id);
			boolean flag=userService.deactivateUser(id);
			if (!flag) {
				return new ModelAndView("error");
			}
			else
				return new ModelAndView("redirect:/logout");
		}
		
	}

}
