package uwstout.courses.cs145.inheritance.improved;

//-------------------------------------------------------------------------
/**
 * Represents a Poodle
 *
 * @author turners
 * @version Nov 12, 2016
 */
public class Poodle2 extends Dog {
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
	public Poodle2(String name, int haircut) {
		super(name);
		haircutType = haircut;
	}

	// ----------------------------------------------------------
	/**
	 * Has the dog bark
	 * 
	 * @return Bark for the dog.
	 */
	@Override
	public String bark() {
		return "yip";
	}

	// ----------------------------------------------------------
	/**
	 * Gets something
	 */
	public void retrieve() {
		// find something and bring it back
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
