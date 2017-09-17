package com.avizva.service;

import java.util.List;

import com.avizva.dao.FeedbackDao;
import com.avizva.model.Feedback;

/**
 * Feedback Service for accessing {@link FeedbackDao}
 * 
 * @author Pratyaksh.Kumar
 *
 */
public interface FeedbackService {

	/**
	 * Save feedback to the database
	 * 
	 * @param feedback
	 *            The feedback objec to be saved
	 * @return Feedback the saved feedback object
	 */
	public Feedback saveFeedback(Feedback feedback);

	/**
	 * Gets all the saved feedbacks from the database
	 * 
	 * @return List<Feedback> the list of all the saved feedbacks
	 */
	public List<Feedback> getAllFeedbacks();

	/**
	 * Gets the feedback submitted using a particular email id
	 * 
	 * @param userMail
	 *            The email id used to submit the feedback
	 * @return List<Feedback> list of saved feedbacks
	 */
	public List<Feedback> getFeedbackByUserEmail(String userMail);

}
