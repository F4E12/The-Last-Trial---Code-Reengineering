package id.ac.binus.solution.core.interfaces;

import id.ac.binus.solution.core.animations.IAnimation;

public interface AnimatedBehaviour {
  public IAnimation getCurrentAnimation();
  public int getAnimationCycleCount();
  public void setAnimation(int animationId);
}
