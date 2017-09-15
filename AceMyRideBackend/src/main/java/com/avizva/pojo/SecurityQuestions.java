package com.avizva.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Pojo of SecurityQuestions asked during registration of the user for security
 * purposes
 * 
 * @author Pratyaksh Kumar
 *
 */
public class SecurityQuestions {
	
	public static List<String> securityQuestions = new ArrayList<String>();
	
	static {
		securityQuestions.add("What is your mother's name?");
		securityQuestions.add("What do you do when idle?");
		securityQuestions.add("What was the name of your first friend?");
		securityQuestions.add("What was the name of your first friend?");
	}

	/**
	 * Static function to return the security question with given id
	 * 
	 * @param id
	 * @return String question with given id
	 */
	public static String getSecurityQuestion(int id) {
		return securityQuestions.get(id);
	}

}
