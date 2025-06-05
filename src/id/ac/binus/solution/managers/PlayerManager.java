package id.ac.binus.solution.managers;

import id.ac.binus.solution.controllers.AnimationController;
import id.ac.binus.solution.controllers.AudioController;
import id.ac.binus.solution.controllers.Direction;
import id.ac.binus.solution.controllers.MovementController;
import id.ac.binus.solution.core.audio.IAudio;
import id.ac.binus.solution.core.constants.PlayerStateEnum;
import id.ac.binus.solution.core.interfaces.CharacterContext;
import id.ac.binus.solution.core.models.Player;
import id.ac.binus.solution.core.models.Vector2D;
import id.ac.binus.solution.core.states.boss.BossState;
import id.ac.binus.solution.core.animations.AnimationConfig;
import id.ac.binus.solution.core.animations.CharacterAnimation;
import id.ac.binus.solution.core.animations.IAnimation;
import id.ac.binus.solution.core.interfaces.FXBehaviour;

public class PlayerManager implements CharacterContext, FXBehaviour {
	private final Player player;
    private final MovementController movementController;
    private final PlayerInputManager inputHandler;
    private final PlayerCombatManager combatManager;
    private final PlayerAnimationManager animationManager;
    private final PlayerAudioManager audioManager;
    private final AudioController audioController;
    private final AnimationController animationController;

	public PlayerManager(Player player) {
        this.player = player;
        this.movementController = new MovementController(player.getRigidBody());
        this.inputHandler = new PlayerInputManager();
        this.combatManager = new PlayerCombatManager();
        this.animationManager = new PlayerAnimationManager();
        this.animationController = new AnimationController();
        this.audioController = new AudioController();
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

	@Override
	public void addForce(double force, Direction direction) {
		movementController.addForce(force, direction);
	}

	@Override
	public Direction getDirection() {
		return movementController.getDirection();
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
		return this.player.getHitboxArray();
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

	public void start() {
		
	}

}
