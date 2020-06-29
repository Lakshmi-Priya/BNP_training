package com.app.exception;

//Customized Exception class

public class BusinessException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	public BusinessException(final String message) {
		super(message);
	}

}
