package uwstout.courses.cs145.labs.lab04;

/**
 * Class for ShortShelfLife
 * 
 * ShortShelfLife inherits from Perishable class. This class is like Perishable
 * but with some added functions like isSellable and an updated
 * getDiscountedPrice.
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class ShortShelfLife extends Perishable {

	/**
	 * Constructor for ShortShelfLife
	 * 
	 * Takes in a name, price, and shelfLife and sets them.
	 * 
	 * @param name      takes in a name from the parent class
	 * @param price     takes in a price from the parent class
	 * @param shelfLife takes in a shelfLife from the parent class
	 */
	public ShortShelfLife(String name, double price, int shelfLife) {
		super(name, price, shelfLife);
	}

	/**
	 * Method isSellable
	 * 
	 * Determines true if the product is still sellable
	 * 
	 * @param nDaysOnShelf takes in the number of days on the shelf
	 * @return true or false
	 */
	public boolean isSellable(int nDaysOnShelf) {
		return nDaysOnShelf < 1.25 * mShelfLife;
	}

	/**
	 * Method getDiscountedPrice
	 * 
	 * If the product is sellable it returns a discounted price. If the product is
	 * not sellable the price will be zero.
	 * 
	 * @param nDaysOnShelf takes in the number of days on the shelf
	 * @return returns either discountedPrice or zero
	 */
	public double getDiscountedPrice(int nDaysOnShelf) {
		if (isSellable(nDaysOnShelf)) {
			return super.getDiscountedPrice(nDaysOnShelf);
		}
		return 0;
	}

}
