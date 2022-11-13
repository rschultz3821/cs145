package uwstout.courses.cs145.classexamples;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HistoryIO {

	private File historyLog;

	public HistoryIO(String path) {
		historyLog = new File(path);
	}

	public HistoryIO(File f) {
		historyLog = f;
	}

	// n/d
	// n/d

	public CalculatorHistory load() {
		// create a history
		CalculatorHistory hist = new CalculatorHistory();

		// scanner with file -
		try {
			Scanner input = new Scanner(historyLog);
			// loop
			while (input.hasNext()) {
				String line = input.nextLine();
				// build a new scanner from the line of input
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter("/");
				// read a fraction -> Fraction object
				try {
					int num = lineScan.nextInt();
					// slash?
					//input.skip("/");
					int denom = lineScan.nextInt();
					Fraction f = new Fraction(num, denom);
					// add to history
					hist.addFraction(f);
				}
				catch (Exception e) {
					// do nothing
				}
				lineScan.close();

			}

			input.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// return the history
		return hist;
	}

	
	public void save(CalculatorHistory hist) {
		try {
			PrintWriter output = new PrintWriter(historyLog);
		
			output.print(hist.toString());
			
			output.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


}
