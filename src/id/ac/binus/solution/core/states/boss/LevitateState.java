package id.ac.binus.solution.core.states.boss;

import id.ac.binus.solution.core.constants.BossStateEnum;
import id.ac.binus.solution.core.constants.Vector;
import id.ac.binus.solution.controllers.Direction;
import id.ac.binus.solution.core.interfaces.CharacterContext;

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
			context.addForce(2 * Vector.UP, Direction.Y);
		}else {
			context.changeState(new IdleState());			
		}
	}
}