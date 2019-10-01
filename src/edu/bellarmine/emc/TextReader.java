package edu.bellarmine.emc;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class reads the file and puts its contents into ArrayLists.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 1
 * Fall 2019
 */

public class TextReader {
	
	private File file;//the file we need to read
	private Scanner fileReader;//reads through the file and grabs strings
	private ArrayList<String> strings, substrings;//ArrayLists to hold the contents of the file
	private int numberOfLines;//how many lines are in the file
	
	/**
	 * Empty-argument constructor - just instantiates things
	 */
	public TextReader() {
		
		strings = new ArrayList<String>();
		substrings = new ArrayList<String>();
		numberOfLines = 0;
		
	}// end empty-argument constructor
	
	/**
	 * Full-argument constructor - instantiates data and fills the ArrayLists with the contents of the file passed in.
	 * @param fileName - the name of the file containing the program's input
	 */
	public TextReader(String fileName) {
		
		strings = new ArrayList<String>();
		substrings = new ArrayList<String>();
		numberOfLines = 0;
		
		startReader(fileName);
		
		fillArrayLists();
		
	}// end full-argument constructor
	
	/**
	 * Returns the string stored in the given index of "strings"
	 * @param index - the index to grab from
	 * @return the string at "index"
	 */
	public String getString(int index) {
		return strings.get(index);
	}
	
	
	/**
	 * Returns the string stored in the given index of "substrings"
	 * @param index - the index to grab from
	 * @return the substring at "index"
	 */
	public String getSubstring(int index) {
		return substrings.get(index);
	}
	
	/**
	 * @return the numberOfLines
	 */
	public int getNumberOfLines() {
		return numberOfLines;
	}

	/**
	 * SUPPORT METHOD - sets up the scanner to read from the file passed in
	 * @param fileName - the name of the file the scanner will read from
	 */
	private void startReader(String fileName) {
		
		file = new File(fileName);
		
		try {
			fileReader = new Scanner(file);
			fileReader.useDelimiter("(,|\\p{javaWhitespace})+");
		}
		catch (Exception e) {
			System.out.println("Failed to read from file.\nFile may be corrupted.");
		}
		
	}// end "startReader" support method
	
	/**
	 * SUPPORT METHOD - fills the ArrayLists with the contents of the file
	 */
	private void fillArrayLists() {
		
		while(fileReader.hasNextLine()) {
			
			substrings.add(fileReader.next().toLowerCase());
			strings.add(fileReader.next().toLowerCase());
			
			numberOfLines++;
			
		}
		
	}// end "fillArrayLists" support method
	
}// end "TextReader" class
