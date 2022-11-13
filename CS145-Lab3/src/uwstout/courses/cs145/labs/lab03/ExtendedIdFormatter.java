package uwstout.courses.cs145.labs.lab03;

/**
 * Class for ExtendedIdFormatter
 * 
 * Class for ExtemdedIdFormatter that implements IdFormatter. Takes in a
 * username, if the username is null or less 8 characters long it will throw an
 * exception. If not, it returns the correct format.
 * 
 * @author SchultzRachel
 * @version 2022.10.26
 */
public class ExtendedIdFormatter implements IdFormatter {
	private String mPrefix;
	private String mUsername;
	private String mGroup;
	private int mId;

	/**
	 * Method for ExtendedIdFormatter
	 * 
	 * Takes in parameters and sets them
	 * 
	 * @param prefix takes in the type of value
	 * @param group  takes in the group
	 * @param id     takes in the id
	 * @throws Exception throws exception if group is null of less than 1
	 */
	public ExtendedIdFormatter(String prefix, String group, int id) throws IllegalArgumentException {
		if (group == null || group.length() < 1) {
			throw new IllegalArgumentException("Group have a list of 1.");
		}
		this.mPrefix = prefix;
		this.mUsername = null;
		this.mGroup = group;
		this.mId = id;
	}

	/**
	 * Method for createId
	 * 
	 * Takes in a username. If the username is null or less 8 characters long it
	 * will throw an exception. If not, it returns the correct format.
	 */
	@Override
	public String createId(String username) {
		if (username == null || username.length() < 8) {
			throw new IllegalArgumentException("The username must be at least 8 character long.");
		}
		this.mUsername = username.substring(0, username.length());
		return String.format("%s-%s%d[%s]", this.mPrefix, this.mUsername, this.mId, this.mGroup);
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
		return this.mGroup;
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
