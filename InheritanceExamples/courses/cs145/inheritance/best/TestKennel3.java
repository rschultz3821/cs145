package uwstout.courses.cs145.inheritance.best;

import java.io.*;

// -------------------------------------------------------------------------
/**
 *  Tests Kennel
 *
 *  @author  turners
 *  @version Nov 12, 2016
 */
public class TestKennel3 {

	// ----------------------------------------------------------
	/**
	 * Tests Kennel
	 * @param args Command line
	 */
	public static void main(String[] args) {
		
		Dachshund3 vienna = new Dachshund3("Vienna", 0);
		Dachshund3 gwaltney = new Dachshund3("Gwaltney", 16);
		AbstractDog lowRider = new Dachshund3("Low Rider", -1);
		
		Poodle3 fifi = new Poodle3("Fifi", 1);
		AbstractDog lulu = new Poodle3("Lulu", 2);
		Poodle3 fluffy = new Poodle3("Fluffy", 0);
		
		AbstractDog foofoo = new ConfusedPoodle3("Foofoo", 1);
		Poodle3 deFluffy = new ConfusedPoodle3("de Fluffy", 1);
		ConfusedPoodle3 concussed = new ConfusedPoodle3("Concussed", 2);
		
		Kennel3 kennel = new Kennel3();
		
		kennel.addDog(vienna);
		kennel.addDog(gwaltney);
		kennel.addDog(lowRider);
		kennel.addDog(fifi);
		kennel.addDog(lulu);
		kennel.addDog(fluffy);
		kennel.addDog(foofoo);
		kennel.addDog(deFluffy);
		kennel.addDog(concussed);
		
		//Can no longer do this
		//AbstractDog dog = new AbstractDog("Unknown");
		//kennel.addDog(dog);
		
		PrintWriter out = new PrintWriter(System.out);
		
		kennel.barkAll(out);
		
		out.close();	
	}
}
