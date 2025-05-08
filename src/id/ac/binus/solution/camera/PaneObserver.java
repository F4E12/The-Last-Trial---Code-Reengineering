package id.ac.binus.solution.camera;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PaneObserver {
	private static PaneObserver instance;
	private final List<ImageView> FXListeners = new ArrayList<>();
	private final List<Pane> playerListeners = new ArrayList<>();
	private final List<Pane> enemyListeners = new ArrayList<>();
	Random rand = new Random();

	public static PaneObserver getInstance() {
		if (instance == null) {
			instance = new PaneObserver();
		}
		return instance;
	}

	public void addFXListener(ImageView imgView) {
		FXListeners.add(imgView);
	}

	public void addPlayerListener(Pane pane) {
		playerListeners.add(pane);
	}

	public void notifyPlayerListeners() {
		for (Pane pane : playerListeners) {
			Effect.applyVibration(pane);
		}
		for (ImageView overlay : FXListeners) {
			Effect.applyOverlayEffect(overlay);
		}
	}

	public void addEnemyListener(Pane pane) {
		enemyListeners.add(pane);
	}

	public void notifyEnemyListeners() {
		for (Pane pane : enemyListeners) {
			Effect.applyVibration(pane);
			Effect.applyFadeEffect(pane);
		}
	}
}
