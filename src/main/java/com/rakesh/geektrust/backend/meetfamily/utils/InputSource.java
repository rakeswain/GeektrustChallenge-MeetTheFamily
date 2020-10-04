package com.rakesh.geektrust.backend.meetfamily.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rakesh.geektrust.backend.meetfamily.constants.Option;

/**
 * DESCRIPTION - This class is responsible for reading input.
 * 
 * @author Rakesh Swain
 * @version 0.0.1
 */

public class InputSource {
	
	/**
	 * This method is responsible for reading input from file and mapping them to List of Input objects. 
	 * 
	 * @param uri - Path of the input file
	 * @return List of Input objects
	 */
	public List<Input> getInput(String uri) throws FileNotFoundException, IOException {
		List<Input> inputPairs = new ArrayList<Input>();		
		try(FileReader reader = new FileReader(uri)) {
			BufferedReader br = new BufferedReader(reader);
			String s;
			while((s = br.readLine()) != null) {
				List<String> inputLine = Arrays. asList(s.split(" "));
				inputPairs.add(new Input(inputLine.subList(1, inputLine.size()), Option.valueOf(inputLine.get(0))
														  .getCommand()));
			}
		}
		return inputPairs;
	}
	

}

