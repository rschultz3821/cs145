package uwstout.courses.cs145.classexamples;

import java.util.Scanner;

/**
 * Creates a fraction calculator.
 * 
 * Creates a calculator that can perform
 * basic operations on fractions.
 * 
 * @author turners
 * @version 2022-09-08
 */
public class FractionProgram {

	
	/**
	 * Loads the fraction calculator.
	 * 
	 * Loads the fraction calculator.
	 * 
	 * @param args Command line arguments - not used
	 */
	public static void main(String[] args) {
		int num;
		int denom;
		Fraction fracA;
		Fraction fracB;
		Fraction result;
		
		Scanner scan;
		scan = new Scanner(System.in);
		
		// get two fractions (num and denom)
		System.out.println("Enter the first faction (with a space"
				+ " between the numbers):");
		num = scan.nextInt();
		denom = scan.nextInt();
		fracA = new Fraction(num, denom);
		
		System.out.println("Enter the second faction (with a space"
				+ " between the numbers):");
		num = scan.nextInt();
		denom = scan.nextInt();
		fracB = new Fraction(num, denom);
		
		// multiply them
		result = fracA.multiply(fracB);
		
		// print the results
		// n/d
		System.out.println(result);
		result = fracA.add(fracB);
		System.out.println(result);
		
		scan.close();
		
//		return myVar;
//		
//		if (myVar) {
//			return false;
//		}
//		else {
//			return true;
//		}
		
		
		
		
	}
	
}
