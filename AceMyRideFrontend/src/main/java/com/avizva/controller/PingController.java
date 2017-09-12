package com.avizva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avizva.service.MailService;

@Controller
public class PingController {

	@Autowired
	private MailService mailService;

	@RequestMapping("/ping")
	@ResponseBody
	public String ping() {
		mailService.sendMail("kumar.pratyaksh93@gmail.com", "test mail", "hello world from acemyride");
		return "Hello world";
	}

}
