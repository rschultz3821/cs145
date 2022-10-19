package uwstout.courses.cs145.labs.lab01;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests ComplexNumber class
 * 
 * @author SchultzRachel
 * @version 2022.9.21
 */
public class ComplexNumberTest {

	/**
	 * Tests ComplexNumber constructor with parameter double realN
	 * 
	 * Takes in the real number and returns the real and then zero for imaginary
	 */
	@Test
	public void complexNumberDouble() {
		ComplexNumber n1 = new ComplexNumber(32.43);
		assertEquals("Testing 32.43", 32.43, n1.getReal(), .001);
		assertEquals("Testing 0", 0, n1.getImaginary(), .001);

		ComplexNumber n2 = new ComplexNumber(-3.2);
		assertEquals("Testing -3.2", -3.2, n2.getReal(), .001);
		assertEquals("Testing 0", 0, n2.getImaginary(), .001);

		ComplexNumber n3 = new ComplexNumber(0.0);
		assertEquals("Testing 0", 0, n3.getReal(), .001);
		assertEquals("Testing 0", 0, n3.getImaginary(), .001);
	}

	/**
	 * Tests getImaginary constructor
	 * 
	 * Takes a complex number and returns only the imaginary
	 */
	@Test
	public void getImaginary() {
		ComplexNumber n1 = new ComplexNumber(3.23, 9.43);
		assertEquals("Testing 9.43", 9.43, n1.getImaginary(), .001);

		ComplexNumber n2 = new ComplexNumber(-3.23, -9.43);
		assertEquals("Testing -9.43", -9.43, n2.getImaginary(), .001);

		ComplexNumber n3 = new ComplexNumber(-3.23, 0.0);
		assertEquals("Testing 0", 0, n3.getImaginary(), .001);
	}

	/**
	 * Tests copy constructor
	 * 
	 * n1 gets copied into the new complex number b
	 */
	@Test
	public void complexNumber() {
		ComplexNumber n1 = new ComplexNumber(2.321, 63.43);
		ComplexNumber b = new ComplexNumber(n1);
		assertEquals("Testing 2.321 + 63.43i", "2.321 + 63.43i", b.toString());

		ComplexNumber n2 = new ComplexNumber(-2.321, -63.43);
		ComplexNumber b1 = new ComplexNumber(n2);
		assertEquals("Testing -2.321 + -63.43i", "-2.321 + -63.43i", b1.toString());

		ComplexNumber n3 = new ComplexNumber(0.0, 0.0);
		ComplexNumber b2 = new ComplexNumber(n3);
		assertEquals("Testing 0 + 0i", "0 + 0i", b2.toString());
	}

	/**
	 * Tests the toString Method by taking in a complex number
	 * 
	 * decimals, 0 for real, 0 for imaginary, 0 for both, negatives
	 */
	@Test
	public void testToString() {
		ComplexNumber n1 = new ComplexNumber(4.123, 5.123);
		assertEquals("Testing 4.123 + 5.123i", "4.123 + 5.123i", n1.toString());

		ComplexNumber n2 = new ComplexNumber(0.0, 5.0);
		assertEquals("Testing 0 + 5i", "0 + 5i", n2.toString());

		ComplexNumber n3 = new ComplexNumber(4.0, 0.0);
		assertEquals("Testing 4 + 0i", "4 + 0i", n3.toString());

		ComplexNumber n4 = new ComplexNumber(0.0, 0.0);
		assertEquals("Testing 0 + 0i", "0 + 0i", n4.toString());

		ComplexNumber n5 = new ComplexNumber(-4.0, 5.0);
		assertEquals("Testing -4 + 5i", "-4 + 5i", n5.toString());

		ComplexNumber n6 = new ComplexNumber(4.0, -5.0);
		assertEquals("Testing 4 + -5i", "4 + -5i", n6.toString());
	}

	/**
	 * Tests conjugate method
	 * 
	 * Takes a complex number and only negates imaginary number
	 */
	@Test
	public void testConjugate() {
		ComplexNumber n1 = new ComplexNumber(4.123, 5.123);
		assertEquals("Testing 4.123 -5.123i", "4.123 + -5.123i", n1.conjugate().toString());

		ComplexNumber n2 = new ComplexNumber(-4.0, 5.0);
		assertEquals("Testing -4 + 5i", "-4 + -5i", n2.conjugate().toString());

		ComplexNumber n3 = new ComplexNumber(4.0, -5.0);
		assertEquals("Testing 4 -5i", "4 + 5i", n3.conjugate().toString());

		ComplexNumber n4 = new ComplexNumber(-7.483, 8.384);
		assertEquals("Testing -7.483 + 8.384i", "-7.483 + -8.384i", n4.conjugate().toString());

		ComplexNumber n5 = new ComplexNumber(18.463, -23.283);
		assertEquals("Testing 18.463 -23.283i", "18.463 + 23.283i", n5.conjugate().toString());

		ComplexNumber n6 = new ComplexNumber(0.0, 5.0);
		assertEquals("Testing 0 + -5i", "0 + -5i", n6.conjugate().toString());

		ComplexNumber n7 = new ComplexNumber(4.0, 0.0);
		assertEquals("Testing 4 + -0i", "4 + -0i", n7.conjugate().toString());

		ComplexNumber n8 = new ComplexNumber(0.0, 0.0);
		assertEquals("Testing 0 + -0i", "0 + -0i", n8.conjugate().toString());
	}

	/**
	 * Tests add method
	 * 
	 * Takes two complex numbers and adds them
	 */
	@Test
	public void testAdd() {
		ComplexNumber b = new ComplexNumber(4.0, 2.0);
		ComplexNumber n1 = new ComplexNumber(2.0, 3.0);
		assertEquals("Testing (4 + 2i) + (2 + 3i)", "6 + 5i", n1.add(b).toString());

		ComplexNumber b1 = new ComplexNumber(4.111, 2.111);
		ComplexNumber n2 = new ComplexNumber(2.111, 3.111);
		assertEquals("Testing (4.111 + 2.111i) + (2.111 + 3.111i)", "6.222 + 5.222i", n2.add(b1).toString());

		ComplexNumber b2 = new ComplexNumber(-3.23, 5.43);
		ComplexNumber n3 = new ComplexNumber(9.432, 45.3);
		assertEquals("Testing 6.202 + 50.73i", "6.202 + 50.73i", n3.add(b2).toString());

		ComplexNumber b3 = new ComplexNumber(-8.32, 34.42);
		ComplexNumber n4 = new ComplexNumber(-5.211, 3.13);
		assertEquals("Testing -13.531 + 37.55i", "-13.531 + 37.55i", n4.add(b3).toString());

		ComplexNumber b4 = new ComplexNumber(5.34, -43.23);
		ComplexNumber n5 = new ComplexNumber(2.832, 4.321);
		assertEquals("Testing 8.172 + -38.909", "8.172 + -38.909i", n5.add(b4).toString());

		ComplexNumber b5 = new ComplexNumber(3.543, 2.183);
		ComplexNumber n6 = new ComplexNumber(23.532, -3.3);
		assertEquals("Testing 27.075 + -1.117", "27.075 + -1.117i", n6.add(b5).toString());

		ComplexNumber b6 = new ComplexNumber(-83.543, -932.2);
		ComplexNumber n7 = new ComplexNumber(-9.432, -123.32);
		assertEquals("Testing -92.975 + -1055.52i", "-92.975 + -1055.52i", n7.add(b6).toString());

		ComplexNumber b7 = new ComplexNumber(8.32, -2.43);
		ComplexNumber n8 = new ComplexNumber(-1.1, 1.2);
		assertEquals("Testing 7.22 + -1.23i", "7.22 + -1.23i", n8.add(b7).toString());

		ComplexNumber b8 = new ComplexNumber(0.0, 3.212);
		ComplexNumber n9 = new ComplexNumber(0.0, 5.0);
		assertEquals("Testing 0 + 8.212i", "0 + 8.212i", n9.add(b8).toString());

		ComplexNumber b9 = new ComplexNumber(-8.321, 0.0);
		ComplexNumber n10 = new ComplexNumber(4.0, 0.0);
		assertEquals("Testing -4.321 + 0i", "-4.321 + 0i", n10.add(b9).toString());

		ComplexNumber b10 = new ComplexNumber(0.0, 0.0);
		ComplexNumber n11 = new ComplexNumber(0.0, 0.0);
		assertEquals("Testing 0 + 0i", "0 + 0i", n11.add(b10).toString());
	}

	/**
	 * Tests subtract method
	 * 
	 * Takes two complex numbers and subtracts them
	 */
	@Test
	public void testSubtract() {
		ComplexNumber b = new ComplexNumber(4.0, 3.0);
		ComplexNumber n1 = new ComplexNumber(2.0, 1.0);
		assertEquals("Testing (4.0 + 3.0i) - (2.0 + 1.0i)", "2 + 2i", b.subtract(n1).toString());

		ComplexNumber b1 = new ComplexNumber(4.123, 4.123);
		ComplexNumber n2 = new ComplexNumber(1.0, 2.0);
		assertEquals("Testing (4.123 + 4.123i) - (1.0 + 2.0i)", "3.123 + 2.123i", b1.subtract(n2).toString());

		ComplexNumber b2 = new ComplexNumber(-3.23, 5.43);
		ComplexNumber n3 = new ComplexNumber(9.432, 45.3);
		assertEquals("Testing 12.662 + 39.87i", "12.662 + 39.87i", n3.subtract(b2).toString());

		ComplexNumber b3 = new ComplexNumber(-8.32, 34.42);
		ComplexNumber n4 = new ComplexNumber(-5.211, 3.13);
		assertEquals("Testing 3.109 + -31.29i", "3.109 + -31.29i", n4.subtract(b3).toString());

		ComplexNumber b4 = new ComplexNumber(5.34, -43.23);
		ComplexNumber n5 = new ComplexNumber(2.832, 4.321);
		assertEquals("Testing -2.508 + 47.551", "-2.508 + 47.551i", n5.subtract(b4).toString());

		ComplexNumber b5 = new ComplexNumber(3.543, 2.183);
		ComplexNumber n6 = new ComplexNumber(23.532, -3.3);
		assertEquals("Testing 19.989 + -5.483", "19.989 + -5.483i", n6.subtract(b5).toString());

		ComplexNumber b6 = new ComplexNumber(-83.543, -932.2);
		ComplexNumber n7 = new ComplexNumber(-9.432, -123.32);
		assertEquals("Testing 74.111 + 808.88i", "74.111 + 808.88i", n7.subtract(b6).toString());

		ComplexNumber b7 = new ComplexNumber(8.32, -2.43);
		ComplexNumber n8 = new ComplexNumber(-1.1, 1.2);
		assertEquals("Testing -9.42 + 3.63i", "-9.42 + 3.63i", n8.subtract(b7).toString());

		ComplexNumber b8 = new ComplexNumber(0.0, 3.212);
		ComplexNumber n9 = new ComplexNumber(0.0, 5.0);
		assertEquals("Testing 0 + 8.212i", "0 + 1.788i", n9.subtract(b8).toString());

		ComplexNumber b9 = new ComplexNumber(-8.321, 0.0);
		ComplexNumber n10 = new ComplexNumber(4.0, 0.0);
		assertEquals("Testing 12.321 + 0i", "12.321 + 0i", n10.subtract(b9).toString());

		ComplexNumber b10 = new ComplexNumber(0.0, 0.0);
		ComplexNumber n11 = new ComplexNumber(0.0, 0.0);
		assertEquals("Testing 0 + 0i", "0 + 0i", n11.subtract(b10).toString());
	}

	/**
	 * Tests multiply method
	 * 
	 * Takes two complex numbers and multiplies them
	 */
	@Test
	public void testMultiply() {
		ComplexNumber b = new ComplexNumber(4.0, 3.0);
		ComplexNumber n1 = new ComplexNumber(2.0, 1.0);
		assertEquals("Testing (4.0 + 3.0i) * (2.0 + 1.0i)", "5 + 10i", b.multiply(n1).toString());

		ComplexNumber b1 = new ComplexNumber(1.0, 3.0);
		ComplexNumber n2 = new ComplexNumber(2.0, 1.0);
		assertEquals("Testing (1.0 + 3.0i) * (2.0 + 1.0i)", "-1 + 7i", b1.multiply(n2).toString());

		ComplexNumber b2 = new ComplexNumber(-3.23, 5.43);
		ComplexNumber n3 = new ComplexNumber(9.432, 45.3);
		assertEquals("Testing -276.44 + -95.103i", "-276.444 + -95.103i", n3.multiply(b2).toString());

		ComplexNumber b3 = new ComplexNumber(-8.32, 34.42);
		ComplexNumber n4 = new ComplexNumber(-5.211, 3.13);
		assertEquals("Testing -64.379 + -205.404i", "-64.379 + -205.404i", n4.multiply(b3).toString());

		ComplexNumber b4 = new ComplexNumber(5.34, -43.23);
		ComplexNumber n5 = new ComplexNumber(2.832, 4.321);
		assertEquals("Testing -202.92 + -99.353", "201.92 + -99.353i", n5.multiply(b4).toString());

		ComplexNumber b5 = new ComplexNumber(3.543, 2.183);
		ComplexNumber n6 = new ComplexNumber(23.532, -3.3);
		assertEquals("Testing 90.578 + 39.778", "90.578 + 39.678i", n6.multiply(b5).toString());

		ComplexNumber b6 = new ComplexNumber(-83.543, -932.2);
		ComplexNumber n7 = new ComplexNumber(-9.432, -123.32);
		assertEquals("Testing -114170.926 + 19095.033i", "-114170.926 + 19095.033i", n7.multiply(b6).toString());

		ComplexNumber b7 = new ComplexNumber(8.32, -2.43);
		ComplexNumber n8 = new ComplexNumber(-1.1, 1.2);
		assertEquals("Testing -6.236 + 12.657i", "-6.236 + 12.657i", n8.multiply(b7).toString());

		ComplexNumber b8 = new ComplexNumber(0.0, 3.212);
		ComplexNumber n9 = new ComplexNumber(0.0, 5.0);
		assertEquals("Testing -16.06 + 0i", "-16.06 + 0i", n9.multiply(b8).toString());

		ComplexNumber b9 = new ComplexNumber(-8.321, 0.0);
		ComplexNumber n10 = new ComplexNumber(4.0, 0.0);
		assertEquals("Testing -33.284 + 0i", "-33.284 + 0i", n10.multiply(b9).toString());

		ComplexNumber b10 = new ComplexNumber(0.0, 0.0);
		ComplexNumber n11 = new ComplexNumber(0.0, 0.0);
		assertEquals("Testing 0 + 0i", "0 + 0i", n11.multiply(b10).toString());
	}

	/**
	 * Tests divide method
	 * 
	 * Takes two complex numbers and divides them
	 */
	@Test
	public void testDivide() {
		ComplexNumber b = new ComplexNumber(4.0, 3.0);
		ComplexNumber n1 = new ComplexNumber(2.0, 1.0);
		assertEquals("Testing 2.2 + 0.4i", "2.2 + 0.4i", b.divide(n1).toString());

		ComplexNumber b1 = new ComplexNumber(1.0, 3.0);
		ComplexNumber n2 = new ComplexNumber(2.0, 1.0);
		assertEquals("Testing 1 + 1i", "1 + 1i", b1.divide(n2).toString());

		ComplexNumber b2 = new ComplexNumber(-3.23, 5.43);
		ComplexNumber n3 = new ComplexNumber(9.432, 45.3);
		assertEquals("Testing 5.399 + -4.949i", "5.399 + -4.949i", n3.divide(b2).toString());

		ComplexNumber b3 = new ComplexNumber(-8.32, 34.42);
		ComplexNumber n4 = new ComplexNumber(-5.211, 3.13);
		assertEquals("Testing 0.12 + 0.122i", "0.12 + 0.122i", n4.divide(b3).toString());

		ComplexNumber b4 = new ComplexNumber(5.34, -43.23);
		ComplexNumber n5 = new ComplexNumber(2.832, 4.321);
		assertEquals("Testing -0.09 + 0.077", "-0.09 + 0.077i", n5.divide(b4).toString());

		ComplexNumber b5 = new ComplexNumber(3.543, 2.183);
		ComplexNumber n6 = new ComplexNumber(23.532, -3.3);
		assertEquals("Testing 4.398 + -3.641", "4.398 + -3.641i", n6.divide(b5).toString());

		ComplexNumber b6 = new ComplexNumber(-83.543, -932.2);
		ComplexNumber n7 = new ComplexNumber(-9.432, -123.32);
		assertEquals("Testing 0.132 + 0.002i", "0.132 + 0.002i", n7.divide(b6).toString());

		ComplexNumber b7 = new ComplexNumber(8.32, -2.43);
		ComplexNumber n8 = new ComplexNumber(-1.1, 1.2);
		assertEquals("Testing -0.161 + 0.097i", "-0.161 + 0.097i", n8.divide(b7).toString());

		ComplexNumber b8 = new ComplexNumber(0.0, 3.212);
		ComplexNumber n9 = new ComplexNumber(0.0, 5.0);
		assertEquals("Testing 1.557 + 0i", "1.557 + 0i", n9.divide(b8).toString());

		ComplexNumber b9 = new ComplexNumber(-8.321, 0.0);
		ComplexNumber n10 = new ComplexNumber(4.0, 0.0);
		assertEquals("Testing -0.481 + -0i", "-0.481 + -0i", n10.divide(b9).toString());

		// Should Throw exception
		ComplexNumber b10 = new ComplexNumber(0.0, 0.0);
		ComplexNumber n11 = new ComplexNumber(0.0, 0.0);
		assertEquals("Testing NaN + NaNi", "NaN + NaNi", n11.divide(b10).toString());
	}

}
