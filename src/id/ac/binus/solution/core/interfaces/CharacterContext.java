package id.ac.binus.solution.core.interfaces;

import id.ac.binus.solution.core.models.Vector2D;
import id.ac.binus.solution.core.states.boss.BossState;

public interface CharacterContext extends AnimatedBehaviour, VectorMotion, AudioBehaviour {
	public void changeState(BossState newState);

	public Vector2D getPos();

	public Vector2D[] getHitbox();

	public void setInvincible(boolean isInvincible);

	public boolean isInvincible();

	public int getScale();

	public void updateHealth(int delta);

	public int getState();

}