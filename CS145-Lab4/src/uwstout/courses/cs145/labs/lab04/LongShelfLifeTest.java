package uwstout.courses.cs145.labs.lab04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for LongShelfLife
 * 
 * Tests constructor and methods from LongShelfLife
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class LongShelfLifeTest {

	/**
	 * Tests constructor
	 * 
	 * Tests getName, getShelfLife and getPrice. The shelfLife with always be 720
	 * days.
	 */
	@Test
	public void testLongShelfLife() {
		LongShelfLife ls = new LongShelfLife("spam", 6);
		assertEquals("spam", ls.getName());
		assertEquals(720, ls.getShelfLife());
		assertEquals(6, ls.getPrice(), 0.0001);
	}

	/**
	 * Tests getDiscountedPrice
	 * 
	 * LongShelfLife inherits getDiscountedPrice. Tests to make sure it is working
	 * correctly.
	 */
	@Test
	public void testGetDiscountedPrice() {
		LongShelfLife ss = new LongShelfLife("spam", 10);
		assertEquals(10, ss.getDiscountedPrice(720), 0.0001);
		assertEquals(9, ss.getDiscountedPrice(730), 0.0001);
	}

}
