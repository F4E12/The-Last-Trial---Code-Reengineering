package id.ac.binus.solutionOOP.core.states.boss;

import id.ac.binus.solutionOOP.core.constants.BossStateEnum;
import id.ac.binus.solutionOOP.core.interfaces.CharacterContext;

public class SpawnState implements BossState {

	private void initCharacter(CharacterContext context) {
		context.setAnimation(BossStateEnum.SPAWN);
		context.setInvincible(true);
	}  
	
	@Override
	public void start(CharacterContext context) {
		initCharacter(context);
	}

	@Override
	public void update(CharacterContext context) {
		if (context.getAnimationCycleCount() > 0) {
			context.changeState(new IdleState());
		}
	}

}