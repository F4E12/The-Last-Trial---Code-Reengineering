package id.ac.binus.solution.managers;

import id.ac.binus.solution.controllers.AnimationController;
import id.ac.binus.solution.core.animations.CharacterAnimation;
import id.ac.binus.solution.core.animations.IAnimation;
import id.ac.binus.solution.core.constants.PlayerStateEnum;
import id.ac.binus.solution.core.models.Player;

public class PlayerAnimationManager {
    private final AnimationController animationController = new AnimationController();
    private int stateCache = PlayerStateEnum.IDLE;

    public PlayerAnimationManager() {
        animationController.addAnimation(PlayerStateEnum.IDLE,
            new CharacterAnimation("src/assets/sprite/player/player_idleedited.png", 4, 150));
        animationController.addAnimation(PlayerStateEnum.WALKING,
            new CharacterAnimation("src/assets/sprite/player/player_walk.png", 8, 40));
        animationController.addAnimation(PlayerStateEnum.JUMPING,
            new CharacterAnimation("src/assets/sprite/player/player_jump.png", 4, 200));
        animationController.addAnimation(PlayerStateEnum.JUMPING | PlayerStateEnum.WALKING,
            new CharacterAnimation("src/assets/sprite/player/player_jump.png", 4, 200));
        animationController.addAnimation(PlayerStateEnum.FALLING,
            new CharacterAnimation("src/assets/sprite/player/player_fall.png", 2, 150));
        animationController.addAnimation(PlayerStateEnum.ATTACKING,
            new CharacterAnimation("src/assets/sprite/player/player_attack_2.png", 8, 23, 80, 60));
        animationController.addAnimation(PlayerStateEnum.ATTACKING | PlayerStateEnum.JUMPING,
            new CharacterAnimation("src/assets/sprite/player/player_attack_airborne.png", 8, 23, 80, 60));
        animationController.setCurrentAnimation(PlayerStateEnum.IDLE);
    }

    public void update(Player player) {
        animationController.update(System.currentTimeMillis());
        int currentState = player.hasState(PlayerStateEnum.ATTACKING)
            ? PlayerStateEnum.ATTACKING
            : player.getState();

        if (currentState != stateCache) {
            stateCache = currentState;
            animationController.setCurrentAnimation(currentState);
        }
    }

    public IAnimation getCurrentAnimation() {
        return animationController.getCurrentAnimation();
    }
}
