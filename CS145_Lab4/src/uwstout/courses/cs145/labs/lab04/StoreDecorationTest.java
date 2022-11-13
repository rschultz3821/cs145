package uwstout.courses.cs145.labs.lab04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class StoreDecorationTest {

	/**
	 * 
	 */
	@Test
	public void testStoreDecoration() {
		StoreDecoration name = new StoreDecoration("Grumpy Elves", "Christmas");
		assertEquals("Grumpy Elves*", name.getName());
		assertEquals("Christmas", name.getHoliday());
		assertEquals(0, name.getPrice(), 0.0001);

		StoreDecoration name2 = new StoreDecoration(null, "Christmas");
		assertEquals(null + "*", name2.getName());
		assertEquals("Christmas", name2.getHoliday());
		assertEquals(0, name2.getPrice(), 0.0001);

		StoreDecoration name3 = new StoreDecoration("Grumpy Elves", null);
		assertEquals("Grumpy Elves*", name3.getName());
		assertEquals(null, name3.getHoliday());
		assertEquals(0, name3.getPrice(), 0.0001);
	}

}
