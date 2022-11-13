package uwstout.courses.cs145.labs.lab04;

/**
 * Abstract class for Product
 * 
 * Creates a name and abstract price
 * 
 * @author SchultzRachel
 * @version 2022.11.03
 */
public abstract class Product {

	protected String mName;

	/**
	 * Constructor for product
	 * 
	 * Creates a name
	 * 
	 * @param name string name
	 */
	public Product(String name) {
		mName = name;
	}

	/**
	 * Getter for getName
	 *
	 * Gets the name
	 * 
	 * @return name
	 */
	public String getName() {
		return mName;
	}

	/**
	 * Getter for getPrice
	 * 
	 * abstract currently, gets a price
	 * 
	 * @return price
	 */
	protected abstract double getPrice();
}
