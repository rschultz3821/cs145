package uwstout.courses.cs145.labs.lab02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * AccountListTests tests the AccountList
 * 
 * Tests all my things from AccountList
 * 
 * @author SchultzRachel
 * @version 2022.10.6
 *
 */
public class AccountListTest {

	private AccountBalance b1;
	private AccountBalance b2;

	private static final AccountBalance[] VALUES = { new AccountBalance("ABC-1234", 56.70),
			new AccountBalance("DEG-8534", 110.10), new AccountBalance("BRS-3777", 10.10),
			new AccountBalance("MLI-6484", 69.55), new AccountBalance("UTC-7515", -25.00),
			new AccountBalance("QEX-1987", 100.75), new AccountBalance("TEF-3844", -6.75),
			new AccountBalance("OUH-9765", 9.10), new AccountBalance("TEF-3548", 451.65),
			new AccountBalance("POG-7557", -50.15) };
	private static final double DELTA = 0.0001;

	/**
	 * Sets up the throws Exception
	 * 
	 * Creates AccountBalance variables for me to use later
	 */
	@Before
	public void setUp() throws Exception {
		b1 = new AccountBalance("ABC-1234", 56.70);
		b2 = new AccountBalance("DEG-8534", 110.10);

	}

	/**
	 * Test for add
	 * 
	 * Adds the AccountBalance object to the first open position in the array 
	 * and increment the number of objects in the array.
	 */
	@Test
	public void testAdd() {
		AccountList list = new AccountList();
		// fill list with data
		for (int i = 0; i < VALUES.length; i++) {
			list.add(VALUES[i].getAccountNumber(), VALUES[i].getAmount());
		}
		// check if the list was built correctly
		assertEquals(VALUES.length, list.getSize());
		for (int i = 0; i < list.getSize(); i++) {
			assertEquals(VALUES[i].getAccountNumber(), list.getAccount(i).getAccountNumber());
			assertEquals(VALUES[i].getAmount(), list.getAccount(i).getAmount(), DELTA);
		}
	}

	/**
	 * Tests getSize 
	 * 
	 * Getter Checks to see if the getSize is actually zero
	 */
	@Test
	public void testGetSize() {
		AccountList accounts = new AccountList();
		assertEquals(0, accounts.getSize());
	}

	/**
	 * Tests array position
	 * 
	 * Testing outside the lower bound
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetAccountExceptions1() {
		AccountList list = new AccountList();

		for (int i = 0; i < VALUES.length; i++) {
			list.add(VALUES[i].getAccountNumber(), VALUES[i].getAmount());
		}
		// Check if the list was built right.
		assertEquals(VALUES.length, list.getSize());

		assertEquals(b1.getAccountNumber(), list.getAccount(0).getAccountNumber());
		assertEquals(null, list.getAccount(-1).getAccountNumber());
	}

	/**
	 * Tests array position
	 * 
	 * Testing outside the upper bound
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetAccountExceptions2() {
		AccountList list = new AccountList();

		for (int i = 0; i < VALUES.length; i++) {
			list.add(VALUES[i].getAccountNumber(), VALUES[i].getAmount());
		}
		// Check if the list was built right.
		assertEquals(VALUES.length, list.getSize());

		assertEquals(b2.getAccountNumber(), list.getAccount(1).getAccountNumber());
		assertEquals(null, list.getAccount(100).getAccountNumber());
	}

	/**
	 * Test getTotal 
	 * 
	 * Returns the total of all the balances
	 */
	@Test
	public void testGetTotal() {
		// fill list with data
		AccountList list = new AccountList();

		for (int i = 0; i < VALUES.length; i++) {
			list.add(VALUES[i].getAccountNumber(), VALUES[i].getAmount());
		}
		// check if the list was built correctly
		assertEquals(639.05, 639.05, list.getTotal());
	}

	/**
	 * Tests getRefundTotal
	 * 
	 * Returns the the refunds if the balance is less than -25.00
	 */
	@Test
	public void testGetRefundTotal() {
		AccountList list = new AccountList();

		for (int i = 0; i < VALUES.length; i++) {
			list.add(VALUES[i].getAccountNumber(), VALUES[i].getAmount());
		}
		// check if the list was built correctly
		assertEquals(-50.15, -50.15, list.getRefundTotal());
	}

	/**
	 * Tests FindBalance 
	 * 
	 * Checks if one of the account numbers equals the parameter
	 * if so it returns that AccountBalance if not it returns null
	 */
	@Test
	public void testFindBalance() {
		// AccountList list = new AccountList();
		AccountList list = new AccountList();

		for (int i = 0; i < VALUES.length; i++) {
			list.add(VALUES[i].getAccountNumber(), VALUES[i].getAmount());
		}
		// check if the list was built correctly
		assertEquals(VALUES.length, list.getSize());
		for (int i = 0; i < VALUES.length; i++) {
			assertEquals(VALUES[i].getAccountNumber(),
					list.findBalance(VALUES[i].getAccountNumber()).getAccountNumber());
		}
		assertEquals(null, list.findBalance("MMM-2634"));
	}

}
