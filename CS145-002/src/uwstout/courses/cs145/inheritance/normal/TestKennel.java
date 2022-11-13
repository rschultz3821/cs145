package uwstout.courses.cs145.inheritance.normal;

import java.io.*;

// -------------------------------------------------------------------------
/**
 *  Tests Kennel
 *
 *  @author  turners
 *  @version Nov 12, 2016
 */
public class TestKennel {

	// ----------------------------------------------------------
	/**
	 * Tests Kennel
	 * @param args Command line
	 */
	public static void main(String[] args) {
		
		Dachshund vienna = new Dachshund("Vienna", 0);
		Dachshund gwaltney = new Dachshund("Gwaltney", 16);
		Dachshund lowRider = new Dachshund("Low Rider", -1);
		
		Poodle fifi = new Poodle("Fifi", 1);
		Poodle lulu = new Poodle("Lulu", 2);
		Poodle fluffy = new Poodle("Fluffy", 0);
		
		ConfusedPoodle foofoo = new ConfusedPoodle("Foofoo", 1);
		ConfusedPoodle deFluffy = new ConfusedPoodle("de Fluffy", 1);
		ConfusedPoodle concussed = new ConfusedPoodle("Concussed", 2);
		
		Kennel kennel = new Kennel();
		
		kennel.addDog(vienna);
		kennel.addDog(gwaltney);
		kennel.addDog(lowRider);
		kennel.addDog(fifi);
		kennel.addDog(lulu);
		kennel.addDog(fluffy);
		kennel.addDog(foofoo);
		kennel.addDog(deFluffy);
		kennel.addDog(concussed);
		
		PrintWriter out = new PrintWriter(System.out);
		
		kennel.barkAll(out);
		
		out.close();
	}
}
