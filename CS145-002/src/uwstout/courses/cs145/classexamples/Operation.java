package uwstout.courses.cs145.classexamples;

public interface Operation {

	public String getName();
	public String getSymbol();
	public Fraction perform(Fraction a, Fraction b);
	
	
}
