package com.rakesh.geektrust.backend.meetfamily.constants;

import com.rakesh.geektrust.backend.meetfamily.helpers.AddChildCommand;
import com.rakesh.geektrust.backend.meetfamily.helpers.Command;
import com.rakesh.geektrust.backend.meetfamily.helpers.GetRelationshipCommand;

/**
 * Description - This is a enum class that represents Command options. 
 * The class is responsible for injecting Command instance.
 * 
 * @author Rakesh Swain
 * @version 0.0.1
 **/
public enum Option {

	ADD_CHILD {

		@Override
		public Command getCommand() {
			return new AddChildCommand();
		}
		
	},
	GET_RELATIONSHIP {

		@Override
		public Command getCommand() {
			return new GetRelationshipCommand();
		}
		
	};
	
	public abstract Command getCommand();
	
}
