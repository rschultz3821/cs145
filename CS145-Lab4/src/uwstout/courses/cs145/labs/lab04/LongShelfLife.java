package uwstout.courses.cs145.labs.lab04;

/**
 * Class for LongShelfLife
 * 
 * LongShelfLife inherits from Perishable. This class is like Perishable but
 * instead the shelf life will always be 720 days.
 * 
 * @author SchultzRachel
 * @version 2022.11.02
 */
public class LongShelfLife extends Perishable {

	private static final int SHELF_LIFE = 720;

	/**
	 * Constructor for LongShelfLife
	 * 
	 * Takes in a name and price and set them. The shelf life is a constant set to
	 * 720 days.
	 * 
	 * @param name  takes in a name from the parent class
	 * @param price takes in a price from the parent class
	 */
	public LongShelfLife(String name, double price) {
		super(name, price, SHELF_LIFE);
	}
}
