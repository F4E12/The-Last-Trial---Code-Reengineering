package id.ac.binus.solution.core.animations;

import java.io.File;

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
}
