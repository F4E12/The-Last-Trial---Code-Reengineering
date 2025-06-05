package id.ac.binus.solutionOOP.camera;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/*
 * Smell Code : Incomplete Abstraction
 * Reason     : Ada method untuk add namun tidak ada method remove
 * Treatment  : Membuat method remove untuk melengkapi method-method add
 */

public class PaneObserver {
	private static PaneObserver instance;
	private final List<ImageView> FXListeners = new ArrayList<>();
	private final List<Pane> playerListeners = new ArrayList<>();
	private final List<Pane> enemyListeners = new ArrayList<>();

	private PaneObserver() {}

	public static PaneObserver getInstance() {
		if (instance == null) {
			instance = new PaneObserver();
		}
		return instance;
	}

	public void addFXListener(ImageView imgView) {
		FXListeners.add(imgView);
	}

	public void removeFXListener(ImageView imgView) {
        if (imgView != null) {
            fxListeners.remove(imgView);
        }
    }

	public void addPlayerListener(Pane pane) {
		playerListeners.add(pane);
	}

	public void removePlayerListener(Pane pane) {
        if (pane != null) {
            playerListeners.remove(pane);
        }
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

	public void removeEnemyListener(Pane pane) {
        if (pane != null) {
            enemyListeners.remove(pane);
        }
    }

	public void notifyEnemyListeners() {
		for (Pane pane : enemyListeners) {
			Effect.applyVibration(pane);
			Effect.applyFadeEffect(pane);
		}
	}
}
