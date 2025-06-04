package id.ac.binus.solutionOOP.main;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class GameSceneBuilder {
    public StackPane buildGameContainer() {
        StackPane container = new StackPane();
        container.setStyle("-fx-background-color: black;");
        return container;
    }

    public Scene buildScene(StackPane root) {
        return new Scene(root, 1800, 900);
    }
}