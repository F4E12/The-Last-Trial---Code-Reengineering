package id.ac.binus.solution.main;

import javafx.scene.canvas.GraphicsContext;
import id.ac.binus.solution.core.animations.IAnimation;
import id.ac.binus.solution.core.models.Vector2D;

public class GameRenderer {
    public void draw(GraphicsContext gc, IAnimation animation, Vector2D pos, int direction) {
        if (animation == null) return;

        int deltaX = animation.getCropWidth();
        int deltaY = animation.getCropHeight();
        int startX = animation.getCurrentFrame() * deltaX;
        int startY = 0;
        int adjustedWidth = deltaX;

        if (direction < 0) {
            startX += deltaX;
            adjustedWidth = -deltaX;
        }

        gc.drawImage(animation.getSpriteImage(), startX, startY, adjustedWidth, deltaY, pos.getX(),
                pos.getY() - deltaY * 4, deltaX * 4, deltaY * 4);
    }
}
