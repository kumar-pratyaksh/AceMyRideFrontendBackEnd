package com.avizva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.avizva.config.AppConfig;
import com.avizva.service.MailService;

/**
 * Hello world!
 *
 */
@Component
public class App 
{
	@Autowired
	MailService mailServiceImpl;

	public void setMailServiceImpl(MailService mailServiceImpl) {
		this.mailServiceImpl = mailServiceImpl;
	}

	public static void main(String[] args)
    {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MailService m = new App().getMailService();
		System.out.println("Hello World!" + m);
		m.sendMail("kumar.pratyaksh93@gmail.com", "Test mail", "hello world");
    }

	MailService getMailService() {
		return mailServiceImpl;
	}
}
