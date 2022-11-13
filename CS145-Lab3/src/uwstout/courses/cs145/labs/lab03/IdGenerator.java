package uwstout.courses.cs145.labs.lab03;

/**
 * Class for IdGenerator
 * 
 * Creates the correct username for the value (EXECUTIVE, MANAGER, PEON).
 * 
 * @author SchultzRachel
 * @version 2022.10.26
 */
public class IdGenerator {

	private static int lastId = 999;

	// constructor for IdGenerator
	// does nothing
	private IdGenerator() {
	}

	/**
	 * Method for IdFormatter that creates a username
	 * 
	 * Takes in a value (EXECUTIVE, MANAGER, PEON) and returns the correct format
	 * (either a basic format or extended format)
	 * 
	 * @param idType takes in a value type (EXECUTIVE, MANAGER, PEON)
	 * @param group  takes in a group (String created)
	 * @return returns the correct format based on the value type
	 */
	public static IdFormatter createFormatter(SecurityType idType, String group) {
		lastId++;
		if (idType.needsExtendedId() == true) {
			IdFormatter formatter = new ExtendedIdFormatter(idType.getPrefix(), group, lastId);
			return formatter;
		}
		IdFormatter formatter = new BasicIdFormatter(idType.getPrefix(), lastId);
		return formatter;
	}
}
