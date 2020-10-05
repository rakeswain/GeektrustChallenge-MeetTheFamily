package com.rakesh.geektrust.backend.meetfamily.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rakesh.geektrust.backend.meetfamily.beans.Member;
import com.rakesh.geektrust.backend.meetfamily.constants.Gender;
import com.rakesh.geektrust.backend.meetfamily.constants.Relationship;
import com.rakesh.geektrust.backend.meetfamily.constants.Status;

/**
 * Description - This class handles all the family tree operations. It is intialized by the FamilyTreeInitializer
 * 
 * @author Rakesh Swain
 * @version 0.0.1
 */
public class FamilyTree {

	private Member king;
	private Member queen;
	
	/** This is a hash map that uses child's name as key and child instance as value.
	 *  This is responsible for easy and faster look up.
	 */
	private Map<String , Member> familyTreeIndex;
	
	/**
	 *  Descripion - This constructor is responsible for initializing the king and queen.
	 *
	 */
	public FamilyTree(Member king, Member queen) {
		this.king = king;
		this.queen = queen;
		this.familyTreeIndex = new HashMap<String, Member>();
		addToIndex(king);
		addToIndex(queen);
	}
	
	/**
	 * This method is responsible for adding child to the family tree.
	 * 
	 * @param motherName - String value that holds the name of the mother
	 * @param childName - String value that holds the name of the child
	 * @param gender - Gender enum that holds the gender of the child
	 * @return String - status message  based on child addition success or failure
	 */
	public String addChild(String motherName, String childName, Gender gender) {
		String status = "";
		if (this.containsChild(motherName)) {
			Member mother = this.getMemberByName(motherName);
			Member child = createChild(mother,childName, gender);
			status = addChild(mother,child);
		} else {
			status = Status.PERSON_NOT_FOUND.getStatus();
		}
		return status;
	}
	
	/**
	 * This method is responsible for adding child to the family tree.
	 * 
	 * @param mother - Mother member instance
	 * @param child - Child member instance
	 * @return String - status message  based on child addition success or failure
	 */
	public String addChild(Member mother, Member child) {
		String status = "";
		if (mother.updateChildren(child)) {
			addToIndex(child);
			status = Status.CHILD_ADDITION_SUCCEEDED.getStatus();
		} else {
			status = Status.CHILD_ADDITION_FAILED.getStatus();
		}
		return status;
	}
	
	/**
	 * This method is responsible for creating a member that doesnt exist.
	 * 
	 * @param parent - Member instance of the parent 
	 * @param child - Child name string value
	 * @param gender - Gender type
	 * @return Member - Member instance of the created child
	 */
	public Member createChild(Member parent,String childName, Gender gender) {
		return new Member.MemberBuilder(childName, gender).setParent(parent).build();
	}

	/**
	 * This method is responsible for adding spouse to an existing member.
	 * 
	 * @param memberName - Name of the member to which spouse will be added.
	 * @param spouse - Member instance of spouse.
	 * @return String - status message  based on spouse addition success or failure
	 */
	public String addSpouse(String memberName, Member spouse) {
		String status = "";
		if (this.containsChild(memberName)) {
			Member member = this.getMemberByName(memberName);
			member.setSpouse(spouse);
			spouse.setSpouse(member);
			addToIndex(spouse);
			status = Status.SPOUSE_ADDITION_SUCCEEDED.getStatus();
		} else {
			status = Status.PERSON_NOT_FOUND.getStatus();

		}
		return status;
	}
	
	// This method is responsible for adding a child to the tree index for easier look up.
	private void addToIndex(Member member) {
		this.familyTreeIndex.put(member.getName(), member);
	}
	
	public Member getMemberByName(String name) {
		return this.familyTreeIndex.get(name);
	}

	/**
	 * This method is responsible for getting relationhip of a member
	 * It uses the Relation enum to get the relatives.
	 * 
	 * @param name - String value of member name 
	 * @param relation - Relation type
	 * @return String - List of relatives joined by whitespace
	 */
	public String getRelationShip(String name, Relationship relation)  {
		String status = "";
		if (this.containsChild(name)) {
		  Member familyMember = this.getMemberByName(name);
		  List<Member> relatives = relation.findRelatives(familyMember);
		  status = relatives.size() == 0 ? Status.NO_RELATIVES.getStatus() : relatives.stream()
				  													  .map(Member::getName)
				  													  .collect(Collectors.joining(" "));
	
		} else {
			status = Status.PERSON_NOT_FOUND.getStatus();
		}
		return status;
	}

	public Member getKing() {
		return king;
	}

	public Member getQueen() {
		return queen;
	}
	
	public boolean containsChild(String name) {
		return this.familyTreeIndex.containsKey(name);
	}

	
}
