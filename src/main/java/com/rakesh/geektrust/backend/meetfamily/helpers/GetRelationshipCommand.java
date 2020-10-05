package com.rakesh.geektrust.backend.meetfamily.helpers;

import java.util.List;

import com.rakesh.geektrust.backend.meetfamily.constants.Relationship;

/**
 * Description - This is an implementation of Command interface.
 * 
 * @author Rakesh Swain
 * @version 0.0.1
 */
public class GetRelationshipCommand implements Command{

	/**
	 * This method is responsible for executing get relationship operation.
	 * It performs the operation and prints the status. 
	 * 
	 * @param args : List of strings containing user arguments 
	 * @param tree : FamilyTree instance
	 */
	@Override
	public void execute(List<String> args, FamilyTree tree) {
		System.out.println(tree.getRelationShip(args.get(0), 
				Relationship.getRelation(args.get(1))));
	}

}
