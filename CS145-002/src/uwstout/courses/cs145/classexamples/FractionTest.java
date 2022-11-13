package uwstout.courses.cs145.classexamples;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Fraction class.
 * 
 * @author turners
 * @version 1.0
 */
public class FractionTest {

	private static final double DELTA = 0.000001;

	private Fraction f1;


	@Before
	public void setUp() throws Exception {
		f1 = new Fraction(4, 5);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests the constructor with 2 ints
	 */
	@Test
	public void testFractionIntInt() {
		// create an object
		// test its values by calling methods
		assertEquals("Testing 4/5", 4, f1.getNumerator());
		assertEquals("Testing 4/5", 5, f1.getDenominator());


		Fraction f2 = new Fraction(4, 8);
		assertEquals("Testing 4/8", 1, f2.getNumerator());
		assertEquals("Testing 4/8", 2, f2.getDenominator());


		// improper fraction
		Fraction f3 = new Fraction(8, 1);
		assertEquals("Testing 8/1", 8, f3.getNumerator());
		assertEquals("Testing 8/1", 1, f3.getDenominator());

		Fraction f4 = new Fraction(19, 7);
		assertEquals("Testing 19/7", 19, f4.getNumerator());
		assertEquals("Testing 19/7", 7, f4.getDenominator());

		// denom = 0
		// num = 0
		// both 0?

		// max/min integers?

		// reduce?
	}

	@Test
	public void testFractionIntIntZero() {
		// denom = 0
		// num = 0
		// both 0?

		Fraction f1 = new Fraction(0, 2);
		assertEquals("Testing 0/2", 0, f1.getNumerator());
		assertEquals("Testing 0/2", 1, f1.getDenominator());


		try {
			f1 = new Fraction(3, 0);
			fail("x/0 did not throw an exception.");
		}
		catch (IllegalArgumentException e) {
			// test passes
		}
		catch (Exception e) {
			fail("x/0 threw wrong exception");
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFractionIntIntZero2() {
		// denom = 0
		// num = 0
		// both 0?

		Fraction f1 = new Fraction(0, 2);
		assertEquals("Testing 0/2", 0, f1.getNumerator());
		assertEquals("Testing 0/2", 1, f1.getDenominator());

		f1 = new Fraction(0, 0);
	}



	@Test
	public void testFractionIntIntNegative() {
		// negatives?
		// -1/2
		// -3/-5
		// 8/-11
		Fraction f1 = new Fraction(-1, 2);
		assertEquals("Testing -1/2", -1, f1.getNumerator());
		assertEquals("Testing -1/2", 2, f1.getDenominator());
		//assertTrue("Testing -1/2", -1 == f1.getNumerator());


		Fraction f2 = new Fraction(-3, -5);
		assertEquals("Testing -3/-5", 3, f2.getNumerator());
		assertEquals("Testing -3/-5", 5, f2.getDenominator());


		// improper fraction
		Fraction f3 = new Fraction(8, -11);
		assertEquals("Testing 8/-11", -8, f3.getNumerator());
		assertEquals("Testing 8/-11", 11, f3.getDenominator());
	}


	@Test
	public void testToString() {
		assertEquals("Testing 4/5", "4/5", f1.toString());
	}

	@Test
	public void testNegate() {
		assertEquals("Negating 4/5", "-4/5", f1.negate().toString());
	}

	@Test
	public void testToDecimal() {
		assertEquals("4/5 -> 0.8", 0.8, f1.toDecimal(), DELTA);
	}





	@Test
	public void testFraction() {
		fail("Not yet implemented");
	}

	@Test
	public void testFractionFraction() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFraction() {
		fail("Not yet implemented");
	}

}
