package id.ac.binus.solutionOOP.ui;

import id.ac.binus.solutionOOP.config.Config;
import id.ac.binus.solutionOOP.core.models.Enemy;
import id.ac.binus.solutionOOP.core.models.Player;
import id.ac.binus.solutionOOP.game.UIFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UIManager {
    private final Stage stage;
    private final Player player;
    private final Enemy enemy;
    private final HealthBar playerHealthBar;
    private final HealthBar playerStaminaBar;
    private final HealthBar enemyHealthBar;
    private final Label playerHealthLabel;
    private final Label enemyHealthLabel;
    private final StackPane entityInfoContainer;

    public UIManager(Stage stage, Player player, Enemy enemy) {
        this.stage = stage;
        this.player = player;
        this.enemy = enemy;
        this.playerHealthBar = new HealthBar(Config.PLAYER_HEALTH_BAR_IMAGE, Config.PLAYER_MAX_HEALTH, Config.PLAYER_BAR_WIDTH_SCALE, javafx.scene.paint.Color.GREENYELLOW, javafx.scene.paint.Color.GREENYELLOW);
        this.playerStaminaBar = new HealthBar(Config.PLAYER_HEALTH_BAR_IMAGE, Config.PLAYER_MAX_STAMINA, Config.PLAYER_BAR_WIDTH_SCALE, javafx.scene.paint.Color.DARKCYAN, javafx.scene.paint.Color.DARKCYAN);
        this.enemyHealthBar = new HealthBar(Config.ENEMY_HEALTH_BAR_IMAGE, Config.ENEMY_MAX_HEALTH, Config.ENEMY_BAR_WIDTH_SCALE, javafx.scene.paint.Color.web("#992222"), javafx.scene.paint.Color.web("#b52a2a"));
        this.playerHealthLabel = UIFactory.makeLabel("Player Health: " + player.getHealth(), 10);
        this.enemyHealthLabel = UIFactory.makeLabel("Enemy Health: " + enemy.getHealth(), 10);
        this.entityInfoContainer = new StackPane();
    }

    public Scene createMainMenu(Runnable onPlay, Runnable onQuit) {
        VBox mainContainer = new VBox();
        Image menuImage = new Image(Config.MAIN_MENU_IMAGE);
        BackgroundImage bgImage = new BackgroundImage(menuImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        mainContainer.setBackground(new Background(bgImage));

        Button headerLabel = UIFactory.makeButton("PROJECT FLA WKWKW", 70);
        headerLabel.setPadding(new Insets(80));

        Button playButton = UIFactory.makeButton("Play");
        Button optionsButton = UIFactory.makeButton("Options");
        Button quitButton = UIFactory.makeButton("Quit to Desktop");

        playButton.setOnAction(e -> onPlay.run());
        quitButton.setOnAction(e -> onQuit.run());

        mainContainer.getChildren().addAll(headerLabel, playButton, optionsButton, quitButton);
        mainContainer.setAlignment(Pos.CENTER);

        return new Scene(mainContainer);
    }

    public void setupGameUI(StackPane root) {
        StackPane bossBarContainer = new StackPane();
        bossBarContainer.setTranslateY(-280);
        enemyHealthBar.addToContainer(bossBarContainer);
        bossBarContainer.getChildren().add(enemyHealthLabel);

        StackPane playerBarContainer = new StackPane();
        playerHealthBar.addToContainer(playerBarContainer);
        playerStaminaBar.addToContainer(playerBarContainer);

        VBox playerInfoContainer = new VBox();
        VBox topBox = new VBox();
        topBox.setPrefHeight(Config.CANVAS_HEIGHT * 0.9);
        playerInfoContainer.setPrefHeight(Config.CANVAS_HEIGHT - topBox.getPrefHeight());
        playerInfoContainer.setTranslateX(100);
        playerInfoContainer.setPrefWidth(Config.CANVAS_WIDTH / 2);
        playerInfoContainer.getChildren().addAll(topBox, UIFactory.makeLabel("player.getName()", 13), playerBarContainer);

        entityInfoContainer.getChildren().addAll(bossBarContainer, playerInfoContainer);
        root.getChildren().add(entityInfoContainer);
    }

    public void update() {
        playerHealthBar.update(player.getHealth());
        playerStaminaBar.update(player.getStamina());
        enemyHealthBar.update(enemy.getHealth());
        playerHealthLabel.setText("Player Health: " + player.getHealth());
        enemyHealthLabel.setText("Enemy Health: " + enemy.getHealth());
    }

    public StackPane getEntityInfoContainer() {
        return entityInfoContainer;
    }
}