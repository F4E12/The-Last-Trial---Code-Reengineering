package id.ac.binus.solutionOOP.core.states.boss;

import java.util.Random;

import id.ac.binus.solutionOOP.core.constants.BossStateEnum;
import id.ac.binus.solutionOOP.core.interfaces.CharacterContext;

public class IdleState implements BossState {

  private Integer targetCycles;
  private Integer mode;

  public IdleState() {
	  Random rand =  new Random();
	  this.targetCycles = rand.nextInt(2); 
	  this.mode = rand.nextInt(2);
  }

  private void initCharacter(CharacterContext context) {
	    context.setAnimation(BossStateEnum.IDLE);
	    context.setInvincible(false);
  }
  @Override
  public void start(CharacterContext context) {
	  initCharacter(context);
  }

  @Override
  public void update(CharacterContext context) {
    if(mode == 0) {
      context.changeState(new IdleDespawnState());
    }else {
    	if (context.getAnimationCycleCount() >= targetCycles) {
    		context.changeState(new SplitSwordState());
    	}
    }
  }

	public Integer getTargetCycles() {
		return targetCycles;
	}
	
	public Integer getMode() {
		return mode;
	}

}