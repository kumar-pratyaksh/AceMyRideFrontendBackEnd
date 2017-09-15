package com.avizva.dao;

import java.util.List;

import com.avizva.model.Feedback;

/**
 * Dao for user feedbacks
 * 
 * @author Pratyaksh.Kumar
 *
 */
public interface FeedbackDao {

	/**
	 * Method to save the feedback and return the saved feedback
	 * 
	 * @param feedback
	 *            feedback to be saved
	 * @return Feedback
	 */
	public Feedback save(Feedback feedback);

	/**
	 * Method to return all the feedback entered
	 * 
	 * @return List<Feedback> returns the list of feedbacks
	 */
	public List<Feedback> getAll();

	/**
	 * Method to return all the feedback entered with a given email id
	 * 
	 * @param userEmail
	 *            the email address of the user we want to extract
	 * @return
	 */
	public List<Feedback> get(String userEmail);

}
