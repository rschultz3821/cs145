package uwstout.courses.cs145.inheritance.improved;

import java.io.*;



// -------------------------------------------------------------------------
/**
 * A collection of dogs.
 *
 * @author Schnook
 * @version Nov 12, 2016
 */
public class Kennel2 {

	private Dog[] dogs;
	private int count;

	private static final int INIT_SIZE = 10;
	private static final int INC_SIZE = 3;
	// ----------------------------------------------------------
	/**
	 * Creates an empty kennel
	 */
	public Kennel2() {
		dogs = new Dog[INIT_SIZE];
		count = 0;
	}

	// ----------------------------------------------------------
	/**
	 * Gets the number of dogs
	 * 
	 * @return Number of dogs
	 */
	public int getDogCount() {
		return count;
	}


	private Dog[] grow(Dog[] old, int size) {
		Dog[] newArr = new Dog[size];
		for (int i = 0; i < old.length; i++) {
			newArr[i] = old[i];
		}
		return newArr;
	}
	
	// ----------------------------------------------------------
	/**
	 * Adds a dog
	 * 
	 * @param d
	 *            Dog to add
	 */
	public void addDog(Dog d) {
		if (count == dogs.length) {
			dogs = grow(dogs, dogs.length + INC_SIZE);
		}
		dogs[count] = d;
		count++;
	}

	// ----------------------------------------------------------
	/**
	 * Causes all dogs to bark.
	 * 
	 * @param writer
	 *            Output stream
	 */
	public void barkAll(PrintWriter writer) {
		for (int i = 0; i < count; i++) {
			writer.println(dogs[i].getName() + ": " + dogs[i].bark());
		}

	}

}
