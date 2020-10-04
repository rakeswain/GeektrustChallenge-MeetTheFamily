package com.rakesh.geektrust.backend.meetfamily.helpers;

import java.util.List;

public interface Command {
 
	public void execute(List<String> args, FamilyTree tree);
}
