package uwstout.cs145.GUITesting;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Form extends Application {

	private Scene scene;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {

		GridPane grid = new GridPane();
		grid.getColumnConstraints().add(new ColumnConstraints(75)); 
		grid.getColumnConstraints().add(new ColumnConstraints(75)); 
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);
		
		Label xLabel = new Label("x = ");
		Label yLabel = new Label("y = ");
		Label eqLabel = new Label("2x^2 + 3y = ");
		Label ansLabel = new Label("");
		ansLabel.setId("answer");
		TextField xField = new TextField();
		xField.setId("xValue");
		TextField yField = new TextField();
		yField.setId("yValue");
		Button calcButton = new Button("Calculate");
		calcButton.setPrefWidth(75);
		Button closeButton = new Button("Exit");
		closeButton.setPrefWidth(75);
		
		ansLabel.setPrefHeight(calcButton.getPrefHeight());
		
		
		grid.add(xLabel, 0, 0);
		GridPane.setHalignment(xLabel, HPos.RIGHT);
		grid.add(xField, 1, 0);
		grid.add(yLabel, 0, 1);
		GridPane.setHalignment(yLabel, HPos.RIGHT);
		grid.add(yField, 1, 1);
		grid.add(eqLabel, 0, 3);
		GridPane.setHalignment(eqLabel, HPos.RIGHT);
		grid.add(ansLabel, 1, 3);
		grid.add(calcButton, 1, 2);
		grid.add(closeButton, 1, 4);
		
		
		calcButton.setOnAction(this::calculate);
		closeButton.setOnAction(this::quit);
		
		scene = new Scene(grid, 170, 160);
		
		mainStage.setScene(scene);
		mainStage.setTitle("Equation");
		mainStage.show();
	}
	
	
	private void calculate(ActionEvent e) {
		try {
			TextField xField = (TextField) scene.lookup(".text-field");
			TextField yField = (TextField) scene.lookup("#yValue");
			String xStr = xField.getText();
			String yStr = yField.getText();
			double x = Double.parseDouble(xStr);
			double y = Double.parseDouble(yStr);
			double result = 2 * x * x + 3 * y;
			Label answer = (Label) scene.lookup("#answer");
			answer.setText(result + "");
		}
		catch (Exception ex) {
			Label answer = (Label) scene.lookup("#answer");
			answer.setText("Error");
		}
	}
	
	
	private void quit(ActionEvent e) {
		if (scene.getWindow() instanceof Stage) {
			((Stage) scene.getWindow()).close();
		}
	}
	
}
