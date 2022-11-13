package uwstout.courses.cs145.classexamples;

public class Fraction {

	// variables
	// num and denom
	private int num;
	private int denom;

	/**
	 * Creates a new Fraction.
	 * 
	 * @param nNum   Numerator of the fraction
	 * @param nDenom Denominator of the fractions
	 */
	// constructors
	public Fraction(int nNum, int nDenom) {
		setFraction(nNum, nDenom);
//		num = nNum;
//		denom = nDenom;
//		
//		if (nDenom == 0) {
//			throw new IllegalArgumentException(
//					"Denominator cannot be 0.");
//		}
//		
//		// negative
//		// +/+, -/+, +/-, -/-
//		if (denom < 0) {
//			denom *= -1;
//			num = -num;
//		}
//		
//		// reduce
//		reduce();
		
	}

	// default constructor
	public Fraction() {
		num = 0;
		denom = 1;
	}

	// copy constructor
	public Fraction(Fraction f) {
		num = f.getNumerator();
		denom = f.denom;
	}
	
	
	private void reduce() {
		
		int large;
		int small;
		int rem;
		
		if (num == 0) {
			denom = 1;
			return;
		}
		
		
		if (Math.abs(num) > Math.abs(denom)) {
			large = Math.abs(num);
			small = Math.abs(denom);
		}
		else {
			large = Math.abs(denom);
			small = Math.abs(num);
		}
		
		
		// loop,
		rem = large % small;
		while (rem != 0) {
			large = small;
			small = rem;
			rem = large % small;
		}
		
		num /= small;
		denom /= small;
		
	}
	
	
	

	public int getNumerator() {
		return num;
	}

	public int getDenominator() {
		return denom;
	}

	public void setFraction(int nNum, int nDenom) {
		num = nNum;
		denom = nDenom;
		
		if (nDenom == 0) {
			throw new IllegalArgumentException(
					"Denominator cannot be 0.");
		}
		
		// negative
		// +/+, -/+, +/-, -/-
		if (denom < 0) {
			denom *= -1;
			num = -num;
		}
		
		// reduce
		reduce();
		
	}

	public String toString() {
		return num + "/" + denom;
	}

	public double toDecimal() {
		return (double) num / denom;
	}
	
	public Fraction negate() {
		Fraction negative = new Fraction(-num, denom);
		
		return negative;
	}
	
	
	// c = a * b;
	public Fraction multiply(Fraction b) {
		return new Fraction(num * b.num, denom * b.denom);
	}
	
	public Fraction add(Fraction b) {
		return new Fraction(num * b.denom + b.num * denom,
				denom * b.denom);
	}
	
	public Fraction subtract(Fraction b) {
		return add(b.negate());
	}
	
	public Fraction invert() {
		return new Fraction(denom, num);
	}
	
	public Fraction divide(Fraction b) {
		return multiply(b.invert());
	}
	
	
	
	// TODO add, subtract, multiply, negate, toDecimal
	
	// methods        
	// * + - / truncation?
	// reduce
	// to/from decimal
	// mixed numbers?
	// negatives?
	// invert
	// negate

}
