package uwstout.courses.cs145.classexamples;

public class CalculatorController {
	
	private static OperationList oList = null;
	
	private CalculatorController() {
		// TODO
	}
	
	private static void createList() {
		oList = new OperationList();
		oList.addOperation(new AddOperation());
		oList.addOperation(new SubtractOperation());
	}

	public static OperationList getOperations() {
		if (oList == null) {
			createList();
		}
		
		return oList;
	}
}
