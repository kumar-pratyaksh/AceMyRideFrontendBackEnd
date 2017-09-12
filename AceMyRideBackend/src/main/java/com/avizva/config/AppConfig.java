package com.avizva.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@ComponentScan(basePackages = "com.avizva")
public class AppConfig implements TransactionManagementConfigurer {

	/*
	 * private static final ch.qos.logback.classic.Logger Logger =
	 * LoggerFactory.getLogger(AppConfig.class);
	 */

	public PlatformTransactionManager annotationDrivenTransactionManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Bean(name = "mailSender")
	public JavaMailSender getJavaMailSender() {
		System.out.println("creating java bean of mailer");
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("contact.acemyride@gmail.com");
		mailSender.setPassword("#acemyride2017");
		Properties properties = mailSender.getJavaMailProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "false");

		System.out.println("JAVA MAIL IMPL SENDER " + mailSender);
		return mailSender;
	}
}
