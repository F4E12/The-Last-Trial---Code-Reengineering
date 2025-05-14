package id.ac.binus.solution.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        GameSceneBuilder sceneBuilder = new GameSceneBuilder();
        StackPane root = sceneBuilder.buildGameContainer();
        Scene scene = sceneBuilder.buildScene(root);

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}