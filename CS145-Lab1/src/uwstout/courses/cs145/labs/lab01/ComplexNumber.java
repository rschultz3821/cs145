package uwstout.courses.cs145.labs.lab01;

import java.text.DecimalFormat;

/**
 * Calculations with two complex numbers
 * 
 * conjugates, adds, subtracts, multiples, and divides complex numbers
 * 
 * @author ScultzRachel
 * @version 2022.9.21
 */

public class ComplexNumber {

	// variables
	/**
	 * variable for real number
	 */
	private double real;
	/**
	 * variable for imaginary number
	 */
	private double imagine;

	// constructors
	/**
	 * Creates a new complex number
	 * 
	 * Creates a new complex number
	 * 
	 * @param realN    is the real number
	 * @param imagineN is the imaginary number
	 */
	public ComplexNumber(double realN, double imagineN) {
		real = realN;
		imagine = imagineN;
	}

	/**
	 * Creates a complex real number
	 * 
	 * @param realN is the real number
	 */
	public ComplexNumber(double realN) {
		real = realN;
		imagine = 0;
	}

	// copy constructor
	/**
	 * Copy constructor
	 * 
	 * Copies the complex number
	 * 
	 * @param b is the new complex number
	 */
	public ComplexNumber(ComplexNumber b) {
		real = b.getReal();
		imagine = b.imagine;
	}

	// default constructor
	/**
	 * Default constructor
	 * 
	 * Sets real and imaginary numbers to zero
	 */
	public ComplexNumber() {
		real = 0;
		imagine = 0;
	}

	// methods
	/**
	 * Gets the real number
	 * 
	 * @return the real number
	 */
	public double getReal() {
		return real;
	}

	/**
	 * Gets the imaginary number
	 * 
	 * @return the imaginary number
	 */
	public double getImaginary() {
		return imagine;
	}

	// setters
	/**
	 * Sets the real number
	 * 
	 * @param realN equals real variable
	 */
	public void setReal(double realN) {
		real = realN;
	}

	/**
	 * Sets the imaginary number
	 * 
	 * @param imagineN equals imagine variable
	 */
	public void setImaginary(double imagineN) {
		imagine = imagineN;
	}

	// method
	/**
	 * Formats the complex number
	 * 
	 * String that formats the complex number to 3 decimal places using
	 * DecimalFormat
	 * 
	 * @return <real> + <imaginary>i formatted up to 3 decimals
	 */
	public String toString() {

		// formats to 3 decimal places
		DecimalFormat df = new DecimalFormat("#.###");

		return df.format(real) + " + " + df.format(imagine) + "i";
	}

	/**
	 * Conjugates a complex number
	 * 
	 * Keeps the real number the same and negates the imagine number
	 * 
	 * @return returns the conjugate
	 */
	public ComplexNumber conjugate() {

		ComplexNumber object = new ComplexNumber();

		object.setReal(real);
		object.setImaginary(-imagine);
		return object;
	}

	/**
	 * Adds two complex numbers
	 * 
	 * Adds both real numbers to get the new real number then adds both imagine
	 * numbers to get the new imagine number
	 * 
	 * @param b Second complex number inputed
	 * @return returns the added object
	 */
	public ComplexNumber add(ComplexNumber b) {

		ComplexNumber object = new ComplexNumber();

		object.real = (real + b.real);
		object.imagine = (imagine + b.imagine);

		return object;
	}

	/**
	 * Subtracts two complex numbers
	 * 
	 * Subtracts both real numbers to get the new real number Subtracts both imagine
	 * numbers to get the new imagine number
	 * 
	 * @param b Second complex number inputed
	 * @return returns the added object
	 */
	public ComplexNumber subtract(ComplexNumber b) {

		ComplexNumber object = new ComplexNumber();

		// subtracting real parts of both complex numbers
		object.real = (real - b.real);

		// subtracting imaginary parts
		object.imagine = (imagine - b.imagine);

		// returning result
		return object;
	}

	/**
	 * Multiplies two complex numbers
	 * 
	 * Finds the real number then the imaginary number
	 * 
	 * @param b Second complex number inputed
	 * @return returns the multiplied object
	 */
	public ComplexNumber multiply(ComplexNumber b) {

		ComplexNumber object = new ComplexNumber();

		// (a1)(a2)-(b1)(b2) multiplying real number
		object.real = (real * b.real) - (imagine * b.imagine);

		// (a1)(b2)+(b1)(a2) multiplying imaginary number
		object.imagine = (real * b.imagine) + (b.real * imagine);

		// returning result
		return object;
	}

	/**
	 * Divided two complex number
	 * 
	 * Finds the real number then the imaginary number
	 * 
	 * @param b Second complex number inputed
	 * @return returns the divided object
	 */

	public ComplexNumber divide(ComplexNumber b) {

		ComplexNumber object = new ComplexNumber();

		// dividing real number
		object.real = ((real * b.real) + (imagine * b.imagine)) / (((Math.pow(b.real, 2)) + (Math.pow(b.imagine, 2))));

		// dividing imaginary number
		object.imagine = ((b.real * imagine) - (real * b.imagine)) / ((Math.pow(b.real, 2)) + (Math.pow(b.imagine, 2)));

		// returning result
		return object;
	}
}
