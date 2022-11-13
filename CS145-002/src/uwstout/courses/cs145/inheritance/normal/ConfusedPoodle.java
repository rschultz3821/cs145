package uwstout.courses.cs145.inheritance.normal;

import java.util.*;

//-------------------------------------------------------------------------
/**
*  Represents a confused poodle
*
*  @author  turners	
*  @version Nov 12, 2016
*/
public class ConfusedPoodle {
	private String name;
	private int haircutType;

	// ----------------------------------------------------------
	/**
	 * Creates a confused Poodle
	 * @param name Dog's name
	 * @param haircut Type of haircut
	 */
	public ConfusedPoodle(String name, int haircut) {
		this.name = name;
		haircutType = haircut;
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
	 * 
	 * @return Bark for the dog.
	 */
	public String bark() {
		Random rand = new Random();
		int confused = rand.nextInt(5);
		if (confused == 0)
			return "huh?";
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
		 * @return The type of haircut
		 */
		public int getHaircut() {
		return haircutType;
	}
}
