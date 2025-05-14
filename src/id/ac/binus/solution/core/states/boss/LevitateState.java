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

/*
 * Smell Code : Switch Statement
 * Reason     : Developer memakai terlalu banyak if-statements
 * Smell      : Move Method
 */

public class LevitateState implements BossState {
	
	private void initCharacter(CharacterContext context) {		
		context.setAnimation(BossStateEnum.LEVITATE);
		context.setSound(BossStateEnum.LEVITATE);
		context.setInvincible(false);
	}

	@Override
	public void start(CharacterContext context) {
		initCharacter(context);
	}

	@Override
	public void update(CharacterContext context) {
		if (context.getAnimationCycleCount() <= 3) {
			context.addForce(2 * Vector.UP, Vector.Y);
		}else {
			context.changeState(new IdleState());			
		}
	}
}