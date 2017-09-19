package com.avizva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Product;
import com.avizva.service.ProductService;
import com.avizva.util.JsonUtil;

@Controller
public class CategoryController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "categoryUser")
	public ModelAndView categoryUser(@RequestParam String name) {

		List<Product> list = productService.getProductUsingCategory(name);

		String productList = JsonUtil.convertToJson(list);
		String categoryName = JsonUtil.convertToJson(name);
		return new ModelAndView("productView").addObject("productList", productList).addObject("categoryName",
				categoryName);

	}

}
