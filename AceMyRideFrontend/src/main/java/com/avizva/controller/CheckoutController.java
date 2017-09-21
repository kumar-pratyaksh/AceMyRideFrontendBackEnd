package com.avizva.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Address;
import com.avizva.model.Payment;
import com.avizva.model.User;
import com.avizva.model.UserOrders;
import com.avizva.service.CartService;
import com.avizva.service.UserOrdersService;
import com.avizva.service.UserService;

@Controller
public class CheckoutController {

	@Autowired
	private UserOrdersService userOrdersService;

	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;

	@RequestMapping("checkout")
	public ModelAndView viewCheckoutPage(HttpSession session) {
		int userId = (Integer) session.getAttribute("userId");
		User user = userService.getUser(userId);
		return new ModelAndView("checkout").addObject("addressList", user.getAddresses()).addObject("cartItems",
				cartService.getCartItemsForUser(userId));
	}

	@RequestMapping("payment")
	public ModelAndView saveOrder(@RequestParam(name = "howTo") String howTo, @RequestParam Address shippingAddress,
			HttpSession session) {
		int userId = (Integer) session.getAttribute("userId");
		boolean isNew = false;
		if ("new".equals(howTo))
			isNew = true;
		UserOrders orders = userOrdersService.saveOrder(userId, shippingAddress, isNew);
		return new ModelAndView("payment").addObject("order", orders);
	}

	@RequestMapping("doPayment")
	public ModelAndView doPayment(@RequestParam int orderId, @RequestParam Address billingAddress,
			@RequestParam(name = "howTo") String howTo, @RequestParam Payment payment) {
		if ("shipping".equals(howTo))
			billingAddress = null;
		boolean isNew = false;
		if ("new".equals(howTo))
			isNew = true;
		userOrdersService.updateOrderAfterPayment(orderId, billingAddress, payment, isNew);
		return new ModelAndView("redirect:profile");
	}

}
