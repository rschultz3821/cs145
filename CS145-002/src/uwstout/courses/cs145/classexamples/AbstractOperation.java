package uwstout.courses.cs145.classexamples;

public abstract class AbstractOperation implements Operation {

	private String name;
	private String symbol;

	public AbstractOperation(String nName, String nSymbol) {
		name = nName;
		symbol = nSymbol;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSymbol() {
		return symbol;
	}

	// public abstract int getPrec();

}
