package uwstout.courses.cs145.classexamples;

public enum FractionDisplayType {
	FRACTION,
	MIXED_NUMBER,
	DECIMAL;
	
	public String toString() {
		String str = "";
		switch(this) {
		
		case FRACTION: 
			str = "Fraction";
			break;
			
		case MIXED_NUMBER:
			str = "Mixed Number";
			break;
			
		case DECIMAL:
			str = "Decimal";
			break;
		}
		
		return str;
	}
	
}
