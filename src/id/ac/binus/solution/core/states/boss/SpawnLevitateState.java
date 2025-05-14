package id.ac.binus.solution.core.states.boss;

import id.ac.binus.solution.core.constants.BossStateEnum;
import id.ac.binus.solution.core.constants.Vector;
import id.ac.binus.solution.core.interfaces.CharacterContext;

/*
 * Smell Code : Dead Code
 * Reason     : Method exit dari interface BossState tidak pernah dipakai
 * Smell      : Delete Dead Code
 */

/*
 * Smell Code : Long Method
 * Reason     : Sebuah method memiliki terlalu banyak tanggung jawab
 * Smell      : Extract Method
 */

public class SpawnLevitateState implements BossState {

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
			context.addForce(2 * Vector.UP, Vector.Y);
		}

	}
}
