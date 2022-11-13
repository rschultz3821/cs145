package uwstout.courses.cs145.labs.lab03;

/**
 * Class for BasicIdFormatter
 * 
 * Class for BasicIdFormatt3er that implements IdFormatter. Takes in a username,
 * if the username is null or less 3 characters long it will throw an exception.
 * If not, it returns the correct format.
 * 
 * @author SchultzRachel
 * @version 2022.10.26
 */
public class BasicIdFormatter implements IdFormatter {
	private String mPrefix;
	private String mUsername;
	private int mId;

	/**
	 * Method for BasicIdFormatter
	 * 
	 * Takes in parameters and sets them.
	 * 
	 * @param prefix takes in the type of value
	 * @param id     takes in the id
	 */
	public BasicIdFormatter(String prefix, int id) {
		this.mPrefix = prefix;
		this.mUsername = null;
		this.mId = id;
	}

	/**
	 * Method for createId
	 * 
	 * Takes in a username. If the username is null or less 3 characters long it
	 * will throw an exception. If not, it returns the correct format.
	 */

	@Override
	public String createId(String username) {
		if (username == null || username.length() < 3) {
			throw new IllegalArgumentException("The username must be at least 3 character long.");
		}
		this.mUsername = username.substring(0, 3);
		return String.format("%s-%s-USER-%d", this.mPrefix, this.mUsername, this.mId);
	}

	/**
	 * Getter for the prefix
	 * 
	 * gets the prefix
	 */
	@Override
	public String getPrefix() {
		return this.mPrefix;
	}

	/**
	 * Getter for the group
	 * 
	 * gets the group
	 */
	@Override
	public String getGroup() {
		return "USER";
	}

	/**
	 * Getter for the id
	 * 
	 * gets the id
	 */
	@Override
	public int getId() {
		return this.mId;
	}
}
