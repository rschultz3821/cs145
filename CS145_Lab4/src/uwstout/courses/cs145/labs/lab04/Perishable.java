package uwstout.courses.cs145.labs.lab04;

/**
 * Class for Perishable
 * 
 * Inherits Product and
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class Perishable extends Product {

	protected int mShelfLife;
	protected double mPrice;

	/**
	 * 
	 * @param name
	 * @param shelfLife
	 * @param price
	 */
	public Perishable(String name, double price, int shelfLife) {
		super(name);
		mShelfLife = shelfLife;
		mPrice = price;
	}

	/**
	 * 
	 */
	public double getPrice() {
		return mPrice;
	}

	/**
	 * 
	 * @return
	 */
	public int getShelfLife() {
		return mShelfLife;
	}

	/**
	 * 
	 * @param nDaysOnShelf
	 * @return
	 */
	public double getDiscountedPrice(int nDaysOnShelf) {
		if (nDaysOnShelf > mShelfLife) {
			return mPrice * 0.9;
		}
		return mPrice;
	}
}
