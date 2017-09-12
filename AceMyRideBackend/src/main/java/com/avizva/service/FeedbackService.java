package com.avizva.service;

import java.util.List;

import com.avizva.model.Feedback;

public interface FeedbackService {

	public Feedback saveFeedback(Feedback feedback);

	public List<Feedback> getAllFeedbacks();

	public List<Feedback> getFeedbackByUserEmail(String userMail);

}
