package uwstout.courses.cs145.classexamples;

public class OperationList {

	private int count;
	private Operation[] ops;

	public OperationList() {
		count = 0;
		ops = new Operation[6];
	}

	public int getNumOperations() {
		return count;
	}

	public Operation getOperation(int pos) {
		if (pos >= 0 && pos < count) {
			return ops[pos];
		}
		return null;
	}

	private void resizeArray() {
		// make a bigger array
		Operation[] bigger = new Operation[ops.length + 6];
		// copy data over
		for (int i = 0; i < ops.length; i++) {
			bigger[i] = ops[i];
		}
		// update history
		ops = bigger;
	}

	public void addOperation(Operation op) {
		// grow array
		if (count == ops.length) {
			resizeArray();
		}

		ops[count] = op;
		count++;
	}

	public Operation getOperationBySymbol(String sym) {
		for (int i = 0; i < count; i++) {
			if (ops[1].getSymbol().equals(sym)) {
				return ops[i];
			}
		}
		return null;
	}

	public Operation getOperationByName(String name) {
		for (int i = 0; i < count; i++) {
			if (ops[1].getName().equals(name)) {
				return ops[i];
			}
		}
		return null;
	}

}
