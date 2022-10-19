package uwstout.courses.cs145.classexamples;

public class SubtractOperation implements Operation {

	@Override
	public String getName() {
		return "Subtract";
	}

	@Override
	public String getSymbol() {
		return "-";
	}

	@Override
	public Fraction perform(Fraction a, Fraction b) {
		return a.subtract(b);
	}

}
