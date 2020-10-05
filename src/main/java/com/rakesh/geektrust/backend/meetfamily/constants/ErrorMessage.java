package com.rakesh.geektrust.backend.meetfamily.constants;

/**
 * DESCRIPTOR - This is a enum class that declares constant messages for custom exceptions. 
 * 
 * @author Rakesh Swain
 * @version 0.0.1
 */
public enum ErrorMessage {


	/**
	 * Error message for scenarios where given message format is wrong. 
	 */
	COMMAND_NOT_FOUND("Given command dosent exist"),
	
	/**
	 * Error message for scenarios where given input format is wrong. 
	 */
	PATH_NOT_GIVEN("Path to the input file is not given in arguments"),
	
	/**
	 * Error message for scenarios where given input format is wrong. 
	 */
	RELATIONSHI_NOT_DEFINED("Given relationship not defined");
	
	public final String message;
	
	private ErrorMessage(String message) {
		this.message = message;
	} 
	
	public String toString() {
		return this.message;
	}
	
}
