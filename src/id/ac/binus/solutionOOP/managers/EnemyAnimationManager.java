package id.ac.binus.solutionOOP.managers;

import id.ac.binus.solutionOOP.controllers.AnimationController;
import id.ac.binus.solutionOOP.core.animations.CharacterAnimation;
import id.ac.binus.solutionOOP.core.animations.IAnimation;
import id.ac.binus.solutionOOP.core.constants.BossStateEnum;

public class EnemyAnimationManager {
    private AnimationController animationController;

    public EnemyAnimationManager() {
        this.animationController = new AnimationController();
        initializeAnimations();
    }

    public void initializeAnimations() {
		animationController.addAnimation(BossStateEnum.SPAWN,
				new CharacterAnimation("src/assets/sprite/boss/boss_spawn.png", 5, 60, 120, 120));
		animationController.addAnimation(BossStateEnum.LEVITATE,
				new CharacterAnimation("src/assets/sprite/boss/boss_levitate.png", 6, 90, 120, 120));
		animationController.addAnimation(BossStateEnum.SPAWN | BossStateEnum.LEVITATE,
				new CharacterAnimation("src/assets/sprite/boss/boss_levitate_spawn.png", 5, 60, 120, 120));
		animationController.addAnimation(BossStateEnum.IDLE,
				new CharacterAnimation("src/assets/sprite/boss/boss_idle.png", 8, 120, 120, 120));
		animationController.addAnimation(BossStateEnum.ATTACK | BossStateEnum.SPIN,
				new CharacterAnimation("src/assets/sprite/boss/boss_spin.png", 9, 30, 120, 120));
		animationController.addAnimation(BossStateEnum.ATTACK | BossStateEnum.PRE_DASH,
				new CharacterAnimation("src/assets/sprite/boss/boss_predash.png", 3, 60, 120, 120));
		animationController.addAnimation(BossStateEnum.ATTACK | BossStateEnum.DASH,
				new CharacterAnimation("src/assets/sprite/boss/boss_dash.png", 1, 60, 120, 120));
		animationController.addAnimation(BossStateEnum.IDLE | BossStateEnum.SPLIT_SWORD,
				new CharacterAnimation("src/assets/sprite/boss/boss_split_sword.png", 6, 30, 120, 120));
		animationController.addAnimation(BossStateEnum.IDLE | BossStateEnum.DESPAWN,
				new CharacterAnimation("src/assets/sprite/boss/boss_idle_despawn.png", 6, 30, 120, 120));
	}

    public void update(long currentTime) {
        animationController.update(currentTime);
    }

    public IAnimation getCurrentAnimation() {
        return animationController.getCurrentAnimation();
    }

    public void setCurrentAnimation(int id) {
        animationController.setCurrentAnimation(id);
    }

    public int getCycleCount() {
        return animationController.getCurrentAnimation().getCyclesCompleted();
    }
}
