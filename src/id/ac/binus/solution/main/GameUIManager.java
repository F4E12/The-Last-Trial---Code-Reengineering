package id.ac.binus.solution.main;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import id.ac.binus.solution.core.models.Player;
import id.ac.binus.solution.core.models.Enemy;
import id.ac.binus.solution.UIFactory;

public class GameUIManager {
    private Rectangle playerHealthBar;
    private Rectangle playerStaminaBar;
    private ImageView playerBarImgView;

    private Rectangle enemyHealthBarForeground;
    private Rectangle enemyHealthBarBackground;
    private ImageView enemyBarImgView;

    private Label playerHealthLabel;
    private Label enemyHealthLabel;

    public StackPane buildPlayerUI(Player player) {
        double barWidth = 200;
        double barHeight = 24;
        playerHealthBar = new Rectangle(barWidth, barHeight, Color.GREENYELLOW);
        playerStaminaBar = new Rectangle(barWidth, barHeight, Color.DARKCYAN);

        playerBarImgView = new ImageView(new Image("./assets/sprite/ui/player_healthbar.png"));
        playerBarImgView.setFitWidth(barWidth);
        playerBarImgView.setPreserveRatio(true);

        StackPane container = new StackPane();
        container.getChildren().addAll(playerHealthBar, playerStaminaBar, playerBarImgView);
        return container;
    }

    public StackPane buildEnemyUI(Enemy enemy) {
        double barWidth = 400;
        enemyHealthBarForeground = new Rectangle(barWidth, 40, Color.web("#992222"));
        enemyHealthBarBackground = new Rectangle(barWidth, 20, Color.web("#b52a2a"));

        enemyBarImgView = new ImageView(new Image("./assets/sprite/ui/boss_healthbar.png"));
        enemyBarImgView.setFitWidth(barWidth);
        enemyBarImgView.setPreserveRatio(true);

        StackPane container = new StackPane();
        container.getChildren().addAll(enemyHealthBarForeground, enemyHealthBarBackground, enemyBarImgView);
        return container;
    }

    public void updatePlayerBars(Player player, double maxHealth, double maxStamina) {
        double healthPercent = Math.max(0, player.getHealth()) / maxHealth;
        playerHealthBar.setWidth(playerBarImgView.getFitWidth() * healthPercent);

        double staminaPercent = Math.max(0, player.getStamina()) / maxStamina;
        playerStaminaBar.setWidth(playerBarImgView.getFitWidth() * staminaPercent);
    }

    public void updateEnemyBars(Enemy enemy, double maxHealth) {
        double enemyHealthPercent = Math.max(0, enemy.getHealth()) / maxHealth;
        double width = enemyBarImgView.getFitWidth() * 0.92 * enemyHealthPercent;
        enemyHealthBarForeground.setWidth(width);
        enemyHealthBarBackground.setWidth(width);
    }
}
