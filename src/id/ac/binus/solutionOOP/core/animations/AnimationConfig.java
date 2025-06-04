package id.ac.binus.solutionOOP.core.animations;

import java.io.File;
import javafx.scene.image.Image;

public class AnimationConfig {
    public final String spritePath;
    private final Image spriteImage;
    private final int spriteColumns;
    private final long frameDuration;

    public AnimationConfig(String spritePath, int spriteColumns, long frameDuration) {
        this.spritePath = spritePath;
        this.spriteImage = new Image(new File(spritePath).toURI().toString());
        this.spriteColumns = spriteColumns;
        this.frameDuration = frameDuration;
    }
    
    public long getFrameDuration() {
		return frameDuration;
    }
    public int getSpriteColumns() {
		return spriteColumns;
    }
    public Image getSpriteImage() {
    	return spriteImage;
    }
}
