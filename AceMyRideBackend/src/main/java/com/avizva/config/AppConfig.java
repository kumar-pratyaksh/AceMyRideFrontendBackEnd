package com.avizva.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * 
 * Configuration class for enabling transaction management and component scan
 * 
 * @see TransactionManagementConfigurer
 * @author Pratyaksh Kumar
 */

@Configuration
@ComponentScan(basePackages = "com.avizva")
public class AppConfig implements TransactionManagementConfigurer {

	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return null;
	}
}
