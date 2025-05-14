package id.ac.binus.solution.main;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
    private Runnable updateFunction;
    private Runnable renderFunction;
    private long lastUpdate = 0;

    public GameLoop(Runnable updateFunction, Runnable renderFunction) {
        this.updateFunction = updateFunction;
        this.renderFunction = renderFunction;
    }

    @Override
    public void handle(long now) {
        if (lastUpdate == 0 || now - lastUpdate >= 16_666_667) {
            updateFunction.run();
            renderFunction.run();
            lastUpdate = now;
        }
    }
}