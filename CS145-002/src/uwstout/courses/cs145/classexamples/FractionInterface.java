package uwstout.courses.cs145.classexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
//import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FractionInterface extends Application {

	private static final double BUTTON_WIDTH = 50;
	private static final double BUTTON_HEIGHT = 50;

	// inner class
	private static class ButtonInfo {
		private String text;
		private String id;

		public ButtonInfo(String nText, String nId) {
			text = nText;
			id = nId;
		}

		public String getText() {
			return text;
		}

		public String getId() {
			return id;
		}
	}

	private static final ButtonInfo[] BUTTONS = { new ButtonInfo("CE", "op_ce"), new ButtonInfo("C", "op_c"),
			new ButtonInfo("X2", "op_sqr"), new ButtonInfo("1/X", "op_rec"),

			new ButtonInfo("7", "num_7"), new ButtonInfo("8", "num_8"), new ButtonInfo("9", "num_9"),
			new ButtonInfo("/", "op_/"),

			new ButtonInfo("4", "num_4"), new ButtonInfo("5", "num_5"), new ButtonInfo("6", "num_6"),
			new ButtonInfo("x", "op_*"),

			new ButtonInfo("1", "num_1"), new ButtonInfo("2", "num_2"), new ButtonInfo("3", "num_3"),
			new ButtonInfo("-", "op_-"),

			new ButtonInfo("+/-", "op_neg"), new ButtonInfo("0", "num_0"), new ButtonInfo("=", "op_="),
			new ButtonInfo("+", "op_+"), };

	@Override
	public void start(Stage mainStage) throws Exception {
		mainStage.setTitle("Fraction Calculator");

		// group with buttons and stuff
		GridPane content = new GridPane();

		// add buttons
		for (int i = 0; i < BUTTONS.length; i++) {
			content.add(makeButton(BUTTONS[i].getText(), BUTTONS[i].getId()), i % 4, i / 4);
			// 0..19
			// 0 -> r 0 c 0
			// 1 -> r 0 c 1
			// 4 -> r 1 c 0
			// ...
		}

		Scene mainScene = new Scene(content);
		mainStage.setScene(mainScene);

		mainStage.setMinWidth(BUTTON_WIDTH * 4);
		mainStage.setMinHeight(BUTTON_HEIGHT * 5);

		mainStage.show();
	}

	private Button makeButton(String text, String id) {
		// same size
		// position?
		// id
		Button b = new Button(text);

		// TODO max? min?
		b.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		// b.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		b.setId(id);
		b.setOnAction(this::onButtonClick);

		return b;
	}

	private void onButtonClick(ActionEvent e) {
		Object source = e.getSource();

		if (source instanceof Button) {
			Button b = (Button) source;
			System.out.println(b.getId());
		} else {
			System.out.println("oops.");

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
