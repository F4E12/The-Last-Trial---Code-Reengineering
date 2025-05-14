package id.ac.binus.solution.managers;

import game.controllers.AnimationController;
import game.controllers.AudioController;
import game.controllers.NPCMovementController;
import game.core.audio.Audio;
import game.core.audio.IAudio;
import game.core.constants.BossStateEnum;
import game.core.interfaces.CharacterContext;
import game.core.models.Enemy;
import game.core.models.Vector2D;
import game.core.states.boss.BossState;
import game.core.states.boss.SpawnLevitateState;
import id.ac.binus.solution.core.animations.AnimationConfig;
import id.ac.binus.solution.core.animations.CharacterAnimation;
import id.ac.binus.solution.core.animations.IAnimation;
import id.ac.binus.solution.core.interfaces.AnimatedBehaviour;
import id.ac.binus.solution.core.interfaces.AudioBehaviour;
import id.ac.binus.solution.core.interfaces.FXStartBehaviour;
import id.ac.binus.solution.core.interfaces.FXUpdateBehaviour;
import id.ac.binus.solution.core.interfaces.VectorMotion;
import id.ac.binus.solution.game.core.animations.IAnimation;

public class EnemyManager implements AnimatedBehaviour, VectorMotion, AudioBehaviour, FXStartBehaviour, FXUpdateBehaviour {
	private Enemy enemy;
	private EnemyMovementManager movementManager;
	private EnemyAnimationManager animationManager;
	private EnemyAudioManager audioManager;
	private BossState currentState;

	public EnemyManager(Enemy enemy) {
		this.enemy = enemy;
		this.movementManager = new EnemyMovementManager(enemy.getRb());
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

	public IAnimation getCurrentAnimation() {
		return animationManager.getCurrentAnimation();
	}

	@Override
	public void addForce(double force, int direction) {
		movementManager.addForce(force, direction);
	}

	@Override
	public int getDirection() {
		return this.movementManager.getDirection();
	}

	public void setDirection(int direction) {
		this.movementManager.setDirection(direction);
	}

	public void changeState(BossState newState) {
		if (currentState != null) {
			currentState.exit(this);
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

	public Vector2D getPos() {
		return this.enemy.getPos();
	}

	public Vector2D[] getHitbox() {
		return this.enemy.getHitbox();
	}

	public void updateHealth(int delta) {
		this.enemy.updateHealth(delta);
	}

	public void setInvincible(boolean isInvincible) {
		this.enemy.setInvincible(isInvincible);
	}

	public boolean isInvincible() {
		return enemy.isInvincible();
	}

	public int getState() {
		return Integer.MIN_VALUE;
	}

	public int getScale() {
		return enemy.getScale();
	}

}
