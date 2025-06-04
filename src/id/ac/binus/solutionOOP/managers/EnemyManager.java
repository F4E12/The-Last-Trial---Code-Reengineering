package id.ac.binus.solutionOOP.managers;

import id.ac.binus.solutionOOP.core.audio.IAudio;
import id.ac.binus.solutionOOP.core.interfaces.CharacterContext;
import id.ac.binus.solutionOOP.core.models.Enemy;
import id.ac.binus.solutionOOP.core.models.Vector2D;
import id.ac.binus.solutionOOP.core.states.boss.BossState;
import id.ac.binus.solutionOOP.core.states.boss.ExitableState;
import id.ac.binus.solutionOOP.core.states.boss.SpawnLevitateState;
import id.ac.binus.solutionOOP.controllers.Direction;
import id.ac.binus.solutionOOP.core.animations.IAnimation;
import id.ac.binus.solutionOOP.core.interfaces.FXBehaviour;

public class EnemyManager implements CharacterContext, FXBehaviour {
	private Enemy enemy;
	private EnemyMovementManager movementManager;
	private EnemyAnimationManager animationManager;
	private EnemyAudioManager audioManager;
	private BossState currentState;

	public EnemyManager(Enemy enemy) {
		this.enemy = enemy;
		this.movementManager = new EnemyMovementManager(enemy.getRigidBody());
		this.animationManager = new EnemyAnimationManager();
		this.audioManager = new EnemyAudioManager();
		this.currentState = new SpawnLevitateState();
	}

	@Override
	public void start() {
		currentState.start(this);
	}

	@Override
	public void update() {
		if (currentState != null) {
			currentState.update(this);
		}
		movementManager.update(enemy.getPos());
		animationManager.update(System.currentTimeMillis());
	}

	@Override
	public void setAnimation(int animationId) {
		animationManager.setCurrentAnimation(animationId);
	}

	@Override
	public int getAnimationCycleCount() {
		return animationManager.getCurrentAnimation().getCyclesCompleted();
	}

	@Override
	public IAnimation getCurrentAnimation() {
		return animationManager.getCurrentAnimation();
	}

	@Override
	public void addForce(double force, Direction direction) {
		movementManager.addForce(force, direction);
	}

	@Override
	public Direction getDirection() {
		return this.movementManager.getDirection();
	}

	public void setDirection(Direction direction) {
		this.movementManager.setDirection(direction);
	}

	@Override
	public void changeState(BossState newState) {
		if (currentState instanceof ExitableState) {
		    ((ExitableState) currentState).exit(this);
		}
		currentState = newState;
		currentState.start(this);
	}

	@Override
	public IAudio getCurrentSound() {
		return audioManager.getCurrentSound();
	}

	@Override
	public void setSound(int soundId) {
		this.audioManager.setCurrentSound(soundId);

	}

	@Override
	public Vector2D getPos() {
		return this.enemy.getPos();
	}

	@Override
	public Vector2D[] getHitbox() {
		return this.enemy.getHitboxArray();
	}

	@Override
	public void updateHealth(int delta) {
		this.enemy.updateHealth(delta);
	}

	@Override
	public void setInvincible(boolean isInvincible) {
		this.enemy.setInvincible(isInvincible);
	}

	@Override
	public boolean isInvincible() {
		return enemy.isInvincible();
	}

	@Override
	public int getState() {
		return Integer.MIN_VALUE;
	}

	@Override
	public int getScale() {
		return enemy.getScale();
	}

}
