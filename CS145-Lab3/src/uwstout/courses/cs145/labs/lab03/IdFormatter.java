package uwstout.courses.cs145.labs.lab03;

/**
 * Interface for all classes that format id Strings
 * 
 * No code exists here, it is just the interface for IdFormatter.
 * 
 * @author SchultzRachel
 * @version 2022.10.26
 *
 */
public interface IdFormatter {

	/**
	 * Enforces a String createId to be made
	 * 
	 * Enforces a new id string for the username to be created
	 * 
	 * @param username takes in a username
	 * @return returns a format
	 */
	String createId(String username);

	/**
	 * Enforces a getPrefix to be made
	 * 
	 * Enforces a getPrefix to be made
	 * 
	 * @return returns a prefix
	 */
	String getPrefix();

	/**
	 * Enforces a getGroup to be made
	 * 
	 * Enforces a getGroup to be made
	 * 
	 * @return returns a group
	 */
	String getGroup();

	/**
	 * Enforces a getId to be made
	 * 
	 * Enforces a getId to be made
	 * 
	 * @return returns an id number starting at 1000
	 */
	int getId();

}
