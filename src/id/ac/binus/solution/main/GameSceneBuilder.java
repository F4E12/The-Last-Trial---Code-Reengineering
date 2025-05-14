package id.ac.binus.solution.main;
import javafx.scene.layout.StackPane;
import id.ac.binus.solution.core.models.Enemy;
import id.ac.binus.solution.core.models.Player;
import id.ac.binus.solution.managers.EnemyManager;
import id.ac.binus.solution.managers.PlayerManager;

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