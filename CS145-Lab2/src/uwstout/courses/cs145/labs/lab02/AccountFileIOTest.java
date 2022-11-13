package uwstout.courses.cs145.labs.lab02;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * Tests AccountFileIO 
 * 
 * Tests different inputs and with throw exceptions if needed
 * 
 * @author SchultzRachel
 * @version 2022.10.6
 */
public class AccountFileIOTest {

	/**
	 * Tests AccountFileIO
	 * 
	 * Inputs test1.txt and with throw IllegalArgymentException if needed
	 * 
	 * @throws FileNotFoundException if the file is not found it will throw FileNotFountException
	 */
	@Test
	public void testParseFile() {

		AccountFileIO input = new AccountFileIO();
		AccountList list = input.parseFile("valid.txt");

		assertEquals(list.getSize(), 5);
		assertEquals(list.getAccount(0).getAccountNumber(), "DHH-2180");
		assertEquals(list.getAccount(0).getAmount(), 110.25, 0.01);

		assertEquals("TOB-6851", "TOB-6851", list.getAccount(1).getAccountNumber());
		assertEquals(list.getAccount(1).getAmount(), -258.45, 0.01);

		assertEquals("JNO-1438", "JNO-1438", list.getAccount(2).getAccountNumber());
		assertEquals(list.getAccount(2).getAmount(), 375.95, 0.01);

		assertEquals("IPO-5410", "IPO-5410", list.getAccount(3).getAccountNumber());
		assertEquals(list.getAccount(3).getAmount(), 834.15, 0.01);

		assertEquals("PWV-5792", "PWV-5792", list.getAccount(4).getAccountNumber());
		assertEquals(list.getAccount(4).getAmount(), 793.00, 0.01);
	}

	/**
	 * Tests AccountFileIO
	 * 
	 * Inputs a file not found and should return null
	 * 
	 * @throws FileNotFoundException if the file is not found it will throw FileNotFountException
	 */
	@Test
	public void testParseFile2() throws FileNotFoundException {

		AccountFileIO input = new AccountFileIO();
		AccountList nullList = input.parseFile("wrong.text");
		assertNull(nullList);
	}

	/**
	 * Tests AccountFileIO
	 * 
	 * Inputs a null and should return null
	 * 
	 * @throws FileNotFoundException if the file is not found it will throw FileNotFountException
	 */
	@Test
	public void testParseFile3() throws FileNotFoundException {

		// try {
		AccountFileIO input = new AccountFileIO();
		AccountList nullList = input.parseFile(null);
		assertNull(nullList);

	}

}