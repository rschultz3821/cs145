package uwstout.courses.cs145.inheritance.improved;

// -------------------------------------------------------------------------
/**
 * Base class for all dogs.
 *
 * @author Schnook
 * @version Nov 12, 2016
 */
public class Dog {

	/**
	 * Name of the dog
	 */
	protected String name;

	// ----------------------------------------------------------
	/**
	 * Creates a dog
	 * 
	 * @param name
	 *            Dog's name
	 */
	public Dog(String name) {
		this.name = name;
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
		return "bark";
	}

	@Override
	public String toString() {
		return getName() + " says " + bark();
	}
}
