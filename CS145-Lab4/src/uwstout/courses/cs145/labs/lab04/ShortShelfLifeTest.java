package uwstout.courses.cs145.labs.lab04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class for ShortShelfLife
 * 
 * Tests ShortShelfLife class
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class ShortShelfLifeTest {

	/**
	 * Tests getDiscountedPrice
	 * 
	 * If the product is sellable it returns a discounted price. If the product is
	 * not sellable the price will be zero.
	 */
	@Test
	public void testGetDiscountedPrice() {
		ShortShelfLife ss = new ShortShelfLife("bread", 10, 10);
		assertEquals(9, ss.getDiscountedPrice(11), 0.0001);
		assertEquals(0, ss.getDiscountedPrice(13), 0.0001);
	}

	/**
	 * Tests constructor ShortShelfLife
	 * 
	 * Tests getName, getShelfLife, and getPrice
	 */
	@Test
	public void testShortShelfLife() {
		ShortShelfLife ss = new ShortShelfLife("bread", 6, 14);
		assertEquals("bread", ss.getName());
		assertEquals(14, ss.getShelfLife());
		assertEquals(6, ss.getPrice(), 0.0001);
	}

	/**
	 * Tests isSellable
	 * 
	 * Determines true if the product is still sellable. If it is it will return
	 * true, if it is not it will return false.
	 */
	@Test
	public void testIsSellable() {
		ShortShelfLife ss = new ShortShelfLife("bread", 6, 10);
		assertEquals(true, ss.isSellable(11));
		assertEquals(false, ss.isSellable(13));

		ShortShelfLife ss2 = new ShortShelfLife("bread", 6, 100);
		assertEquals(true, ss2.isSellable(11));
		assertEquals(false, ss2.isSellable(125));
	}

}
