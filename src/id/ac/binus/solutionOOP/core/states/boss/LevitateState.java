package id.ac.binus.solutionOOP.core.states.boss;

import id.ac.binus.solutionOOP.core.constants.BossStateEnum;
import id.ac.binus.solutionOOP.core.constants.Vector;
import id.ac.binus.solutionOOP.controllers.Direction;
import id.ac.binus.solutionOOP.core.interfaces.CharacterContext;

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