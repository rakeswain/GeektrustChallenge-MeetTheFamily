package com.rakesh.geektrust.backend.meetfamily.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rakesh.geektrust.backend.meetfamily.beans.Member;
import com.rakesh.geektrust.backend.meetfamily.constants.Gender;
import com.rakesh.geektrust.backend.meetfamily.constants.Relationship;

public class FamilyTree {

	private Member king;
	private Member queen;
	
	private Map<String , Member> familyTreeIndex;
	
	public FamilyTree(Member king, Member queen) {
		this.king = king;
		this.queen = queen;
		this.familyTreeIndex = new HashMap<String, Member>();
		addToIndex(king);
		addToIndex(queen);
	}
	
	public void addChild(String motherName, String childName, Gender gender) {
	
		if (this.containsChild(motherName)) {
			Member mother = this.getMemberByName(motherName);
			Member child = createChild(mother,childName, gender);
			mother.updateChildren(child);
			addToIndex(child);
		} else {
			System.out.println("PERSON NOT FOUND");
		}
	}
	
	public Member createChild(Member parent,String childName, Gender gender) {
		return new Member.MemberBuilder(childName, gender).setParent(parent).build();
	}

	
	public void addSpouse(Member husband, Member wife) {
		husband.setSpouse(wife);
		wife.setSpouse(husband);
		addToIndex(husband);
		addToIndex(wife);
	}
	
	private void addToIndex(Member member) {
		this.familyTreeIndex.put(member.getName(), member);
	}
	
	public Member getMemberByName(String name) {
		return this.familyTreeIndex.get(name);
	}

	public void getRelationShip(String name, Relationship relation)  {
		if (this.containsChild(name)) {
		  Member familyMember = this.getMemberByName(name);
		  List<Member> relatives = relation.findRelatives(familyMember);
		  String printMsg = relatives.size() == 0 ? "NONE" : relatives.stream()
				  													  .map(Member::getName)
				  													  .collect(Collectors.joining(" "));
		  System.out.println(printMsg);
	
		} else {
			System.out.println("PERSON NOT FOUND");
		}
		
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
