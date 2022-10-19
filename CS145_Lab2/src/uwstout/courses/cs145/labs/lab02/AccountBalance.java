package uwstout.courses.cs145.labs.lab02;

/**
 * Associates an account number and the balance on the account.
 * 
 * It also provides information about whether the account is due a refund or not
 * 
 * @author SchultzRachel
 * @version 2022.10.6
 * 
 */

public class AccountBalance {

	// variables
	private String accountN;
	private double balance;

	/**
	 * Constructor for Account Balance
	 * 
	 * Creates an account balance taking in two parameters
	 * 
	 * @param nAccountN copies accountn
	 * @param nBalance  copies balance
	 */
	public AccountBalance(String nAccountN, double nBalance) {
		accountN = nAccountN;
		balance = nBalance;
		// If the account number is null
		// or if the account number is not exactly 8 characters in length,
		// the constructor should throw an IllegalArgumentException

		if (accountN == null || accountN.length() != 8) {
			throw new IllegalArgumentException("Parameter is not valid.");
		}
	}

	/**
	 * Getter for account number
	 * 
	 * gets the account number
	 * 
	 * @return returns account number
	 */
	public String getAccountNumber() {
		return accountN;
	}

	/**
	 * Getter for balance
	 * 
	 * gets the balance
	 * 
	 * @return returns balance
	 */
	public double getAmount() {
		return balance;
	}

	/**
	 * boolean to see if refund is needed
	 * 
	 * Returns true if the account balance is -25.00 or less else it returns false
	 * 
	 * @return returns true or false
	 */
	public boolean needsRefund() {
		// return true if the account’s balance is -25.00 or less.
		// Otherwise, return false.
		return balance <= -25.00;
	}
}
