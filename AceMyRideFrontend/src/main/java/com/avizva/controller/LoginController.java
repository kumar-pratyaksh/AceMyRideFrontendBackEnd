package com.avizva.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.User;
import com.avizva.service.LoginAuthService;

/**
 * Controller to handle user login logout requests
 * 
 * @author Prateek
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginAuthService loginAuthService;
	
	/**
	 * Method to handle login requests
	 * 
	 * @param session
	 * @param email
	 * @param password
	 * @return The appropriate view
	 */
	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public ModelAndView performLogin(HttpSession session, @RequestParam("email") String email,
			@RequestParam("password") String password) {
		User user=loginAuthService.authenticate(email,password);
		System.out.println("Inside Login Submit Controller" + user);
		if(user!=null)
		{
			setUserDetails(user,session);
			if (session.getAttribute("redirectTo") != null) {
				return new ModelAndView("redirect:" + (String) session.getAttribute("redirectTo"));
			}
			return new ModelAndView("redirect:/");
		}
		else
			return new ModelAndView("loginError");

	}
	
	private void setUserDetails(User user,HttpSession session){
		session.setAttribute("isLoggedIn", true);
		session.setAttribute("enabled", user.isEnabled());
		
		session.setAttribute("userId", user.getId());
		session.setAttribute("userEmail", user.getEmail());
		session.setAttribute("userName", user.getName());
		session.setAttribute("userContact", user.getContact());

		session.setAttribute("userRole", user.getUserType());

	}
	
	/**
	 * Method to handle logout request
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/userLogout")
	public ModelAndView performLogout(HttpSession session)
	{
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
}