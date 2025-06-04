package id.ac.binus.solution.core.states.boss;

import id.ac.binus.solution.core.constants.BossStateEnum;
import id.ac.binus.solution.core.interfaces.CharacterContext;

public class IdleDespawnState implements BossState {
	Position position;
	
	private void initCharacter(CharacterContext context) {		
		context.setInvincible(true);
		context.setAnimation(BossStateEnum.IDLE | BossStateEnum.DESPAWN);
		context.setSound(BossStateEnum.DESPAWN);
	}
	
	private void validateState(Position position, CharacterContext context) {
		if (!(position.isCanGoLeft() || position.isCanGoRight())) {
			context.changeState(new AttackPreDashState());
		}
	}
	
	@Override
	public void start(CharacterContext context) {
		initCharacter(context);
		position = new Position(context);
		validateState(position, context);
	}

	@Override
	public void update(CharacterContext context) {
		if (context.getAnimationCycleCount() > 0) {
			context.getPos().setX(position.getNextSpawnPositionX());
			context.changeState(new SpawnState());
		}
	}

	public Position getPosition() {
		return position;
	}	
	
}