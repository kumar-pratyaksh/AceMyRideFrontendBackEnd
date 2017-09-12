package com.avizva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//Equivalent to web.xml

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


	@Override
	protected Class[] getRootConfigClasses() {
		return new Class[] { AppConfig.class, ApplicationContextConfig.class };
	}

	@Override
	protected Class[] getServletConfigClasses() {
		return new Class[] { AppConfig.class, ApplicationContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Bean
	public ViewResolver viewResolver() {
		/* Logger.debug("Starting of the method viewResolver"); */

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		/* Logger.debug("Ending of the method viewResolver"); */
		return viewResolver;
	}
}