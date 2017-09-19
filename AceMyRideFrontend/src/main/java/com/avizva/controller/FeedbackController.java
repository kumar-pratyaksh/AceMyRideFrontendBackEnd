package com.avizva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Feedback;
import com.avizva.service.FeedbackService;
import com.avizva.service.MailService;

/**
 * Feedback controller
 * 
 * @author Pratyaksh.Kumar
 *
 */
@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@Autowired
	private MailService mailService;

	/**
	 * Methods to handle requests for adding feedback
	 * 
	 * @param feedback
	 *            the feedback object to be saved
	 * @return ModelAndView returns the contactUs page view
	 */
	@RequestMapping(value = "saveFeedback", method = RequestMethod.POST)
	public ModelAndView saveFeedback(@ModelAttribute Feedback feedback) {
		Feedback savedFeedback = feedbackService.saveFeedback(feedback);
		if (savedFeedback == null) {
			return new ModelAndView("contactUs").addObject("result", "failure");
		}
		mailService.sendMail(feedback.getEmail(), "Thanks for submitting your feedback",
				"Thanks for submitting your feedback. Our customer care executive will connect with you within 24 hours.");
		return new ModelAndView("contactUs").addObject("result", "success");
	}

}
