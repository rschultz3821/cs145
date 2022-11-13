package uwstout.courses.cs145.labs.lab04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for Perishable class
 * 
 * Tests constructor and methods from Perishable class
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class PerishableTest {

	/**
	 * Tests constructor
	 * 
	 * Tests getName, getShelfLife, getPrice
	 */
	@Test
	public void testShelfLife() {
		Perishable p = new Perishable("bread", 6, 14);
		assertEquals("bread", p.getName());
		assertEquals(14, p.getShelfLife());
		assertEquals(6, p.getPrice(), 0.0001);
	}

	/**
	 * Test method getDiscountedPrice
	 * 
	 * Returns discounted price if needed otherwise returns the full price
	 */
	@Test
	public void testGetDiscountedPrice() {
		Perishable p = new Perishable("bread", 10, 14);
		assertEquals(9, p.getDiscountedPrice(15), 0.0001);

		Perishable p2 = new Perishable("bread", 10, 14);
		assertEquals(10, p2.getDiscountedPrice(14), 0.0001);
	}
}
