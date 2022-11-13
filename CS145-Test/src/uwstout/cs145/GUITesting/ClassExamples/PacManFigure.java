package uwstout.cs145.GUITesting.ClassExamples;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class PacManFigure extends Group{
	
	public PacManFigure(int x, int y, int width, int height) {
		
		// arc body
		Arc body = new Arc(250, 250, 250, 250, 30, 300);
		body.setFill(Color.YELLOW);
		body.setType(ArcType.ROUND);
		body.setStroke(Color.BLACK);
		body.setStrokeWidth(2);

		// circle eye
		Circle eye = new Circle(270, 100, 20, Color.BLACK);

		// text Nom, nom, nom
		Text saying = new Text(320, 250, "Nom, nom, nom");
		saying.setFont(Font.font("Comic Sans MS", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 24));

		getChildren().addAll(body, eye, saying);
		
		// transforms
		Translate move = new Translate(x - 250, y - 250);
		Scale resize = new Scale(width / 500.0, height / 500.0);
		
		getTransforms().add(move);
		getTransforms().add(new Translate(250, 250));
		getTransforms().add(resize);
		getTransforms().add(new Translate(-250, -250));


	}

}
