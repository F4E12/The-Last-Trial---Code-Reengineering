package id.ac.binus.solution.camera;

import javax.swing.text.html.ImageView;

import org.w3c.dom.Node;

public class Effect {
    private static void applyVibration(Pane pane) {
        double initialMagnitude = 30;
        int iterations = 3;
        javafx.animation.Timeline vibrationTimeline = new javafx.animation.Timeline();
        for (int i = 0; i < iterations; i++) {
            double magnitude = initialMagnitude * (1 - (i / (double) iterations));
            KeyFrame moveLeft = new KeyFrame(javafx.util.Duration.millis(i * 50),
                    new KeyValue(pane.translateXProperty(), -magnitude));
            KeyFrame moveRight = new KeyFrame(javafx.util.Duration.millis(i * 50 + 25),
                    new KeyValue(pane.translateXProperty(), magnitude));
            KeyFrame reset = new KeyFrame(javafx.util.Duration.millis((i + 1) * 50),
                    new KeyValue(pane.translateXProperty(), 0));
            vibrationTimeline.getKeyFrames().addAll(moveLeft, moveRight, reset);
        }
        vibrationTimeline.play();
    }

    private void applyOverlayEffect(ImageView overlay) {
        overlay.setOpacity(0.8);
        FadeTransition fadeOut = new FadeTransition(Duration.millis(3000), overlay);
        fadeOut.setFromValue(0.8);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(e -> {
            overlay.setOpacity(0.0);

        });
        if (fadeOut != null && fadeOut.getStatus() == Animation.Status.RUNNING) {
            fadeOut.stop();
        }
        fadeOut.play();
    }

    private void applyFadeEffect(Node node) {
        Pane pane = (Pane) node;
        Rectangle fadeOverlay = new Rectangle(pane.getWidth() * 0.5 * 0.92, 40, Color.WHITE);
        fadeOverlay.setOpacity(0);
        pane.getChildren().add(fadeOverlay);
        FadeTransition fadeToBlack = new FadeTransition(Duration.millis(300), fadeOverlay);
        fadeToBlack.setFromValue(0.6);
        fadeToBlack.setToValue(0.0);
        fadeToBlack.setOnFinished(event -> pane.getChildren().remove(fadeOverlay));
        fadeToBlack.play();
    }
}
