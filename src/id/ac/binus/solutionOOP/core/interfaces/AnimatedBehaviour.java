package id.ac.binus.solutionOOP.core.interfaces;

import id.ac.binus.solutionOOP.core.animations.IAnimation;

public interface AnimatedBehaviour {
  public IAnimation getCurrentAnimation();
  public int getAnimationCycleCount();
  public void setAnimation(int animationId);
}
