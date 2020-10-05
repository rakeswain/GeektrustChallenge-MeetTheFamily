package com.rakesh.geektrust.backend.meetfamily;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.rakesh.geektrust.backend.meetfamily.constants.ErrorMessage;
import com.rakesh.geektrust.backend.meetfamily.exceptions.InvalidInputException;
import com.rakesh.geektrust.backend.meetfamily.helpers.FamilyTree;
import com.rakesh.geektrust.backend.meetfamily.initializers.FamilyTreeInitializer;
import com.rakesh.geektrust.backend.meetfamily.utils.Input;
import com.rakesh.geektrust.backend.meetfamily.utils.InputSource;

/**
 * Description - This is the main class. It uses the InputSource to read the input and Input class to process inputs.
 * 
 * @author Rakesh Swian
 * @version 0.0.1
 */
public class MeetTheFamily 
{
	private static InputSource inputSrc = new InputSource();
    public static void main( String[] args ) throws FileNotFoundException, IOException {
    	
        FamilyTree tree = FamilyTreeInitializer.init(); 
        if (args.length == 0) {
        	throw new InvalidInputException(ErrorMessage.PATH_NOT_GIVEN);
        }
        List<Input> inputData = inputSrc.getInput(args[0]);
        inputData.forEach((input) -> input.proccessInput(tree));
    }
}
