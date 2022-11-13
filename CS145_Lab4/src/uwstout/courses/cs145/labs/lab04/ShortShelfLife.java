package uwstout.courses.cs145.labs.lab04;

/**
 * Class for ShortShelfLife
 * 
 * Inherits Perishable...
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class ShortShelfLife extends Perishable {

	/**
	 * 
	 * @param name
	 * @param shelfLife
	 * @param price
	 */
	public ShortShelfLife(String name, double price, int shelfLife) {
		super(name, price, shelfLife);
	}

	/**
	 * 
	 * @param nDaysOnShelf
	 * @return
	 */
	public boolean isSellable(int nDaysOnShelf) {
		return nDaysOnShelf < 1.25 * mShelfLife;
	}

	/**
	 * 
	 */
	public double getDiscountedPrice(int nDaysOnShelf) {
		if (isSellable(nDaysOnShelf)) {
			return super.getDiscountedPrice(nDaysOnShelf);
		}
		return 0;
	}

}
