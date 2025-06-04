package id.ac.binus.solutionOOP.controllers;

import java.util.HashMap;
import java.util.Map;

import id.ac.binus.solutionOOP.core.animations.IAnimation;

public class AnimationController {
	private final Map<Integer, IAnimation> animations; 
	private IAnimation currentAnimation;

	public AnimationController() {
		this.animations = new HashMap<>();    	
	}
  
	public void update(long currentTime) {
		if (currentAnimation != null) {
			currentAnimation.update(currentTime);
		}
	}

	public void addAnimation(int state, IAnimation animation) {
		animations.put(state, animation);
	}

	public void setCurrentAnimation(int state) {
		currentAnimation = animations.get(state);
		currentAnimation.start();
	}

	public IAnimation getCurrentAnimation() {
		return currentAnimation;
	}
    
	public boolean isAnimationCycleCompleted() {
		return currentAnimation != null ? currentAnimation.getCyclesCompleted() > 0 : false;
	}

}
