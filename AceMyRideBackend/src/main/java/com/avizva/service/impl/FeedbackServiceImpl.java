package com.avizva.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.FeedbackDao;
import com.avizva.model.Feedback;
import com.avizva.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	private static final Logger LOGGER = LogManager.getLogger(FeedbackServiceImpl.class);

	@Autowired
	private FeedbackDao feedbackDao;

	public Feedback saveFeedback(Feedback feedback) {
		LOGGER.info("Saving user feedback for email id:" + feedback.getEmail());
		return feedbackDao.save(feedback);
	}

	public List<Feedback> getAllFeedbacks() {
		return feedbackDao.getAll();
	}

	public List<Feedback> getFeedbackByUserEmail(String userMail) {
		return feedbackDao.get(userMail);
	}

}
