package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/*
 * Smell Code : Dead Code / Speculative Generality
 * Reason     : The constructor public UIFactory() is defined but unused and empty
 * Treatment  : Remove method
 */

/*
 * Smell Code : Duplicate Code
 * Reason     : The code for creating buttons and labels repeats the same setup
 * Treatment  : Extract Method
 */

/*
 * Smell Code : Primitive Obsession
 * Reason     : The font path is repeated and hard-coded as a string
 * Treatment  : Make a constant variable
 */

public class UIFactory {
	
	public static Label makeLabel(String str, int size) {
		
		Font customFont = Font.loadFont(UIFactory.class.getResourceAsStream("/assets/font/prstartk-webfont.ttf"), size);
		Label newLabel = new Label(str);
		newLabel.setStyle("-fx-background-color: none;");
		newLabel.setTextFill(Color.WHITE);
		newLabel.setFont(customFont);
		
		return newLabel;
	}
	
	public static Button makeButton(String str) {
		
		Font customFont = Font.loadFont(UIFactory.class.getResourceAsStream("/assets/font/prstartk-webfont.ttf"), 25);
		Button menuButton = new Button(str);
		menuButton.setStyle("-fx-background-color: none;");
		menuButton.setTextFill(Color.WHITE);
		menuButton.setFont(customFont);
		
		return menuButton;
	}
	
	public static Button makeButton(String str, int size) {
		
		Font customFont = Font.loadFont(UIFactory.class.getResourceAsStream("/assets/font/prstartk-webfont.ttf"), size);
		Button menuButton = new Button(str);
		menuButton.setStyle("-fx-background-color: none;");
		menuButton.setTextFill(Color.WHITE);
		menuButton.setFont(customFont);
		
		return menuButton;
	}

	public UIFactory() {
		// TODO Auto-generated constructor stub
	}

}
