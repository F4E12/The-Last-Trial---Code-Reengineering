package id.ac.binus.solution.core.animations;

import java.io.File;

import javafx.scene.image.Image;

public class CharacterAnimation implements IAnimation {
  private final AnimationConfig animationConfig;
  private final int cropWidth;
  private final int cropHeight;
  private int cyclesCompleted;;
  private int currentFrame;
  private long lastFrameTime;

  public CharacterAnimation(AnimationConfig animationConfig) {
    this.animationConfig = animationConfig;
    this.cropWidth = 60;
    this.cropHeight = 60;
    this.cyclesCompleted = 0;
    this.currentFrame = 0;
    this.lastFrameTime = 0;
  }

  public CharacterAnimation(AnimationConfig animationConfig, int cropWidth, int cropHeight) {
    this.animationConfig = animationConfig;
    this.cropWidth = cropWidth;
    this.cropHeight = cropHeight;
  }

  @Override
  public void start() {
    this.cyclesCompleted = 0;
  }

  @Override
  public void update(long currentTime) {
    if (currentTime - lastFrameTime >= this.frameDuration) {
      currentFrame++;
      if (currentFrame >= this.spriteColumns) {
        currentFrame = 0;
        ++cyclesCompleted;
      }
      lastFrameTime = currentTime;
    }
  }

  @Override
  public int getCurrentFrame() {
    return this.currentFrame;
  }

  @Override
  public Image getSpriteImage() {
    return this.spriteImage;
  }

  @Override
  public int getCropWidth() {
    return this.cropWidth;
  }

  @Override
  public int getCropHeight() {
    return this.cropHeight;
  }

  @Override
  public int getCyclesCompleted() {
    return cyclesCompleted;
  }

}
