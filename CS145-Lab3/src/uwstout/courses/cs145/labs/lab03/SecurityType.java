package uwstout.courses.cs145.labs.lab03;

/**
 * SecurityType is an enum
 * 
 * EXECUTIVE, MANAGER, and PEON are the values of the enum. It returns the
 * correct prefix and tells IdGenerator if the value needs the extended Id.
 * 
 * @author SchultzRachel
 * @version 2022.10.26
 *
 */
public enum SecurityType {

	/**
	 * Values for the SecurityType
	 * 
	 * Either EXECUTIVE, MANAGER or PEON
	 */
	EXECUTIVE, MANAGER, PEON;

//	private String idPrefix;
//	private boolean extendedId;
//
//	private SecurityType() {
//		// TODO Auto-generated constructor stub
//	}
//
//	private SecurityType(String prefix, boolean extended) {
//		prefix = idPrefix;
//		extended = extendedId;
//	}

	/**
	 * Switch case for getPrefix
	 * 
	 * Returns the right string based on the value inputed.
	 * 
	 * @return the string for the value
	 */
	public String getPrefix() {
		switch (this) {

		case EXECUTIVE:
			return "CEO";
		case MANAGER:
			return "PHB";
		default:
			return "ZZZ";
		}
	}

	/**
	 * Switch case for needsExtendedId
	 * 
	 * Returns the right boolean based on the value inputed. The boolean determines
	 * if the value needs an extended username or not.
	 * 
	 * @return the boolean for the value
	 */
	public boolean needsExtendedId() {
		switch (this) {

		case EXECUTIVE:
			return true;
		case MANAGER:
			return false;
		default:
			return false;
		}
	}
}
