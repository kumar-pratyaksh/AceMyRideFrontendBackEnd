package com.avizva.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.avizva.service.MailService;

@Component
public class MailServiceImpl implements MailService {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(String to, String subject, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setText(message);
		mailMessage.setSubject(subject);
		LOGGER.info("Sending mail to " + to + " with subject " + subject);
		mailSender.send(mailMessage);
		LOGGER.info("Mail sent");
	}


}
