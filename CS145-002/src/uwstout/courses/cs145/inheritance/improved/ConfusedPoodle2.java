package uwstout.courses.cs145.inheritance.improved;

import java.util.*;




//-------------------------------------------------------------------------
/**
 * Represents a confused poodle
 *
 * @author turners
 * @version Nov 12, 2016
 */
public class ConfusedPoodle2 extends Poodle2 {

	// ----------------------------------------------------------
	/**
	 * Creates a confused Poodle
	 * 
	 * @param name
	 *            Dog's name
	 * @param haircut
	 *            Type of haircut
	 */
	public ConfusedPoodle2(String name, int haircut) {
		super(name, haircut);
	}

	// ----------------------------------------------------------
	/**
	 * Has the dog bark
	 * 
	 * @return Bark for the dog.
	 */
	@Override
	public String bark() {
		Random rand = new Random();
		int confused = rand.nextInt(5);
		if (confused == 0) {
			return "huh?";
		}

		return super.bark();
	}

}
