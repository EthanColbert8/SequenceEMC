package edu.bellarmine.emc;

import java.util.Scanner;

/**
 * This class executes the program.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 1
 * Fall 2019
 */

public class Application {

	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Stack<Character> charStack = new Stack<Character>();//a stack to store the substring characters in
		String string, substring;//stores the two strings we need to work with
		Scanner input = new Scanner(System.in);//for input
		boolean isSubstring = false, manual = true;//whether or not "substring" is a substring of "string"
		TextReader reader;//a TextReader to grab strings from a file
		
		/* This loop insures that we get valid input for the choice of whether to
		 * enter strings manually or via a file (if input is invalid, the user is prompted again). */
		boolean gotValid = false;
		do {
			
			System.out.print("Would you like to enter sequences manually or from a file? (M or F): ");
			String mORf = input.nextLine().toLowerCase();
			
			if (mORf.charAt(0) == 'm') {
				manual = true;
				gotValid = true;
			}
			else if (mORf.charAt(0) == 'f') {
				manual = false;
				gotValid = true;
			}
			
		} while(!(gotValid));
		
		if (manual == true) {
			
			String goAgain;//whether the user wishes to enter another set of strings or not
			boolean end = false;
			do {
				
				System.out.println();//gives us a blank line
				
				System.out.print("Enter the subsequence to search for: ");
				substring = input.nextLine().toLowerCase();
				System.out.print("Enter the string to search through: ");
				string = input.nextLine().toLowerCase();
				
				System.out.println();//gives us a blank line
				
				/* This loop pushes all the characters of the substring to the stack
				 * in REVERSE order */
				for (int i = 1; i <= substring.length(); i++) {
					charStack.push(substring.charAt((substring.length() - i)));
				}
				
				for (int j = 0; j < string.length(); j++) {
					
					/* If we find the character at the top of the stack (the next character in the substring) in "string",
					 * we pop it off the stack. */
					if (string.charAt(j) == charStack.peek()) {
						charStack.pop();
					}
					
					/* If the stack is empty, it means the substring is indeed a subsequence of "string". */
					if (charStack.isEmpty()) {
						
						isSubstring = true;
						
						j = string.length();//ends the loop
						
					}
					
				}
				
				if (isSubstring) {
					System.out.println(substring + " IS A SUBSEQUENCE of " + string);
				}
				else {
					System.out.println(substring + " IS NOT A SUBSEQUENCE of " + string);
				}
				
				charStack.clear();
				isSubstring = false;
				
				System.out.println();//gives us a blank line
				
				System.out.print("Would you like to enter more sequences? (Yes or No): ");
				goAgain = input.nextLine();
				if (goAgain.toLowerCase().charAt(0) != 'y') {
					end = true;
				}
			} while(!(end));
		
		}
		
		else {
			
			System.out.print("Enter the name of the file: ");
			String fileName = input.nextLine();
			reader = new TextReader(fileName);
			
			System.out.println();//gives us a blank line
			
			for (int i = 0; i < reader.getNumberOfLines(); i++) {
				
				substring = reader.getSubstring(i);
				string = reader.getString(i);
				
				/* This loop pushes all the characters of the substring to the stack
				 * in REVERSE order */
				for (int k = 1; k <= substring.length(); k++) {
					charStack.push(substring.charAt((substring.length() - k)));
				}
				
				for (int j = 0; j < string.length(); j++) {
					
					/* If we find the character at the top of the stack (the next character in the substring) in "string",
					 * we pop it off the stack. */
					if (string.charAt(j) == charStack.peek()) {
						charStack.pop();
					}
					
					/* If the stack is empty, it means the substring is indeed a subsequence of "string". */
					if (charStack.isEmpty()) {
						
						isSubstring = true;
						
						j = string.length();//ends the loop
						
					}
					
				}
				
				if (isSubstring) {
					System.out.println(substring + " IS A SUBSEQUENCE of " + string);
				}
				else {
					System.out.println(substring + " IS NOT A SUBSEQUENCE of " + string);
				}
				
				charStack.clear();
				isSubstring = false;
				
			}
			
		}
		
		System.out.println("\n<END RUN>");
		
		input.close();
	}// end main

}// end class
