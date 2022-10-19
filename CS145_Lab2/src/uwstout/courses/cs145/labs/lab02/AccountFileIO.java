package uwstout.courses.cs145.labs.lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Loads a data file and produces an AccountList
 * 
 * 
 * This class will read data from a file and add it to an AccountList
 * 
 * @author SchultzRachel
 * @version 2022.10.6
 */
public class AccountFileIO {

	/**
	 * ParseFile reads in a string file
	 * 
	 * It takes the information from the file and puts it into an array to store
	 * 
	 * @param fileName takes in a file
	 * @return returns and account list object
	 * @throws FileNotFoundException if the file is not found
	 */
	public AccountList parseFile(String fileName) {
		// File variableName = new File(fileName);
		AccountList list = new AccountList();

		try {
			File variableName = new File(fileName);
			Scanner input = new Scanner(variableName);

			while (input.hasNextLine()) {
				String line = input.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(" ");

				// read a account # and balance
				//// Each line has the format: <account number> <balance>
				try {
					String accountN = lineScan.next();
					double balance = lineScan.nextDouble();
					lineScan.close();

					list.add(accountN, balance);

				} catch (Exception e) {
					// do nothing
				}
				lineScan.close();
			}
			input.close();

		} catch (NullPointerException e) {
			return null;

			// fail file was not found
		} catch (FileNotFoundException e) {
			return null;
		}
		// return the list
		return list;
	}
}
