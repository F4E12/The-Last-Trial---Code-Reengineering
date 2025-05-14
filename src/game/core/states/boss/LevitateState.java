package game.core.states.boss;

import game.core.constants.BossStateEnum;
import game.core.constants.Vector;
import game.core.interfaces.CharacterContext;

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

	@Override
	public void start(CharacterContext context) {
		context.setAnimation(BossStateEnum.LEVITATE);
		context.setSound(BossStateEnum.LEVITATE);
		context.setInvincible(false);
	}

	@Override
	public void update(CharacterContext context) {

		if (context.getAnimationCycleCount() <= 3) {
			context.addForce(2 * Vector.UP, Vector.Y);
		}
		if (context.getAnimationCycleCount() > 3) {
			context.changeState(new IdleState());
		}

	}

	@Override
	public void exit(CharacterContext context) {
		// Cleanup if needed
	}
}