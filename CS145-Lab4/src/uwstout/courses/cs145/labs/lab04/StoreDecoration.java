package uwstout.courses.cs145.labs.lab04;

/**
 * Class for StoreDecoration
 * 
 * StoreDecoration inherits from Product class. This class is like Product but
 * with some added functions like holiday and setting the price to zero.
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public class StoreDecoration extends Product {

	/**
	 * Protected String mHoliday
	 * 
	 * Protected String mHoliday
	 */
	protected String mHoliday;

	/**
	 * Constructor for StoreDecoration
	 * 
	 * Takes in a name and holiday and sets them.
	 * 
	 * @param name    takes in a name from the parent class
	 * @param holiday takes in a holiday
	 */
	public StoreDecoration(String name, String holiday) {
		super(name);
		mHoliday = holiday;
	}

	/**
	 * Method getHoliday
	 * 
	 * Gets the holiday
	 * 
	 * @return holiday
	 */
	public String getHoliday() {
		return mHoliday;
	}

	/**
	 * Method getPrice
	 * 
	 * Gets the price
	 * 
	 * @return zero
	 */
	public double getPrice() {
		return 0;
	}

	/**
	 * Method for getName
	 * 
	 * Overrides getName from parent class
	 * 
	 * @return name*
	 */
	@Override
	public String getName() {
		return mName + "*";
	}

}
