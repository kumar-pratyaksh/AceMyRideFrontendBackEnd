package com.avizva.service;

/**
 * Service to send mails
 * 
 * @author Pratyaksh Kumar
 *
 */
public interface MailService {

	/**
	 * Method to send mail
	 * 
	 * @param to
	 *            Email address of the user to whom the email is being send
	 * @param subject
	 *            Subject of the mail
	 * @param message
	 *            Message to be send
	 */
	public void sendMail(String to, String subject, String message);
}
