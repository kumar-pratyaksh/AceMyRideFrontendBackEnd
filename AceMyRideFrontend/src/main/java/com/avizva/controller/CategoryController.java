package com.avizva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.service.CategoryService;
import com.avizva.service.ProductService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@RequestMapping("category")
	public ModelAndView getProductsByCategory() {
		return new ModelAndView("category");
	}

}
