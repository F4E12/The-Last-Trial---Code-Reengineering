package id.ac.binus.solutionOOP.main;

import id.ac.binus.solutionOOP.managers.PlayerManager;
import id.ac.binus.solutionOOP.managers.EnemyManager;
import id.ac.binus.solutionOOP.managers.UIManager;
import javafx.animation.AnimationTimer;

public class GameLoop {
    private final PlayerManager playerManager;
    private final EnemyManager enemyManager;
    private final UIManager uiManager;

    public GameLoop(PlayerManager playerManager, EnemyManager enemyManager, UIManager uiManager) {
        this.playerManager = playerManager;
        this.enemyManager = enemyManager;
        this.uiManager = uiManager;
    }

    public void start() {
        AnimationTimer gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (lastUpdate == 0 || now - lastUpdate >= 16_666_667) { // ~60 FPS
                    update();
                    lastUpdate = now;
                }
            }
        };
        gameLoop.start();
    }

    private void update() {
        playerManager.update();
        enemyManager.update();
        uiManager.update();
    }
}