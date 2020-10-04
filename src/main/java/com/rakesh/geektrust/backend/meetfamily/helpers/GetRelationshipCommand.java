package com.rakesh.geektrust.backend.meetfamily.helpers;

import java.util.List;

import com.rakesh.geektrust.backend.meetfamily.constants.Relationship;

public class GetRelationshipCommand implements Command{

	@Override
	public void execute(List<String> args, FamilyTree tree) {
		tree.getRelationShip(args.get(0), Relationship.getRelation(args.get(1)));
	}

}
