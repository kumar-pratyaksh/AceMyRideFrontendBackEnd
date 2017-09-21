package com.avizva.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.CartItem;
import com.avizva.service.CartService;
import com.avizva.util.JsonUtil;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping("cart")
	public ModelAndView viewCart(HttpSession session){
		return new ModelAndView("cart").addObject("listCartItems",
				JsonUtil.convertToJson(cartService.getCartItemsForUser((Integer) session.getAttribute("userId"))));
	}

	@RequestMapping(value = "addToCart", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView addItemToCart(@RequestParam(required = false) Integer productId,
			@RequestParam(required = false) Integer quantity, HttpSession session) {
		if (session.getAttribute("isLoggedIn") == null || !(Boolean) session.getAttribute("isLoggedIn")) {
			session.setAttribute("redirectTo", "addToCart");
			session.setAttribute("wasRedirectedToLoginByAddCart", true);
			session.setAttribute("productId", productId);
			session.setAttribute("quantity", quantity);
			return new ModelAndView("redirect:/login");
		}
		int userId = (Integer) session.getAttribute("userId");
		if (session.getAttribute("wasRedirectedToLoginByAddCart") != null
				&& (Boolean) session.getAttribute("wasRedirectedToLoginByAddCart")) {
			productId = (Integer) session.getAttribute("productId");
			quantity = (Integer) session.getAttribute("quantity");
			session.removeAttribute("wasRedirectedToLoginByAddCart");
			session.removeAttribute("productId");
			session.removeAttribute("quantity");
		}
		cartService.addToCart(productId, userId, quantity);
		return new ModelAndView("redirect:cart");

	}

	@RequestMapping(value = "updateCartItem")
	public ModelAndView updateCartItem(@ModelAttribute CartItem cartItem) {
		cartService.updateCartItem(cartItem);
		return new ModelAndView("redirect:cart");
	}

	@RequestMapping(value = "deleteCartItem")
	public ModelAndView deleteCartItem(@ModelAttribute CartItem cartItem) {
		cartService.deleteCartItem(cartItem);
		return new ModelAndView("redirect:cart");
	}

	@RequestMapping(value = "checkout", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView showCheckout(@RequestParam(required = false) Integer productId,
			@RequestParam(required = false) Integer quantity, HttpSession session) {
		return new ModelAndView("checkout").addObject("listCartItems",
				JsonUtil.convertToJson(cartService.getCartItemsForUser((Integer) session.getAttribute("userId"))));

	}

}
