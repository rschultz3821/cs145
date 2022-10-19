package uwstout.courses.cs145.classexamples;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorHistoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculatorHistory() {
		CalculatorHistory hist = new CalculatorHistory();
		assertEquals(0, hist.getHistoryCount());
	}

	@Test
	public void testAddFraction() {
		CalculatorHistory hist = new CalculatorHistory();
		hist.addFraction(new Fraction(2, 3));

		assertEquals(1, hist.getHistoryCount());
		assertEquals("2/3", hist.getFraction(0).toString());

		hist.addFraction(new Fraction(9, 8));

		assertEquals(2, hist.getHistoryCount());
		assertEquals("2/3", hist.getFraction(0).toString());
		assertEquals("9/8", hist.getFraction(1).toString());
		
	}

	@Test
	public void testAddFractoinMany() {
		// add 8 fractions
		CalculatorHistory hist = new CalculatorHistory();

		for (int i = 0; i < 14; i++) {
			hist.addFraction(new Fraction(1 + i, 2 + i));

			assertEquals(i + 1, hist.getHistoryCount());
			assertEquals((i + 1) + "/" + (i + 2), hist.getFraction(i).toString());
		}

		for (int i = 0; i < 14; i++) {
			assertEquals((i + 1) + "/" + (i + 2), hist.getFraction(i).toString());

		}
	}

	@Test
	public void testGetHistoryCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFraction() {
		//if pos is invalid I should get nall
	}

	@Test
	public void testRemoveFraction() {
		//if pos is invalid I should get nall
		//count go down
		//everything shift 
	}

	@Test
	public void testClear() {
		//test if return zero
	}

	@Test
	public void testFindFraction() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		// 4/5 \n 3/7 \n 1/2 \n
		}

}
