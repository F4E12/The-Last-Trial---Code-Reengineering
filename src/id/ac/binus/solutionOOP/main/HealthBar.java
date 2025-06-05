package id.ac.binus.solutionOOP.main;

import id.ac.binus.solutionOOP.config.Config;
import id.ac.binus.solutionOOP.main.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HealthBar {
    private final Rectangle foreground;
    private final Rectangle background;
    private final ImageView imageView;
    private final double maxValue;
    private final double barWidth;

    public HealthBar(String imagePath, double maxValue, double widthScale, Color foregroundColor, Color backgroundColor) {
        this.maxValue = maxValue;
        Image image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitWidth(Config.CANVAS_WIDTH * widthScale);
        imageView.setPreserveRatio(true);

        barWidth = imageView.getFitWidth() * (widthScale == Config.ENEMY_BAR_WIDTH_SCALE ? Config.ENEMY_BAR_SCALE : 1.0);
        foreground = new Rectangle(barWidth, 24, foregroundColor);
        background = new Rectangle(barWidth, 24, backgroundColor);
    }

    public void update(double currentValue) {
        double percent = Math.max(0, currentValue) / maxValue;
        foreground.setWidth(barWidth * percent);
        background.setWidth(barWidth * percent);
    }

    public void addToContainer(StackPane container) {
        StackPane healthContainer = new StackPane();
        healthContainer.setMaxWidth(barWidth);
        healthContainer.setMaxHeight(24);
        healthContainer.setBackground(new Background(new BackgroundFill(Color.web("#361b19"), new CornerRadii(0), new javafx.geometry.Insets(0))));
        healthContainer.getChildren().addAll(background, foreground);
        healthContainer.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        container.getChildren().addAll(healthContainer, imageView);
    }
}