package uwstout.courses.cs145.classexamples;

import static org.junit.Assert.*;

import org.junit.Test;

public class HistoryIOTest {

	@Test
	public void testHistoryIOString() {
		fail("Not yet implemented");
	}

	@Test
	public void testHistoryIOFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoad() {
		HistoryIO input = new HistoryIO("testinput.txt");
		
		CalculatorHistory hist = input.load();
		
		assertEquals("1/2\n3/5\n7/3\n6/11\n-5/12", hist.toString());			
		
	}
	
	//Testing save
	//check if the file exists?
	//read in the output file (maybe with load?)
	//check each fraction for correctness

}
