package com.rakesh.geektrust.backend.meetfamily;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import com.rakesh.geektrust.backend.meetfamily.helpers.FamilyTree;
import com.rakesh.geektrust.backend.meetfamily.initializers.FamilyTreeInitializer;
import com.rakesh.geektrust.backend.meetfamily.utils.Input;
import com.rakesh.geektrust.backend.meetfamily.utils.InputSource;

/**
 * Hello world!
 *
 */
public class MeetTheFamily 
{
	private static InputSource inputSrc = new InputSource();
    public static void main( String[] args ) throws FileNotFoundException, IOException {
    	
        FamilyTree tree = FamilyTreeInitializer.intilize(); 
        if (args.length == 0) {
        	// TODO add custom exceptions
        	throw new RuntimeException("");
        }
        List<Input> inputData = inputSrc.getInput(args[0]);
        inputData.forEach((input) -> input.proccessInput(tree));

    }
}
