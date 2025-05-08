package id.ac.binus.solution.factory;

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
	
	private static final String FONT_PATH = "/assets/font/prstartk-webfont.ttf";

    private static void styleNode(Labeled node, Font font) {
        node.setStyle("-fx-background-color: none;");
        node.setTextFill(Color.WHITE);
        node.setFont(font);
    }

    public static Label makeLabel(String str, int size) {
        Font font = Font.loadFont(UIFactory.class.getResourceAsStream(FONT_PATH), size);
        Label label = new Label(str);
        styleNode(label, font);
        return label;
    }

    public static Button makeButton(String str) {
        return makeButton(str, 25);
    }

    public static Button makeButton(String str, int size) {
        Font font = Font.loadFont(UIFactory.class.getResourceAsStream(FONT_PATH), size);
        Button button = new Button(str);
        styleNode(button, font);
        return button;
    }

}
