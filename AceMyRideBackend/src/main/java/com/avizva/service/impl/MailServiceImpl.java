package com.avizva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.avizva.service.MailService;

@Component
public class MailServiceImpl implements MailService {


	@Autowired
	private JavaMailSender mailSender;


	public void sendMail(String to, String subject, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setText(message);
		mailMessage.setSubject(subject);

		System.out.println("MAIL SENDER BEAN " + mailSender);
		mailSender.send(mailMessage);
	}


}
