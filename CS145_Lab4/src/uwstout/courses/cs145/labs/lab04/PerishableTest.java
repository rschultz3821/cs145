package uwstout.courses.cs145.labs.lab04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class PerishableTest {

	/**
	 * 
	 */
	@Test
	public void testShelfLife() {
		Perishable p = new Perishable("bread", 6, 14);
		assertEquals("bread", p.getName());
		assertEquals(14, p.getShelfLife());
		assertEquals(6, p.getPrice(), 0.0001);
	}

	/**
	 * 
	 */
	@Test
	public void testGetDiscountedPrice() {
		Perishable p = new Perishable("bread", 10, 14);
		assertEquals(9, p.getDiscountedPrice(15), 0.0001);

		Perishable p2 = new Perishable("bread", 10, 14);
		assertEquals(10, p2.getDiscountedPrice(14), 0.0001);
	}
}
