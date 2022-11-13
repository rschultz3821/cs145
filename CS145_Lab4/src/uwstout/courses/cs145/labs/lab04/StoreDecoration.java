package uwstout.courses.cs145.labs.lab04;

/**
 * Class for StoreDecoration
 * 
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 *
 */
public class StoreDecoration extends Product {

	protected String mHoliday;

	/**
	 * 
	 * @param name
	 * @param holiday
	 */
	public StoreDecoration(String name, String holiday) {
		super(name);
		mHoliday = holiday;
	}

	/**
	 * 
	 * @return
	 */
	public String getHoliday() {
		return mHoliday;
	}

	/**
	 * 
	 */
	public double getPrice() {
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public String getName() {
		return mName + "*";
	}

}
