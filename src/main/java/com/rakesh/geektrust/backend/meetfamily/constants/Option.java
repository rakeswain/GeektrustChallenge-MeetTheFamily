package com.rakesh.geektrust.backend.meetfamily.constants;

import com.rakesh.geektrust.backend.meetfamily.helpers.AddChildCommand;
import com.rakesh.geektrust.backend.meetfamily.helpers.Command;
import com.rakesh.geektrust.backend.meetfamily.helpers.GetRelationshipCommand;

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
