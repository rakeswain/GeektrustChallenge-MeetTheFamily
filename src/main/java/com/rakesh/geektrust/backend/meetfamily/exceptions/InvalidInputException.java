package com.rakesh.geektrust.backend.meetfamily.exceptions;

import com.rakesh.geektrust.backend.meetfamily.constants.ErrorMessage;

/**
 * This is a custom exception thrown for invalid user inputs.
 */
public class InvalidInputException extends RuntimeException{
	
	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
		super();
	}
	
	public InvalidInputException(ErrorMessage exception) {
		super(exception.message);
	}
	
	public InvalidInputException(String msg) {
		super(msg);
	}
}