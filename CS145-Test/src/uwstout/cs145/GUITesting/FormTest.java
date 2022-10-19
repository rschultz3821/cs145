package uwstout.cs145.GUITesting;

import static org.junit.Assert.*;
import javafx.scene.control.*;
import javafx.stage.*;

import org.junit.*;
import org.testfx.api.*;
import org.testfx.framework.junit.*;

public class FormTest extends ApplicationTest {

	private Stage stage;
	
	@Override
	public void start(Stage mainStage) throws Exception {
		stage = mainStage;
		Form app = new Form();
		app.start(mainStage);
	}
	
	@Override
	public void stop() throws Exception {
		FxToolkit.hideStage();
	}
	
	

	@Test
	public void testSimple() {
		assertTrue("Window did not appear", stage.isShowing());
		assertEquals("Window has incorrect title.", "Equation",
				stage.getTitle());
	}
	
	
	@Test
	public void testCalculation() {
		
		//lookup by id and manually cast as a TextField
		TextField x = (TextField) lookup("#xValue").query();
		clickOn(x); //click on that control
		write("1"); //type 1 into the text box
		
		clickOn("#yValue").write("5.4"); //do it in one step
		
		clickOn("Calculate"); //lookup by text on the button
		//lookup by id but have it cast it for us
		Label ans = lookup("#answer").queryAs(Label.class);
		//get the text from the label, convert it to a double and compare
		assertEquals(18.2, Double.parseDouble(ans.getText()), 0.0001);
		
	}
	
	@Test
	public void testCalculationError() {
		clickOn("#xValue").write("1");
		//add a bad value
		clickOn("#yValue").write("bad number");
		
		clickOn("Calculate");
		
		Label ans = lookup("#answer").queryAs(Label.class);
		//see if it is an error
		assertEquals("Error", ans.getText());
		
	}
	
	

}
