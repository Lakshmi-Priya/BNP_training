package com.feedback.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.feedback.demo.exception.BusinessException;
import com.feedback.demo.model.*;
import com.feedback.demo.service.*;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService service;
	private MultiValueMap<String, String> map;
	@PostMapping("/feedback")
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		return service.createFeedback(feedback);
	}

	@GetMapping("/feedback/{username}")
	public ResponseEntity<List<Feedback>> getFeedbacksByUsername(@PathVariable("username")String username) {
		try {
			return new ResponseEntity<>(service.getFeedbacksByUsername(username),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<>(null,map, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/feedback")
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		return service.updateFeedback(feedback);
	}

	@DeleteMapping("/feedback/{id}")
	public ResponseEntity<String> deleteFeedback(@PathVariable("id") int id) {
		try {
			
			return new ResponseEntity<String>(service.deleteFeedback(id),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<String>(null,map, HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedbacks() {
		try {
			return new ResponseEntity<>(service.getAllFeedbacks(),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<>(null,map, HttpStatus.NOT_FOUND);
		}
		
	}

}
