package com.rakesh.geektrust.backend.meetfamily.constants;

public enum Gender {

	MALE("Male"),
	FEMALE("Female");
	
	private final String gender;
	private Gender(String gender) {
		this.gender = gender;
	}
	
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
