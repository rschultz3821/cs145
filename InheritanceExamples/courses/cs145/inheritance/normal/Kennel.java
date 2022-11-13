package uwstout.courses.cs145.inheritance.normal;

import java.io.*;


// -------------------------------------------------------------------------
/**
 * A collection of dogs.
 *
 * @author Schnook
 * @version Nov 12, 2016
 */
public class Kennel {

	private Dachshund[] dachshunds;
	private int dachCount;
	private Poodle[] poodles;
	private int poodleCount;
	private ConfusedPoodle[] confusedPoodles;
	private int confPoodleCount;
	
	private static final int INIT_SIZE = 10;
	private static final int INC_SIZE = 3;

	// ----------------------------------------------------------
	/**
	 * Creates an empty kennel
	 */
	public Kennel() {
		dachshunds = new Dachshund[INIT_SIZE];
		dachCount = 0;
		poodles = new Poodle[INIT_SIZE];
		poodleCount = 0;
		confusedPoodles = new ConfusedPoodle[INIT_SIZE];
		confPoodleCount = 0;
	}

	// ----------------------------------------------------------
	/**
	 * Gets the number of dogs
	 * 
	 * @return Number of dogs
	 */
	public int getDogCount() {
		return dachCount + poodleCount + confPoodleCount;
	}

	
	
	private Dachshund[] grow(Dachshund[] old, int size) {
		Dachshund[] newArr = new Dachshund[size];
		for (int i = 0; i < old.length; i++) {
			newArr[i] = old[i];
		}
		return newArr;
	}
	

	private Poodle[] grow(Poodle[] old, int size) {
		Poodle[] newArr = new Poodle[size];
		for (int i = 0; i < old.length; i++) {
			newArr[i] = old[i];
		}
		return newArr;
	}
	

	private ConfusedPoodle[] grow(ConfusedPoodle[] old, int size) {
		ConfusedPoodle[] newArr = new ConfusedPoodle[size];
		for (int i = 0; i < old.length; i++) {
			newArr[i] = old[i];
		}
		return newArr;
	}
	
	// ----------------------------------------------------------
	/**
	 * Adds a dachshund
	 * 
	 * @param d
	 *            Dachshund to add
	 */
	public void addDog(Dachshund d) {
		if (dachCount == dachshunds.length) {
			dachshunds = grow(dachshunds, dachshunds.length + INC_SIZE);
		}
		dachshunds[dachCount] = d;
		dachCount++;
	}

	// ----------------------------------------------------------
	/**
	 * Adds a poodles
	 * 
	 * @param p
	 *            Poodle to add
	 */
	public void addDog(Poodle p) {
		if (poodleCount == poodles.length) {
			poodles = grow(poodles, poodles.length + INC_SIZE);
		}
		poodles[poodleCount] = p;
		poodleCount++;
	}

	// ----------------------------------------------------------
	/**
	 * Adds a confused poodle
	 * 
	 * @param c
	 *            ConfusedPoodle to add
	 */
	public void addDog(ConfusedPoodle c) {
		if (confPoodleCount == confusedPoodles.length) {
			confusedPoodles = grow(confusedPoodles, confusedPoodles.length + INC_SIZE);
		}
		confusedPoodles[confPoodleCount] = c;
		confPoodleCount++;
	}

	// ----------------------------------------------------------
	/**
	 * Causes all dogs to bark.
	 * @param writer Output stream
	 */
	public void barkAll(PrintWriter writer) {
		for (int i = 0; i < dachCount; i++) {
			writer.println(dachshunds[i].getName() + ": " 
				+ dachshunds[i].bark());
		}

		for (int i = 0; i < poodleCount; i++) {
			writer.println(poodles[i].getName() + ": " 
					+ poodles[i].bark());
		}

		for (int i = 0; i < confPoodleCount; i++) {
			writer.println(confusedPoodles[i].getName() + ": " 
					+ confusedPoodles[i].bark());
		}
	}

}
