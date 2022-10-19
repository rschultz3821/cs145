package uwstout.courses.cs145.labs.lab02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests Account Balance
 * 
 * Tests GetAccountNumber,GetAmount, and NeedsRefund
 * 
 * @author SchultzRachel
 * @version 2022.10.6
 */
public class AccountBalanceTest {

	private AccountBalance b1;

	/**
	 * Sets up a variable AccountBalance
	 * 
	 * Sets up an AccountBalance for me to use later
	 * 
	 * @throws Exception IllegalArgumentException
	 */
	@Before
	public void setUp() throws Exception {
		b1 = new AccountBalance("ABC-1234", 56.70);
	}

	/**
	 * Tests getAccountNumber
	 * 
	 * Takes in an AccountBalance and returns the string account number
	 */
	@Test
	public void testGetAccountNumber() {
		AccountBalance b8 = new AccountBalance("ABC-1234", -8.4);
		assertEquals("ABC-1234", "ABC-1234", b8.getAccountNumber());

		AccountBalance b2 = new AccountBalance("DEG-8534", 110.10);
		assertEquals("DEG-8534", "DEG-8534", b2.getAccountNumber());

		AccountBalance b3 = new AccountBalance("BRS-3777", 10.10);
		assertEquals("BRS-3777", "BRS-3777", b3.getAccountNumber());

		AccountBalance b4 = new AccountBalance("MLI-6484", 69.55);
		assertEquals("MLI-6484", "MLI-6484", b4.getAccountNumber());

		AccountBalance b5 = new AccountBalance("UTC-7515", -25.00);
		assertEquals("UTC-7515", "UTC-7515", b5.getAccountNumber());

		AccountBalance b6 = new AccountBalance("QEX-1987", 100.75);
		assertEquals("QEX-1987", "QEX-1987", b6.getAccountNumber());

		AccountBalance b7 = new AccountBalance("TEF-3844", -6.75);
		assertEquals("TEF-3844", "TEF-3844", b7.getAccountNumber());
	}

	/**
	 * Testing getAccountBalance IllegalArgumentException 
	 * 
	 * Tests when the string is ""
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAccountBalanceException1() {
		assertEquals("ABC-1234", b1.getAccountNumber());
		AccountBalance b10 = new AccountBalance("", 74.23);
		assertEquals("", b10.getAccountNumber());
	}

	/**
	 * Testing getAccountBalance IllegalArgumentException 
	 * 
	 * Tests when the string is too big
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAccountBalanceException2() {
		assertEquals("ABC-1234", b1.getAccountNumber());
		AccountBalance b11 = new AccountBalance("ABC-123648", 74.23);
		assertEquals("ABC-123648", b11.getAccountNumber());
	}

	/**
	 * Testing getAccountBalance IllegalArgumentException 
	 * 
	 * Tests when the string is too small
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAccountBalanceException3() {
		assertEquals("ABC-1234", b1.getAccountNumber());
		AccountBalance b13 = new AccountBalance("AB8", 74.23);
		assertEquals("AB8", b13.getAccountNumber());
	}

	/**
	 * Testing getAccountBalance IllegalArgumentException 
	 * 
	 * Tests when the string is null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAccountBalanceException4() {
		assertEquals("ABC-1234", b1.getAccountNumber());
		AccountBalance b14 = new AccountBalance(null, 74.23);
		assertEquals(null, b14.getAccountNumber());
	}

	/**
	 * Tests getAmount 
	 * 
	 * Returns the balance
	 */
	@Test
	public void testGetAmount() {
		AccountBalance b11 = new AccountBalance("ABC-1234", -8.4);
		assertEquals(-8.4, -8.4, b11.getAmount());

		AccountBalance b2 = new AccountBalance("DEG-8534", 110.10);
		assertEquals(110.10, 110.10, b2.getAmount());

		AccountBalance b3 = new AccountBalance("BRS-3777", 10.10);
		assertEquals(10.10, 10.10, b3.getAmount());

		AccountBalance b4 = new AccountBalance("MLI-6484", 69.55);
		assertEquals(69.55, 69.55, b4.getAmount());

		AccountBalance b5 = new AccountBalance("UTC-7515", -25.00);
		assertEquals(-25.00, -25.00, b5.getAmount());

		AccountBalance b6 = new AccountBalance("QEX-1987", 100.75);
		assertEquals(100.75, 100.75, b6.getAmount());

		AccountBalance b7 = new AccountBalance("TEF-3844", -6.75);
		assertEquals(-6.75, -6.75, b7.getAmount());
	}

	/**
	 * Tests needsRefund
	 * 
	 * Returns true if balance is less then or equal to -25 
	 * Returns false if balance is greater then -25
	 */
	@Test
	public void testNeedsRefund() {
		AccountBalance b11 = new AccountBalance("ABC-1234", -8.4);
		assertEquals("Testing -8.4 false", false, b11.needsRefund());

		AccountBalance b2 = new AccountBalance("ABC-1234", -25.00);
		assertEquals("Testing -25.00 true", true, b2.needsRefund());

		AccountBalance b3 = new AccountBalance("ABC-1234", -30.00);
		assertEquals("Testing -30.00 true", true, b3.needsRefund());

		AccountBalance b4 = new AccountBalance("ABC-1234", 1.00);
		assertEquals("Testing 1.00 false", false, b4.needsRefund());
	}

}
