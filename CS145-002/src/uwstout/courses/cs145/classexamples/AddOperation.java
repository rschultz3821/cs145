package uwstout.courses.cs145.classexamples;

public class AddOperation implements Operation {

	public String getName() {
		return "Add";
	}

	@Override
	public String getSymbol() {
		return "+";
	}

	@Override
	public Fraction perform(Fraction a, Fraction b) {
		return a.add(b);
	}
	
	
}
