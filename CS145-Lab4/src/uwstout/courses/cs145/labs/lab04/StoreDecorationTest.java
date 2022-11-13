package uwstout.courses.cs145.labs.lab04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for StoreDecoration
 * 
 * Tests StoreDecoration class
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class StoreDecorationTest {

	/**
	 * Test for StoreDecoration
	 * 
	 * Tests getName, getHoliday, and getPrice. Tests when name is null. Tests when
	 * holiday is null
	 */
	@Test
	public void testStoreDecoration() {
		StoreDecoration sd = new StoreDecoration("Grumpy Elves", "Christmas");
		assertEquals("Grumpy Elves*", sd.getName());
		assertEquals("Christmas", sd.getHoliday());
		assertEquals(0, sd.getPrice(), 0.0001);

		StoreDecoration sd2 = new StoreDecoration(null, "Christmas");
		assertEquals(null + "*", sd2.getName());
		assertEquals("Christmas", sd2.getHoliday());
		assertEquals(0, sd2.getPrice(), 0.0001);

		StoreDecoration sd3 = new StoreDecoration("Grumpy Elves", null);
		assertEquals("Grumpy Elves*", sd3.getName());
		assertEquals(null, sd3.getHoliday());
		assertEquals(0, sd3.getPrice(), 0.0001);
	}

}
