package uwstout.courses.cs145.inheritance.improved;

import java.io.*;

// -------------------------------------------------------------------------
/**
 *  Tests Kennel
 *
 *  @author  turners
 *  @version Nov 12, 2016
 */
public class TestKennel2 {

	// ----------------------------------------------------------
	/**
	 * Tests Kennel
	 * @param args Command line
	 */
	public static void main(String[] args) {
		
		Dachshund2 vienna = new Dachshund2("Vienna", 0);
		Dachshund2 gwaltney = new Dachshund2("Gwaltney", 16);
		Dog lowRider = new Dachshund2("Low Rider", -1);
		
		Poodle2 fifi = new Poodle2("Fifi", 1);
		Dog lulu = new Poodle2("Lulu", 2);
		Poodle2 fluffy = new Poodle2("Fluffy", 0);
		
		Dog foofoo = new ConfusedPoodle2("Foofoo", 1);
		ConfusedPoodle2 deFluffy = new ConfusedPoodle2("de Fluffy", 1);
		ConfusedPoodle2 concussed = new ConfusedPoodle2("Concussed", 2);
		
		Kennel2 kennel = new Kennel2();
		
		kennel.addDog(vienna);
		kennel.addDog(gwaltney);
		kennel.addDog(lowRider);
		kennel.addDog(fifi);
		kennel.addDog(lulu);
		kennel.addDog(fluffy);
		kennel.addDog(foofoo);
		kennel.addDog(deFluffy);
		kennel.addDog(concussed);
		
		//Don't want to be able to do this
		Dog dog = new Dog("Unknown");
		kennel.addDog(dog);
		
		PrintWriter out = new PrintWriter(System.out);
		
		kennel.barkAll(out);
		
		out.close();
		
		
		
		
		
	}
}
