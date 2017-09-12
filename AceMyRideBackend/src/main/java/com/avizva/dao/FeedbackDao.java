package com.avizva.dao;

import java.util.List;

import com.avizva.model.Feedback;

public interface FeedbackDao {

	public Feedback save(Feedback feedback);

	public List<Feedback> getAll();

	public List<Feedback> get(String userEmail);

}
