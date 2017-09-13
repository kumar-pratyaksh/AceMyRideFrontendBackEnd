package com.avizva.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.User;
import com.avizva.service.LoginAuthService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginAuthService loginAuthService;
	
	@RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
	public ModelAndView performLogin(HttpSession session,@RequestParam("email")String email,@RequestParam("password")String password) {
		User user=loginAuthService.authenticate(email,password);
		
		if(user!=null)
		{
			setUserDetails(user,session);
			return new ModelAndView("home");
		}
		else
			return new ModelAndView("loginError");

	}
	
	private void setUserDetails(User user,HttpSession session){
		session.setAttribute("userId", user.getId());
		session.setAttribute("userEmail", user.getEmail());
		session.setAttribute("userName", user.getName());
		session.setAttribute("userContact", user.getContact());
//		session.setAttribute("userRole", user.getUserType());

	}
	
	
	@RequestMapping("/logout")
	public ModelAndView performLogout(HttpSession session)
	{
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
}