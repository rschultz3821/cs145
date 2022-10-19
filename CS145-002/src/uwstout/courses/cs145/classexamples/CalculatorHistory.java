package uwstout.courses.cs145.classexamples;

public class CalculatorHistory {

	// bunch of fractions - array
	private Fraction[] history;
	private int count;

	// array of fractions?
	// Fraction
	// nothing
	// copy
	// size?
	public CalculatorHistory() {
		history = new Fraction[7];
		count = 0;

	}

	// amount to grow?
	private void resizeArray() {
		// make a bigger array
		Fraction[] bigger = new Fraction[history.length + 6];
		// copy data over
		for (int i = 0; i < history.length; i++) {
			bigger[i] = history[i];
		}
		// update history
		history = bigger;
	}

	public void addFraction(Fraction f) {

		// TODO is it full??
		if (count == history.length) {
			resizeArray();
		}

		// making a copy
		history[count] = new Fraction(f);
		count++;
	}

	public int getHistoryCount() {
		return count;

	}

	public Fraction getFraction(int pos) {
		// check if pos is valid
		if (pos >= 0 && pos < count) {
			return history[pos];

		}
		return null;
	}

	// delete fractions
	public boolean removeFraction(int pos) {

		// check pos
		if (pos >= 0 && pos < count) {
			// remove value?

			// move data down
			for (int i = pos; i < count - 1; i++) {
				history[i] = history[i + 1];
			}
			// dec count
			count--;

			return true;
		}

		return false;
		// test end, begin, middle

	}

	// save?
	// clear
	public void clear() {
		count = 0;
	}

	// find
	public int findFraction(Fraction f) {
		for (int i = 0; i < count; i++) {
			if (history[i].getNumerator() == f.getNumerator() && history[i].getDenominator() == f.getDenominator()) {
				return i;

			}
		}
		return -1;

	}

	// get fraction
	// toString?
	public String toString() {
		// each fraction n/d on its own line
		String str = "";
		
		for(int i = 0; i < count; i++) {
			str += history[i];
			if(i != count - 1) {
				str += "\n";
			}
		}
		return str;
	}

}
