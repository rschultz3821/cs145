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
	 * 
	 */
	@Test
	public void testGetDiscountedPrice() {
		ShortShelfLife ss = new ShortShelfLife("bread", 10, 10);
		assertEquals(9, ss.getDiscountedPrice(11), 0.0001);
		assertEquals(0, ss.getDiscountedPrice(13), 0.0001);
	}

	/**
	 * 
	 */
	@Test
	public void testShortShelfLife() {
		ShortShelfLife ss = new ShortShelfLife("bread", 6, 14);
		assertEquals("bread", ss.getName());
		assertEquals(14, ss.getShelfLife());
		assertEquals(6, ss.getPrice(), 0.0001);
	}

	/**
	 * 
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
