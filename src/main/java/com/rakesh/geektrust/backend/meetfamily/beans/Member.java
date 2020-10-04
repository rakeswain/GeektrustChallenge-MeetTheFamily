package com.rakesh.geektrust.backend.meetfamily.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rakesh.geektrust.backend.meetfamily.constants.Gender;

public class Member {
	
	private final String name;
	private final Gender gender;
	private Member spouse;
	private Member parent;
	private List<Member> children;

	
	public static class MemberBuilder {
		private final String name;
		private final Gender gender;
		private Member spouse;
		private Member parent;
		private List<Member> children;
		
		public MemberBuilder(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
			this.children = new ArrayList<Member>();
		}
		
		public MemberBuilder setParent(Member parent) {
			this.parent = parent;
			return this;
		}
		
		public MemberBuilder setSpouse(Member spouse) {
			this.spouse = spouse;
			return this;
		}
		
		public Member build() {
			return new Member(this);
		}
	}
	
	private Member(MemberBuilder builder) {
		this.name = builder.name;
		this.gender = builder.gender;
		this.spouse = builder.spouse;
		this.children = builder.children;
		this.parent = builder.parent;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Member getSpouse() {
		return spouse;
	}
	
	public void setSpouse(Member spouse) {
		this.spouse = spouse;
	}
	
	public List<Member> getChildren() {
		return children;
	}
	
	public Member getFather() {
		return this.parent.gender == Gender.MALE ? this.parent : this.parent.spouse;		
	}
	
	public Member getMother() {
		// TODO add optional
		if (this.parent != null)
			return this.parent.gender == Gender.FEMALE ? this.parent : this.parent.spouse;
		return null;
	}
	
	public List<Member> getSiblings() {
		return this.parent.getChildren()
				 .stream()
				 .filter((member) -> !member.getName().equals(this.getName())).collect(Collectors.toList());
	}
	
	public boolean updateChildren(Member child) {
		if (this.gender == Gender.FEMALE) {
			this.children.add(child); 
			return true;
		} else {
			return false;
		}
	}
	
}
