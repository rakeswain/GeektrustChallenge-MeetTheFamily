package com.rakesh.geektrust.backend.meetfamily.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rakesh.geektrust.backend.meetfamily.beans.Member;
import com.rakesh.geektrust.backend.meetfamily.exceptions.InvalidInputException;

/**
 * This enum class defines all relationships.
 * 
 *  @author Rakesh Swain
 *  @version 0.0.1
 */
public enum Relationship {

	SON("Son") {

		@Override
		public List<Member> findRelatives(Member familyMember) {
			return familyMember.getChildren()
					.stream().filter((member) -> member.getGender() == Gender.MALE)
					.collect(Collectors.toList());
		}
		
	},
	PATERNAL_UNCLE("Paternal-Uncle") {
		@Override
		public List<Member> findRelatives(Member familyMember) {
			Member father = familyMember.getFather();
			return father == null ? new ArrayList<Member>() :  Relationship.SIBLINGS.findRelatives(father)
																				   .stream()
																				   .filter((member) -> member.getGender() == Gender.MALE)
																				   .collect(Collectors.toList());
		}
	},
	PATERNAL_AUNT("Paternal-Aunt") {
		@Override
		public List<Member> findRelatives(Member familyMember) {
			Member father = familyMember.getFather();
			return father == null ? new ArrayList<Member>() : Relationship.SIBLINGS.findRelatives(father)
		    							.stream()
		    							.filter((member) -> member.getGender() == Gender.FEMALE)
		    							.collect(Collectors.toList());
		}
	},
	MATERNAL_UNCLE("Maternal-Uncle") {
		@Override
		public List<Member> findRelatives(Member familyMember) {
			Member mother = familyMember.getMother();
			return mother == null ? new ArrayList<Member>() : Relationship.SIBLINGS.findRelatives(mother)
			    			 .stream()
			    		     .filter((member) -> member.getGender() == Gender.MALE)
			    			 .collect(Collectors.toList());
		}
	},
	MATERNAL_AUNT("Maternal-Aunt") {
		@Override
		public List<Member> findRelatives(Member familyMember) {
			  Member mother = familyMember.getMother();
			  return mother == null ? new ArrayList<Member>() : Relationship.SIBLINGS.findRelatives(mother)
			    			 .stream()
			    		     .filter((member) -> member.getGender() == Gender.FEMALE)
			    			 .collect(Collectors.toList());
		}
	},
	SISTER_IN_LAW("Sister-In-Law") {
		@Override
		public List<Member> findRelatives(Member familyMember) {
			Member spouse = familyMember.getSpouse();
			List<Member> sisterInLaws = new ArrayList<>();
			if (spouse != null) {
				sisterInLaws.addAll(Relationship.SIBLINGS.findRelatives(spouse)
			    									      .stream()
			    									      .filter((member) -> member.getGender() == Gender.FEMALE)
			    									      .collect(Collectors.toList()));
			}

			for (Member brother : Relationship.SIBLINGS.findRelatives(familyMember).stream()
									.			 filter((member) -> member.getGender() == Gender.MALE)
												.collect(Collectors.toList())) {
				sisterInLaws.add(brother.getSpouse());
			    	
			 }
			 return sisterInLaws;
		}
	},
	BROTHER_IN_LAW("Brother-In-Law") {
		@Override
		public List<Member> findRelatives(Member familyMember) {
		    Member spouse = familyMember.getSpouse();
		    List<Member> brotherInLowas = new ArrayList<>();
			if (spouse != null) {
				brotherInLowas.addAll(Relationship.SIBLINGS.findRelatives(spouse)
			    									      .stream()
			    									      .filter((member) -> member.getGender() == Gender.MALE)
			    									      .collect(Collectors.toList()));
			}
			
			for (Member brother : Relationship.SIBLINGS.findRelatives(familyMember).stream()
									.			 filter((member) -> member.getGender() == Gender.FEMALE)
												.collect(Collectors.toList())) {
				brotherInLowas.add(brother.getSpouse());
			    	
			 }
			 return brotherInLowas;
		}
	},
	DAUGHTER("Daughter") {
		@Override
		public List<Member> findRelatives(Member familyMember) {
			return familyMember.getChildren()
					.stream().filter((member) -> member.getGender() == Gender.FEMALE)
					.collect(Collectors.toList());
		}
	},
	SIBLINGS("Siblings") {
		@Override
		public List<Member> findRelatives(Member familyMember) {
			Member mother = familyMember.getMother();
			return mother == null ? new ArrayList<Member>() : mother.getChildren()
					.stream().filter((member) -> !(member.getName().equals(familyMember.getName())))
					.collect(Collectors.toList());
		}
	};
	
	private String relationship;
	
	Relationship(String relationship) {
		this.relationship = relationship;
	}
	
	public static Relationship getRelation(String relation) {
		for (Relationship value : Relationship.values()) {
			if (value.relationship.equalsIgnoreCase(relation)) {
				return value;
			}
		}
		throw new InvalidInputException(ErrorMessage.RELATIONSHI_NOT_DEFINED+" : "+relation);
	}
	
	/**
	 * This is the abstract method that which is implemented in each enum to get relatives of that perticular relation.
	 * 
	 * @param member - Member of which relatives are to be searched
	 * @return List<Member> - List of relatives
	 */
	public abstract List<Member> findRelatives(Member member);
}
