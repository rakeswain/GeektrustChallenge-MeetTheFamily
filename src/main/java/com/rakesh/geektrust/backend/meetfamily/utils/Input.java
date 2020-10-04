package com.rakesh.geektrust.backend.meetfamily.utils;

import java.util.List;

import com.rakesh.geektrust.backend.meetfamily.helpers.Command;
import com.rakesh.geektrust.backend.meetfamily.helpers.FamilyTree;

public class Input {

	private List<String> args;
	private Command command;
	
	public Input(List<String> args, Command command) {
		this.args = args;
		this.command = command;
	}
	
	public void proccessInput(FamilyTree tree) {
		this.command.execute(args, tree);
	}
}
