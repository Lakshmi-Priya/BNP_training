package com.feedback.demo.service;


import java.util.List;

import com.feedback.demo.exception.*;
import com.feedback.demo.model.*;

public interface FeedbackService {

	public Feedback createFeedback(Feedback feedback);
	public List<Feedback> getFeedbacksByUsername(String username) throws BusinessException;
	public String updateFeedback(Feedback feedback) throws BusinessException;
	public String deleteFeedback(int id)  throws BusinessException;
	public List<Feedback> getAllFeedbacks()  throws BusinessException;
}
