package com.avizva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.model.Feedback;
import com.avizva.service.FeedbackService;

@Controller
public class FeedbackController {

	private FeedbackService feedbackService;

	@RequestMapping(value = "saveFeedback", method = RequestMethod.POST)
	public ModelAndView saveFeedback(@ModelAttribute Feedback feedback) {
		Feedback savedFeedback = feedbackService.saveFeedback(feedback);
		if (savedFeedback == null) {
			return new ModelAndView("contactUs").addObject("result", "failure");
		}
		return new ModelAndView("contactUs").addObject("result", "success");
	}

}
