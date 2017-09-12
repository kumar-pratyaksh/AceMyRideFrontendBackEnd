package com.avizva.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.FeedbackDao;
import com.avizva.model.Feedback;
import com.avizva.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	public Feedback saveFeedback(Feedback feedback) {
		return feedbackDao.save(feedback);
	}

	public List<Feedback> getAllFeedbacks() {
		return feedbackDao.getAll();
	}

	public List<Feedback> getFeedbackByUserEmail(String userMail) {
		return feedbackDao.get(userMail);
	}

}
