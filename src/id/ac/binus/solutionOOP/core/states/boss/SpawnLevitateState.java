package id.ac.binus.solutionOOP.core.states.boss;

import id.ac.binus.solutionOOP.core.constants.BossStateEnum;
import id.ac.binus.solutionOOP.core.constants.Vector;
import id.ac.binus.solutionOOP.controllers.Direction;
import id.ac.binus.solutionOOP.core.interfaces.CharacterContext;
import id.ac.binus.solutionOOP.managers.EnemyManager;

public class SpawnLevitateState implements BossState, ExitableState {

	private void initCharacter(CharacterContext context) {
		context.setAnimation(BossStateEnum.SPAWN | BossStateEnum.LEVITATE);
		context.setSound(BossStateEnum.SPAWN | BossStateEnum.LEVITATE);
		context.setInvincible(true);
	}  
	
	@Override
	public void start(CharacterContext context) {
		initCharacter(context);
	}

	@Override
	public void update(CharacterContext context) {
		if (context.getAnimationCycleCount() > 0) {
			context.changeState(new LevitateState());
		} else {
			context.addForce(2 * Vector.UP, Direction.Y);
		}

	}
	
	@Override
    public void exit(EnemyManager enemyManager) {
        // Do cleanup
    }
}
