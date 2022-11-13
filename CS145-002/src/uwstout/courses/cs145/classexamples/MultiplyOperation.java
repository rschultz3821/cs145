package uwstout.courses.cs145.classexamples;

public class MultiplyOperation extends AbstractOperation {

	public MultiplyOperation() {
		super("Multiply", "*");
	}

	@Override
	public Fraction perform(Fraction a, Fraction b) {
		return a.multiply(b);
	}
}
