package com.rakesh.geektrust.backend.meetfamily.utils;

import java.util.List;

import com.rakesh.geektrust.backend.meetfamily.helpers.Command;
import com.rakesh.geektrust.backend.meetfamily.helpers.FamilyTree;

/**
 * Description - This class encapsulates the user input.
 * 
 * @author Rakesh Swain
 * @version 0.0.1
 */
public class Input {

	private List<String> args;
	// An implementation of the Command interface is injected here to process the input
	private Command command;
	
	public Input(List<String> args, Command command) {
		this.args = args;
		this.command = command;
	}
	
	public void proccessInput(FamilyTree tree) {
		this.command.execute(args, tree);
	}
}
