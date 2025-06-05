package id.ac.binus.solutionOOP.main;

import id.ac.binus.solutionOOP.config.Config;
import id.ac.binus.solutionOOP.core.models.Enemy;
import id.ac.binus.solutionOOP.core.models.Player;
import id.ac.binus.solutionOOP.core.models.Vector2D;
import id.ac.binus.solutionOOP.core.constants.PlayerStateEnum;
import id.ac.binus.solutionOOP.main.GameLoop;
import id.ac.binus.solutionOOP.managers.EnemyManager;
import id.ac.binus.solutionOOP.managers.GameManager;
import id.ac.binus.solutionOOP.managers.Input;
import id.ac.binus.solutionOOP.managers.PlayerManager;
import id.ac.binus.solutionOOP.managers.MediaManager;
import id.ac.binus.solutionOOP.config.DefaultRenderer;
import id.ac.binus.solutionOOP.config.Renderer;
import id.ac.binus.solutionOOP.controllers.Direction;
import id.ac.binus.solutionOOP.managers.UIManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    private final Canvas playerCanvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
    private final GraphicsContext playerGC = playerCanvas.getGraphicsContext2D();
    private final Canvas enemyCanvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
    private final GraphicsContext enemyGC = enemyCanvas.getGraphicsContext2D();
    private final StackPane root = new StackPane();
    private final StackPane gameContainer = new StackPane();
    private final StackPane camera = new StackPane();
    private final Scene gameScene = new Scene(root, Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
    private final ImageView overlayView = new ImageView(new Image(Config.BLOOD_OVERLAY_IMAGE));
    private final Player player = new Player(1000, new Vector2D(640, 600), PlayerStateEnum.IDLE, 4);
    private final PlayerManager playerManager = new PlayerManager(player);
    private final Enemy enemy = new Enemy(1000, new Vector2D(640, 600), 4);
    private final EnemyManager enemyManager = new EnemyManager(enemy);
    private final Input input = Input.getInstance();
    private UIManager uiManager;
    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        UIManager uiManager = new UIManager(stage, player, enemy);
        stage.setScene(uiManager.createMainMenu(this::startGame, stage::close));
        stage.setFullScreen(true);
        stage.show();
    }

    private void startGame() {
        MediaManager mediaManager = new MediaManager();
        UIManager uiManager = new UIManager(stage, player, enemy);
        setupGameScene(mediaManager, uiManager);
        GameLoop gameLoop = new GameLoop(playerManager, enemyManager, uiManager);
        gameLoop.start();
        stage.setScene(gameScene);
        stage.setFullScreen(true);
    }

    private void setupGameScene(MediaManager mediaManager, UIManager uiManager) {
        Rectangle darkOverlay = new Rectangle(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT, Color.BLACK);
        darkOverlay.setOpacity(0.3);

        gameScene.setFill(Color.BLACK);
        gameContainer.getChildren().addAll(mediaManager.getMediaView(), darkOverlay, enemyCanvas, playerCanvas);
        gameContainer.setPrefWidth(Config.CANVAS_WIDTH);
        gameContainer.setStyle("-fx-background-color: black;");
        camera.getChildren().add(gameContainer);
        gameContainer.setAlignment(javafx.geometry.Pos.CENTER);

        overlayView.setPreserveRatio(true);
        overlayView.setFitWidth(2400);
        overlayView.setOpacity(0);

        uiManager.setupGameUI(root);
        root.setStyle("-fx-background-color: black;");
        root.setAlignment(javafx.geometry.Pos.CENTER);

        GameManager.getInstance().addContext(0, playerManager);
        GameManager.getInstance().addContext(1, enemyManager);

        gameScene.setOnKeyPressed(event -> input.pressKey(event.getCode()));
        gameScene.setOnKeyReleased(event -> input.releaseKey(event.getCode()));

        mediaManager.play();
        setupAnimation();
    }

    private void setupAnimation() {
        AnimationTimer renderLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                render();
            }
        };
        renderLoop.start();
    }

    private void render() {
        playerGC.clearRect(0, 0, Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
        enemyGC.clearRect(0, 0, Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);

        Renderer playerRenderer = new DefaultRenderer(playerManager.getDirection());
        playerRenderer.render(playerGC, playerManager.getCurrentAnimation(), player.getPos());

        Direction enemyDirection = (enemy.getPos().getX() > player.getPos().getX()) ? Direction.LEFT : Direction.RIGHT;
        enemyManager.setDirection(enemyDirection);
        Renderer enemyRenderer = new DefaultRenderer(enemyDirection);
        enemyRenderer.render(enemyGC, enemyManager.getCurrentAnimation(), enemy.getPos());

        parallax();
    }

    private void parallax() {
        camera.setTranslateX((-player.getPos().getX() * 0.2) + 160);
        uiManager.getEntityInfoContainer().setTranslateX(player.getPos().getX() * 0.2 / 10);
        camera.setTranslateY((-player.getPos().getY() * 0.2) + 140);
    }

    public static void main(String[] args) {
        launch();
    }
}