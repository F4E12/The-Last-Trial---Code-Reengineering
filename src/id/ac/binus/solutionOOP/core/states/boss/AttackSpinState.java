package id.ac.binus.solutionOOP.core.states.boss;

import id.ac.binus.solutionOOP.controllers.AttackHandler;
import id.ac.binus.solutionOOP.controllers.Direction;
import id.ac.binus.solutionOOP.core.constants.BossStateEnum;
import id.ac.binus.solutionOOP.core.interfaces.CharacterContext;

public class AttackSpinState implements BossState {

	private Boolean hasAttacked;
	
	private void initBool() {
		this.hasAttacked = false;
	}
		
	  
	private void initCharacter(CharacterContext context) {
		context.setAnimation(BossStateEnum.ATTACK | BossStateEnum.SPIN);
		context.setSound(BossStateEnum.ATTACK | BossStateEnum.SPIN);
		context.setInvincible(false);
	}  

	@Override
	public void start(CharacterContext context) {
		initBool();
		initCharacter(context);
	}

	@Override
	public void update(CharacterContext context) {

		if(AttackHandler.attack(1, 0, 2)) {
		  hasAttacked = true;
		}

		int cycleCount = context.getAnimationCycleCount();
		
		if (cycleCount > 1) {
			if(hasAttacked) {
				int force = 20 * (context.getDirection().getValue()*-1);
				context.addForce(force, Direction.X);
				
				context.changeState(new SplitSwordState());
			} else {
				context.changeState(new IdleDespawnState());
			}
		}
	}

	public Boolean isHasAttacked() {
		return hasAttacked;
	}
	
}
