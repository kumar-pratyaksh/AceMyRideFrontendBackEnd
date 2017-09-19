package com.avizva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Product;
import com.avizva.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/product")
	public ModelAndView showProduct(@RequestParam int id) {
		Product product = productService.getProduct(id);
		return new ModelAndView("product").addObject("product", product);
	}

}
