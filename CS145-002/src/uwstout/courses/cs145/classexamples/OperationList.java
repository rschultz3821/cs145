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
	
	public void addOperation(Operation op) {
		// grow the array
		
		
		ops[count] = op;
		count++;
	}
	
	
	
	
}
