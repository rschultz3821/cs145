package uwstout.cs145.GUITesting.ClassExamples;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
//import javafx.scene.shape.Arc;
//import javafx.scene.shape.ArcType;
//import javafx.scene.shape.Circle;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PacMan extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {

		// title
		mainStage.setTitle("PacMan");

		// group
		// add to the scene
		Group content = new Group();
		
		PacManFigure pacman1 = new PacManFigure(100, 100, 50, 50);
		PacManFigure pacman2 = new PacManFigure(350, 450, 500, -250);

		
		content.getChildren().addAll(pacman1, pacman2);
		

		// scene
		Scene mainScene = new Scene(content, 500, 500);
		// background
		Stop[] stops = new Stop[] { new Stop(0, Color.HOTPINK), new Stop(1, Color.color(1.0, 1.0, 1.0)) };
		LinearGradient lg1 = new LinearGradient(0, 0, .5, .5, true, CycleMethod.REFLECT, stops);

		mainScene.setFill(lg1);

		mainStage.setScene(mainScene);
		mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
