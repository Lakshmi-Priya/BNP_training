package com.feedback.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.demo.exception.*;
import com.feedback.demo.dao.FeedbackDAO;
import com.feedback.demo.model.Feedback;
import com.feedback.demo.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDAO dao;
	
	@Override
	public Feedback createFeedback(Feedback feedback) {
		return dao.save(feedback);
	}

	@Override
	public List<Feedback> getFeedbacksByUsername(String username) throws BusinessException {
		List<Feedback> f = dao.findByUsername(username);
		if(f.size()<=0)
		{
			throw new BusinessException("No user found");
		}
		return f;
	}

	@Override
	public String updateFeedback(Feedback feedback)throws BusinessException {
		
		//return dao.save(feedback);
		Feedback feedback1=null;
		try {
			feedback1=dao.findById(feedback.getId()).get();
			if(feedback1.getId()==feedback.getId()) {
				dao.save(feedback);
				return "Succesfully updated";
			}
			
			}catch(NoSuchElementException e) {
				throw new BusinessException("Id "+feedback.getId()+" does not exits");
			}
			return null;
	}

	@Override
	public String deleteFeedback(int id)  throws BusinessException {
		if(id<=0) {
			throw new BusinessException("Id "+id +" is invalid");
		}
		Feedback feedback=null;
		try {
		feedback=dao.findById(id).get();
		if(feedback.getId()==id) {
			dao.deleteById(id);
			return "Succesfully deleted";
		}
		
		}catch(NoSuchElementException e) {
			throw new BusinessException("Id "+id+" does not exits");
		}
		return null;
		
		
	}

	@Override
	public List<Feedback> getAllFeedbacks()  throws BusinessException {
		List<Feedback> f = dao.findAll();
		if(f.size()<=0)
		{
			throw new BusinessException("No feedbacks available");
		}
		return f;
	}

}
