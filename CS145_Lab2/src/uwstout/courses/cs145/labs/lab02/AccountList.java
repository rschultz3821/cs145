package uwstout.courses.cs145.labs.lab02;

/**
 * This class stores information about accounts
 * 
 * This class will store multiple AccountBalance objects and be able to perform
 * some calculations on them.
 * 
 * @author SchultzRachel
 * @version 2022.10.6
 *
 */

public class AccountList {
	/**
	 * Creates an array for AccountBalance
	 * Creates an int count
	 */
	private AccountBalance[] accounts;
	private int count;

	/**
	 * Constructor that creates a new account list
	 * 
	 * The list is size 3 and the count is zero
	 */
	public AccountList() {
		accounts = new AccountBalance[3];
		count = 0;
	}

	/**
	 * Gets the size
	 * 
	 * Gets the size of the array 
	 * 
	 * @return returns the number of objects in the array
	 */
	public int getSize() {
		return count;
	}

	/**
	 * Gets the account
	 * 
	 * Checks the position and makes sure the parameter is valid if it is not it was
	 * throw an IllegalArgumentException
	 * 
	 * @param pos position in the array
	 * @return AccountBalance object
	 * @throw Throws IllegalArgumentException if the Parameter is not valid
	 */
	public AccountBalance getAccount(int pos) {
		if (pos >= 0 && pos < count) {
			return accounts[pos];
		}
		// If the parameter is not valid, throw an IllegalArgumentException
		throw new IllegalArgumentException("Parameter is not valid.");
	}

	/**
	 * This method makes the array bigger
	 * 
	 * The array grows by a constant of 2 if needed and if the account number is
	 * invalid it will throw an IllegalArgumentException
	 * 
	 * @param accountN it takes in the account number
	 * @param balance  it takes in the balance
	 * @throw Throws IllegalArgumentException if the Parameter is not valid
	 */
	public void add(String accountN, double balance) {
		if (count == accounts.length) {
			AccountBalance[] bigger = new AccountBalance[accounts.length + 2];
			// copy data over
			for (int i = 0; i < accounts.length; i++) {
				bigger[i] = accounts[i];
			}
			// update accounts
			accounts = bigger;
		}
		// making a copy
		accounts[count] = new AccountBalance(accountN, balance);
		count++;
	}

	/**
	 * Gets the total
	 * 
	 * Loop over all of the AccountBalances in the array 
	 * and return the sum of the balances
	 * 
	 * @return the sum of the balances
	 */
	public double getTotal() {
		double sum = 0;
		for (int i = 0; i < count; i++) {
			sum = sum + accounts[i].getAmount();
		}
		return sum;
	}

	/**
	 * Gets the refund total
	 * 
	 * Loop over all of the AccountBalances in the array. If a refund needs to be
	 * given (since the balance is -25.00 or less), then add the balance to the sum
	 * 
	 * @return returns the sum
	 */
	public double getRefundTotal() {
		// Loop over all of the AccountBalances in the array.
		// If a refund needs to be given (since the balance is -25.00 or less),
		// then add the balance to the sum.
		double sum = 0;
		for (int i = 0; i < count; i++) {
			if (accounts[i].needsRefund() == true) {
				sum = sum + accounts[i].getAmount();
			}
		}
		return sum;
	}

	/**
	 * Finds the balance
	 * 
	 * Loop over all of the AccountBalances in the array. If one of the account
	 * numbers equals the parameter, return that AccountBalance If parameter matches
	 * none of the account numbers, return null
	 * 
	 * @param id takes in a new account number string
	 * @return returns AccountBalance if the account numbers equal, otherwise it
	 *         returns null
	 */
	public AccountBalance findBalance(String id) {
		// account id (String) as a parameter
		// loop over all of the AccountBalances in the array.
		// If one of the account numbers equals the parameter, return that
		// AccountBalance.
		// (Be careful how you compare the Strings.)
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNumber() == id) {
				return accounts[i];
			}
		}
		return null;
	}

}
