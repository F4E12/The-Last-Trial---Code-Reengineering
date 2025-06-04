package id.ac.binus.solutionOOP.core.states.boss;

import id.ac.binus.solutionOOP.controllers.AttackHandler;
import id.ac.binus.solutionOOP.controllers.Direction;
import id.ac.binus.solutionOOP.core.constants.BossStateEnum;
import id.ac.binus.solutionOOP.core.interfaces.CharacterContext;

public class AttackDashState implements BossState {

	private Boolean dashed;
	private Boolean hasAttacked;
	
	private void initBool() {
		this.dashed = false;
		this.hasAttacked = false;
	}

	private void initCharacter(CharacterContext context) {
		context.setAnimation(BossStateEnum.ATTACK | BossStateEnum.DASH);
		context.setSound(BossStateEnum.ATTACK | BossStateEnum.DASH);
		context.setInvincible(false);
	}
	
	@Override
	public void start(CharacterContext context) {
		initBool();
		initCharacter(context);
	}

	@Override
	public void update(CharacterContext context) {

		if (!hasAttacked) {
			hasAttacked = AttackHandler.attack(1, 0, 50);
		}
		if (!dashed) {
			int force = 60 * context.getDirection().getValue();
			context.addForce(force, Direction.X);
			dashed = true;
		}
		
		int cycleCount = context.getAnimationCycleCount();
		if (cycleCount > 6) {
			context.changeState(new IdleState());
		}
	}

	public Boolean isDashed() {
		return dashed;
	}

	public Boolean isHasAttacked() {
		return hasAttacked;
	}
	
}
