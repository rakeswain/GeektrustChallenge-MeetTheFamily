package com.rakesh.geektrust.backend.meetfamily.constants;

/**
 * Description - This is a enum class that represents genders. 
 * 
 * @author Rakesh Swain
 * @version 0.0.1
 **/
public enum Gender {

	MALE("Male"),
	FEMALE("Female");
	
	private final String gender;
	private Gender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * This method is responsible for getting the Gender based on string.
	 * 
	 * @param gender - String value
	 * @return Gender - Gender object
	 **/
	public static Gender getGender(String gender) {
		for (Gender value : Gender.values()) {
			if (value.getValue().equalsIgnoreCase(gender)) {
				return value;
			}
		}
		throw new RuntimeException(gender+" gender not found!");
	}
	public String getValue() {
		return this.gender;
	}
}
