package id.ac.binus.solution.managers;

import game.controllers.AnimationController;
import game.controllers.AttackHandler;
import game.controllers.AudioController;
import game.controllers.MovementController;
import game.core.audio.Audio;
import game.core.audio.IAudio;
import game.core.constants.PlayerStateEnum;
import game.core.interfaces.CharacterContext;
import game.core.models.Player;
import game.core.models.Vector2D;
import game.core.states.boss.BossState;
import id.ac.binus.solution.core.animations.AnimationConfig;
import id.ac.binus.solution.core.animations.CharacterAnimation;
import id.ac.binus.solution.core.animations.IAnimation;
import id.ac.binus.solution.core.interfaces.FXUpdateBehaviour;
import javafx.scene.input.KeyCode;

public class PlayerManager implements CharacterContext, FXUpdateBehaviour {
	private final Player player;
    private final MovementController movementController;
    private final PlayerInputManager inputHandler;
    private final PlayerCombatManager combatManager;
    private final PlayerAnimationManager animationManager;
    private final PlayerAudioManager audioManager;

	public PlayerManager(Player player) {
        this.player = player;
        this.movementController = new MovementController(player.getRb());
        this.inputHandler = new PlayerInputManager();
        this.combatManager = new PlayerCombatManager();
        this.animationManager = new PlayerAnimationManager();
        this.audioManager = new PlayerAudioManager();
    }

	@Override
    public void update() {
        inputHandler.handleInput(player, combatManager);
        movementController.update(player.getPos());
        combatManager.updateAttack(player);
        combatManager.restoreStamina(player);
        animationManager.update(player);
        if (player.getHealth() <= 0) System.exit(0);
    }

	private void initializeAnimations() {
		animationController.addAnimation(PlayerStateEnum.IDLE,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/player/player_idleedited.png", 4, 150)));
		animationController.addAnimation(PlayerStateEnum.WALKING,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/player/player_walk.png", 8, 40)));
		animationController.addAnimation(PlayerStateEnum.JUMPING,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/player/player_jump.png", 4, 200)));
		animationController.addAnimation(PlayerStateEnum.JUMPING | PlayerStateEnum.WALKING,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/player/player_jump.png", 4, 200)));
		animationController.addAnimation(PlayerStateEnum.FALLING,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/player/player_fall.png", 2, 150)));
		animationController.addAnimation(PlayerStateEnum.ATTACKING,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/player/player_attack_2.png", 8, 23), 80,
						60));
		animationController.addAnimation(PlayerStateEnum.ATTACKING | PlayerStateEnum.JUMPING,
				new CharacterAnimation(
						new AnimationConfig("src/assets/sprite/player/player_attack_airborne.png", 8, 23), 80, 60));
		animationController.setCurrentAnimation(PlayerStateEnum.IDLE);
	}

	private void initializeAudio() {
		audioController.addAudio(PlayerStateEnum.JUMPING, new Audio("src/assets/audio/sfx/jump.wav"));
		audioController.addAudio(PlayerStateEnum.ATTACKING, new Audio("src/assets/audio/sfx/swordswing1.wav"));
	}

	@Override
	public void addForce(double force, int direction) {
		movementController.addForce(force, direction);
	}

	@Override
	public int getDirection() {
		return movementController.getDirection();
	}

	public void handleAttack() {
		if (attackTimer > 0) {
			attackTimer--;
			if (attackTimer == 0) {
				player.removeState(PlayerStateEnum.ATTACKING);
			}
		}
	}

	public IAnimation getCurrentAnimation() {
		return this.animationController.getCurrentAnimation();
	}

	@Override
	public int getAnimationCycleCount() {
		return Integer.MIN_VALUE;
	}

	@Override
	public void setAnimation(int animationId) {
	}

	@Override
	public IAudio getCurrentSound() {
		return null;
	}

	@Override
	public void setSound(int soundId) {
	}

	@Override
	public void changeState(BossState newState) {

	}

	@Override
	public Vector2D getPos() {
		return this.player.getPos();
	}

	@Override
	public Vector2D[] getHitbox() {
		return this.player.getHitbox();
	}

	@Override
	public void updateHealth(int delta) {
		this.player.updateHealth(delta);
	}

	@Override
	public void setInvincible(boolean isInvincible) {
		return;
	}

	@Override
	public boolean isInvincible() {
		return false;
	}

	@Override
	public int getScale() {
		return player.getScale();
	}
	@Override
	public int getState() {
		return player.getState();
	}

}
