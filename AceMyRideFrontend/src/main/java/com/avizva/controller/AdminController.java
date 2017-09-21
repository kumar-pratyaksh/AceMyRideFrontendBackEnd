package com.avizva.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Category;
import com.avizva.model.Product;
import com.avizva.model.Supplier;
import com.avizva.service.CategoryService;
import com.avizva.service.ProductService;
import com.avizva.service.SupplierService;

@Controller
public class AdminController {
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired 
	private ProductService productService;
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ModelAndView addProduct(@ModelAttribute Product product,@RequestParam("file") MultipartFile file) {
		Product savedProduct = productService.saveProduct(product,file);
		if (savedProduct == null) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST,consumes = {"multipart/form-data"})
	public ModelAndView updateProduct(@ModelAttribute Product product,@RequestParam("file") MultipartFile file) {
		Product updatedProduct = productService.updateProduct(product,file);
		if (updatedProduct == null) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute Product product) {
		
		boolean wasDeleted= productService.deleteProduct(product.getId());
		if (wasDeleted==false) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/viewProducts", method = RequestMethod.POST)
	public ModelAndView viewProducts() {
	
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute Category category) {
		Category savedCategory = categoryService.saveCategory(category);
		if (savedCategory == null) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public ModelAndView updateCategory(@ModelAttribute Category category) {
		Category updatedCategory = categoryService.updateCategory(category);
		if (updatedCategory == null) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
	public ModelAndView deleteCategory(@ModelAttribute Category category) {
		
		boolean wasDeleted= categoryService.deleteCategory(category.getId());
		if (wasDeleted==false) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/viewCategories", method = RequestMethod.POST)
	public ModelAndView viewCategories() {
	
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public ModelAndView addSupplier(@ModelAttribute Supplier supplier) {
		
		Supplier savedSupplier = supplierService.saveSupplier(supplier);
		if (savedSupplier == null) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/updateSupplier", method = RequestMethod.POST)
	public ModelAndView updateSupplier(@ModelAttribute Supplier supplier) {
		
		Supplier updatedSupplier = supplierService.updateSupplier(supplier);
		if (updatedSupplier == null) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/deleteSupplier", method = RequestMethod.POST)
	public ModelAndView deleteSupplier(@ModelAttribute Supplier supplier) {
		
		boolean wasDeleted= supplierService.deleteSupplier(supplier.getId());
		if (wasDeleted==false) {
			return new ModelAndView("error");
		}
		
		return new ModelAndView("redirect:/adminPage");
	}
	
	@RequestMapping(value = "/viewSuppliers", method = RequestMethod.POST)
	public ModelAndView viewSuppliers() {
	
		
		return new ModelAndView("redirect:/adminPage");
	}	
	
	@RequestMapping(value="/adminPage")
	public ModelAndView callAdmin(){
		servletContext.setAttribute("listOfCategories", categoryService.getAllCategories());
		return new ModelAndView("adminPanel").addObject("listSuppliers", supplierService.getAllSuppliers())
				.addObject("listCategories", categoryService.getAllCategories()).addObject("listProducts", productService.getAllProducts());
	}
}
