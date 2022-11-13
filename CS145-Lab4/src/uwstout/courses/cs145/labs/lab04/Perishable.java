package uwstout.courses.cs145.labs.lab04;

/**
 * Class for Perishable
 * 
 * Inherits Product and stores the number of days for the item on the shelf and
 * the price.
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class Perishable extends Product {

	/**
	 * Protected int mShelLife
	 * 
	 * Protected int mShelLife
	 */
	protected int mShelfLife;

	/**
	 * Protected double mPrice
	 * 
	 * Protected double mPrice
	 */
	protected double mPrice;

	/**
	 * Constructor Perishable
	 * 
	 * Takes in a name, price, and shelf life and sets them
	 * 
	 * @param name      takes in a name
	 * @param shelfLife takes in a shelfLife
	 * @param price     takes in a price
	 */
	public Perishable(String name, double price, int shelfLife) {
		super(name);
		mShelfLife = shelfLife;
		mPrice = price;
	}

	/**
	 * Method getPrice
	 * 
	 * Gets the price
	 * 
	 * @return price
	 */
	public double getPrice() {
		return mPrice;
	}

	/**
	 * Method getShelfLife
	 * 
	 * Gets the shelf life
	 * 
	 * @return shelfLife
	 */
	public int getShelfLife() {
		return mShelfLife;
	}

	/**
	 * Method getDiscountedPrice
	 * 
	 * If the number of days on the shelf is longer than the shelf life, the price
	 * will get discounted. If not, the price will stay the same.
	 * 
	 * @param nDaysOnShelf taking in number of days on shelf
	 * @return returning price either in full or discounted
	 */
	public double getDiscountedPrice(int nDaysOnShelf) {
		if (nDaysOnShelf > mShelfLife) {
			return mPrice * 0.9;
		}
		return mPrice;
	}
}
