package id.ac.binus.solutionOOP.config;

import id.ac.binus.solutionOOP.core.animations.IAnimation;
import id.ac.binus.solutionOOP.core.models.Vector2D;
import javafx.scene.canvas.GraphicsContext;

public interface Renderer {
    void render(GraphicsContext gc, IAnimation animation, Vector2D pos);
}