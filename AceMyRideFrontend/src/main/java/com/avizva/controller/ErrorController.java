package com.avizva.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {

	private static final Logger LOGGER = LogManager.getLogger();

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest request, Exception e) {
		LOGGER.error(e);
		return new ModelAndView("error");
	}

}
