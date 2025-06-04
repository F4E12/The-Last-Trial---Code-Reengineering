package id.ac.binus.solutionOOP.core.states.boss;

import id.ac.binus.solutionOOP.core.constants.BossStateEnum;
import id.ac.binus.solutionOOP.controllers.Direction;
import id.ac.binus.solutionOOP.core.interfaces.CharacterContext;

public class AttackPreDashState implements BossState{

  private void initCharacter(CharacterContext context) {
	    context.setAnimation(BossStateEnum.ATTACK | BossStateEnum.PRE_DASH);
	    context.setInvincible(false);
  }
	
  @Override
  public void start(CharacterContext context) {
	  initCharacter(context);
  }

  @Override
  public void update(CharacterContext context) {
	int force = 2 * (context.getDirection().getValue() * -1);
    context.addForce(force, Direction.X);
    
    int cycleCount = context.getAnimationCycleCount();
    if(cycleCount > 0 ) {
      context.changeState(new AttackDashState());
    }
  }

}
