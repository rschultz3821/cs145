package uwstout.courses.cs145.inheritance.best;

//-------------------------------------------------------------------------
/**
 * Abstract base class for all dogs.
 *
 * @author Schnook
 * @version Nov 12, 2016
 */
abstract public class AbstractDog {

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
	public AbstractDog(String name) {
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
	abstract public String bark();

	@Override
	public String toString() {
		return getName() + " says " + bark();
	}

}
