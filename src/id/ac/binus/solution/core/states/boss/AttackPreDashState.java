package id.ac.binus.solution.core.states.boss;

import id.ac.binus.solution.core.constants.BossStateEnum;
import id.ac.binus.solution.core.constants.Vector;
import id.ac.binus.solution.core.interfaces.CharacterContext;

/*
 * Smell Code : Dead Code
 * Reason     : Method exit dari interface BossState tidak pernah dipakai
 * Smell      : Delete Dead Code
 */

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
	int force = 2 * (context.getDirection() * -1);
    context.addForce(force, Vector.X);
    
    int cycleCount = context.getAnimationCycleCount();
    if(cycleCount > 0 ) {
      context.changeState(new AttackDashState());
    }
  }

}
