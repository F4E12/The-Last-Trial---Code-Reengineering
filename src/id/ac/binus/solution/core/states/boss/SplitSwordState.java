package id.ac.binus.solution.core.states.boss;

import java.util.Random;

import id.ac.binus.solution.core.constants.BossStateEnum;
import id.ac.binus.solution.core.interfaces.CharacterContext;

public class SplitSwordState implements BossState{

  private Integer shouldSpinAttack;
  private Random rand = new Random();
  
  private void initCharacter(CharacterContext context) {
	  context.setAnimation(BossStateEnum.IDLE | BossStateEnum.SPLIT_SWORD);
  }
  
  @Override
  public void start(CharacterContext context) {
    this.shouldSpinAttack = rand.nextInt(5);
    initCharacter(context);
  }

  @Override
  public void update(CharacterContext context) {
	  if(context.getAnimationCycleCount() > 0) { 
		  if(shouldSpinAttack < 1) {
			  context.changeState(new AttackSpinState());
		  } else {
			  context.changeState(new AttackPreDashState());
		  }
	  } 
  }

	public Integer getShouldSpinAttack() {
		return shouldSpinAttack;
	}
	
	public Random getRand() {
		return rand;
	}
  

}
