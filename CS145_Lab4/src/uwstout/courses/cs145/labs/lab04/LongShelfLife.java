package uwstout.courses.cs145.labs.lab04;

/**
 * 
 * @author SchultzRachel
 * @version 2022.11.02
 */
public class LongShelfLife extends Perishable {

	private static final int SHELF_LIFE = 720;

	/**
	 * 
	 * @param name
	 * @param shelfLife
	 * @param price
	 */
	public LongShelfLife(String name, double price) {
		super(name, price, SHELF_LIFE);
	}
}
