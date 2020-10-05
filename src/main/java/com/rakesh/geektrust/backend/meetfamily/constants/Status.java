package com.rakesh.geektrust.backend.meetfamily.constants;

/**
 * This enum represents different status messages.
 * 
 *  @author Rakesh Swain
 *  @version 0.0.1
 */
public enum Status {

	CHILD_ADDITION_FAILED("CHILD_ADDITION_FAILED"),
	PERSON_NOT_FOUND("PERSON_NOT_FOUND"),
	CHILD_ADDITION_SUCCEEDED("CHILD_ADDITION_SUCCEEDED"),
	NO_RELATIVES("NONE"),
	SPOUSE_ADDITION_SUCCEEDED("SPOUSE_ADDITION_SUCCEEDED");
	
	
	private String status;
	
	Status(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
