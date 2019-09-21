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
		
		Scanner input = new Scanner(System.in);
		
		String goAgain;
		boolean end = false;
		while (!(end)) {
			
			//here
			
			System.out.print("Would you like to enter more sequences? (Yes/No): ");
			goAgain = input.nextLine();
			if (goAgain.toLowerCase().charAt(0) == 'y') {
				
			}
			else {
				end = true;
			}
			
		}
		
		System.out.println("<END RUN>");
		
		input.close();
	}// end main

}// end class
