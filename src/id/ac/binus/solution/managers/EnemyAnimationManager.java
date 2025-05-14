package id.ac.binus.solution.managers;

import id.ac.binus.solution.managers.AnimationController;
import id.ac.binus.solution.managers.CharacterAnimation;
import id.ac.binus.solution.managers.IAnimation;
import id.ac.binus.solution.core.animations.AnimationConfig;
import id.ac.binus.solution.core.constants.BossStateEnum;

public class EnemyAnimationManager {
    private AnimationController animationController;

    public EnemyAnimationManager() {
        this.animationController = new AnimationController();
        initializeAnimations();
    }

    public void initializeAnimations() {
		animationController.addAnimation(BossStateEnum.SPAWN,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/boss/boss_spawn.png", 5, 60), 120,
						120));
		animationController.addAnimation(BossStateEnum.LEVITATE,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/boss/boss_levitate.png", 6, 90), 120,
						120));
		animationController.addAnimation(BossStateEnum.SPAWN | BossStateEnum.LEVITATE,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/boss/boss_levitate_spawn.png", 5, 60),
						120, 120));
		animationController.addAnimation(BossStateEnum.IDLE,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/boss/boss_idle.png", 8, 120), 120, 120));
		animationController.addAnimation(BossStateEnum.ATTACK | BossStateEnum.SPIN,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/boss/boss_spin.png", 9, 30), 120, 120));
		animationController.addAnimation(BossStateEnum.ATTACK | BossStateEnum.PRE_DASH,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/boss/boss_predash.png", 3, 60), 120,
						120));
		animationController.addAnimation(BossStateEnum.ATTACK | BossStateEnum.DASH,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/boss/boss_dash.png", 1, 60), 120, 120));
		animationController.addAnimation(BossStateEnum.IDLE | BossStateEnum.SPLIT_SWORD,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/boss/boss_split_sword.png", 6, 30), 120,
						120));
		animationController.addAnimation(BossStateEnum.IDLE | BossStateEnum.DESPAWN,
				new CharacterAnimation(new AnimationConfig("src/assets/sprite/boss/boss_idle_despawn.png", 6, 30), 120,
						120));
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
