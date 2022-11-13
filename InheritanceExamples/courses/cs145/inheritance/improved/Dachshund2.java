package uwstout.courses.cs145.inheritance.improved;

//-------------------------------------------------------------------------
/**
 * Represents a Dachshund
 *
 * @author turners
 * @version Nov 12, 2016
 */
public class Dachshund2 extends Dog {
	private int badgersFound;

	// ----------------------------------------------------------
	/**
	 * Creates a Dachshund
	 * 
	 * @param name
	 *            Name of the dog
	 * @param badgers
	 *            Number of badgers found
	 */
	public Dachshund2(String name, int badgers) {
		super(name);
		badgersFound = badgers;
	}

	// ----------------------------------------------------------
	/**
	 * Has the dog bark
	 * 
	 * @return Bark for the dog.
	 */
	@Override
	public String bark() {
		return "woof";
	}

	// ----------------------------------------------------------
	/**
	 * Digs
	 */
	public void burrow() {
		/* burrow into things */ }

	// ----------------------------------------------------------
	/**
	 * Gets the number of badgers found.
	 * 
	 * @return badgers found
	 */
	public int getBadgersFound() {
		return badgersFound;
	}
}
