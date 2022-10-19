package uwstout.courses.cs145.classexamples;

import java.util.Scanner;

/**
 * Creates a fraction calculator.
 * 
 * Creates a calculator that can perform 
 * basic operations on fractions. 
 * 
 * @author SchultzRachel
 * @version 2022-09-08
 */

public class FractionProgram {

	
	/**
	 * Loads the fraction calculator.
	 * 
	 * Loads the fractions calculator.
	 * 	
	 * @param args Command line arguments - not used
	 */
	public static void main(String[] args) {
		int numA;
		int numB;
		int denomA;
		int denomB;
		int numR;
		int denomR;
		
		Scanner scan;
		scan = new Scanner(System.in);
		
		//get two fractions (num and denom)
		System.out.println("Enter the first fraction (with a space"
				+ " between the numbers):");
		numA = scan.nextInt();
		denomA = scan.nextInt();
		System.out.println("Enter the first fraction (with a space"
				+ " between the numbers):");
		numB = scan.nextInt();
		denomB = scan.nextInt();
		
		//multiply them
		numR = numA * numB;
		denomR = denomA * denomB;
		
		//print the results
		//n/d
		System.out.println(numR + "/" + denomR);
	}
	
	
}
