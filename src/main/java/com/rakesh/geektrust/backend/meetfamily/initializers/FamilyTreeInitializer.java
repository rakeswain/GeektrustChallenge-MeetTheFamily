package com.rakesh.geektrust.backend.meetfamily.initializers;

import com.rakesh.geektrust.backend.meetfamily.beans.Member;
import com.rakesh.geektrust.backend.meetfamily.constants.Gender;
import com.rakesh.geektrust.backend.meetfamily.helpers.FamilyTree;

public class FamilyTreeInitializer {

	public static FamilyTree intilize() {
		
		Member king = new Member.MemberBuilder("King Shan", Gender.MALE).build();
		Member queen = new Member.MemberBuilder("Queen Anga", Gender.FEMALE)
								 .setSpouse(king).build();
	
		king.setSpouse(queen);
		
		FamilyTree tree = new FamilyTree(king, queen);
		tree.addChild("Queen Anga", "Ish", Gender.MALE);
		tree.addChild("Queen Anga", "Chit", Gender.MALE);
		tree.addChild("Queen Anga", "Vich", Gender.MALE);
		tree.addChild("Queen Anga", "Aras", Gender.MALE);
		tree.addChild("Queen Anga", "Satya", Gender.FEMALE);
		
		Member amba = new Member.MemberBuilder("Amba", Gender.FEMALE).build();
		tree.addSpouse(tree.getMemberByName("Chit"), amba);
		
		Member lika = new Member.MemberBuilder("Lika", Gender.FEMALE).build();
		tree.addSpouse(tree.getMemberByName("Vich"), lika);
		
		Member chitra = new Member.MemberBuilder("Chitra", Gender.FEMALE).build();
		tree.addSpouse(tree.getMemberByName("Aras"), chitra);
		
		Member vyan = new Member.MemberBuilder("Vyan", Gender.MALE).build();
		tree.addSpouse(tree.getMemberByName("Satya"), vyan);
		
		tree.addChild("Amba", "Dhrita",Gender.FEMALE);
		tree.addChild("Amba", "Tritha",Gender.FEMALE);
		tree.addChild("Amba", "Vritha",Gender.FEMALE);
		Member jaya = new Member.MemberBuilder("Jaya", Gender.MALE).build();
		tree.addSpouse(tree.getMemberByName("Dhrita"), jaya);
		tree.addChild("Dhrita", "Yodhan",Gender.MALE);
		
		tree.addChild("Lika", "Vila",Gender.FEMALE);
		tree.addChild("Lika", "Chika",Gender.FEMALE);
		
		tree.addChild("Chitra", "Ahit",Gender.MALE);
		tree.addChild("Chitra", "Jnki",Gender.FEMALE);
		
		Member arit = new Member.MemberBuilder("Arit", Gender.MALE).build();
		tree.addSpouse(tree.getMemberByName("Jnki"), arit);
		tree.addChild("Jnki", "Lavnya",Gender.FEMALE);
		tree.addChild("Jnki", "Lake",Gender.MALE);

		tree.addChild("Satya", "Asva",Gender.MALE);
		Member satvya = new Member.MemberBuilder("Satvy", Gender.FEMALE).build();
		tree.addSpouse(tree.getMemberByName("Asva"), satvya);
		tree.addChild("Satvy", "Vasa",Gender.MALE);


		tree.addChild("Satya", "Vyas",Gender.MALE);
		Member krpi = new Member.MemberBuilder("Krpi", Gender.FEMALE).build();
		tree.addSpouse(tree.getMemberByName("Vyas"), krpi);
		tree.addChild("Krpi", "Kriya",Gender.MALE);
		tree.addChild("Krpi", "Krithi",Gender.FEMALE);

		tree.addChild("Satya", "Atya",Gender.FEMALE);
			
		return  tree;
	}
	
}
