package com.rakesh.geektrust.backend.meetfamily.helpers;

import java.util.List;

import com.rakesh.geektrust.backend.meetfamily.constants.Gender;

public class AddChildCommand implements Command{

	@Override
	public void execute(List<String> args, FamilyTree tree) {
		tree.addChild(args.get(0), args.get(1), Gender.getGender(args.get(2)));
		System.out.println("CHILD ADDITION SUCCEEDED");
	}

}
