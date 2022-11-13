package uwstout.courses.cs145.inheritance.normal;

// -------------------------------------------------------------------------
/**
 *  Represents a Dachshund
 *
 *  @author  turners	
 *  @version Nov 12, 2016
 */
public class Dachshund {
	private String name;
	private int badgersFound;

	
	// ----------------------------------------------------------
	/**
	 * Creates a Dachshund
	 * 
	 * @param name Name of the dog
	 * @param badgers Number of badgers found
	 */
	public Dachshund(String name, int badgers) {
		this.name = name;
		badgersFound = badgers;
	}

	
	// ----------------------------------------------------------
	/**
	 * Gets the dog's name
	 * @return Dog's name
	 */
	public String getName() {
		return name;
	}

	// ----------------------------------------------------------
	/**
	 * Has the dog bark
	 * @return Bark for the dog.
	 */
	public String bark() {
		return "woof";
	}

	@Override
	public String toString() {
		return getName() + " says " + bark();
	}

	// ----------------------------------------------------------
	/**
	 * Digs
	 */
	public void burrow() {
		/* burrow into things */
	}

	// ----------------------------------------------------------
	/**
	 * Gets the number of badgers found.
	 * @return badgers found
	 */
	public int getBadgersFound() {
		return badgersFound;
	}
}
