package uwstout.courses.cs145.inheritance.normal;

//-------------------------------------------------------------------------
/**
 * Represents a Poodle
 *
 * @author turners
 * @version Nov 12, 2016
 */
public class Poodle {
	private String name;
	private int haircutType;

	// ----------------------------------------------------------
	/**
	 * Creates a Poodle
	 * 
	 * @param name
	 *            Dog's name
	 * @param haircut
	 *            Type of haircut
	 */
	public Poodle(String name, int haircut) {
		this.name = name;
		haircutType = haircut;
	}

	// ----------------------------------------------------------
	/**
	 * Gets the dog's name
	 * 
	 * @return Dog's name
	 */
	public String getName() {
		return name;
	}

	// ----------------------------------------------------------
	/**
	 * Has the dog bark
	 * 
	 * @return Bark for the dog.
	 */
	public String bark() {
		return "yip";
	}

	@Override
	public String toString() {
		return getName() + " says " + bark();
	}

	// ----------------------------------------------------------
	/**
	 * Gets something
	 */
	public void retrieve() {
		/* find something and bring it back */
	}

	// ----------------------------------------------------------
	/**
	 * Gets the haircut
	 * 
	 * @return The type of haircut
	 */
	public int getHaircut() {
		return haircutType;
	}
}
