package uwstout.courses.cs145.classexamples;

public class DivideOperation extends AbstractOperation {

	public DivideOperation() {
		super("Divide", "/");
	}

	@Override
	public Fraction perform(Fraction a, Fraction b) {
		return a.divide(b);
	}

}
