package com.avizva.pojo;

import java.util.ArrayList;
import java.util.List;

public class SecurityQuestions {
	
	public static List<String> securityQuestions = new ArrayList<String>();
	
	static {
		securityQuestions.add("What is your mother's name?");
		securityQuestions.add("What do you do when idle?");
		securityQuestions.add("What was the name of your first friend?");
		securityQuestions.add("What was the name of your first friend?");
	}

	public static String getSecurityQuestion(int id) {
		return securityQuestions.get(id);
	}

}
