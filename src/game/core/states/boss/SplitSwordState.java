package game.core.states.boss;

import java.util.Random;

import game.core.constants.BossStateEnum;
import game.core.constants.Vector;
import game.core.interfaces.CharacterContext;

/*
 * Smell Code : Dead Code
 * Reason     : Method exit dari interface BossState tidak pernah dipakai
 * Smell      : Delete Dead Code
 */

/*
 * Smell Code : Long Method
 * Reason     : Sebuah method memiliki terlalu banyak tanggung jawab
 * Smell      : Extract Method
 */

public class SplitSwordState implements BossState{

  private int shouldSpinAttack;
  @Override
  public void start(CharacterContext context) {
    Random rand = new Random();
    this.shouldSpinAttack = rand.nextInt(5);
    context.setAnimation(BossStateEnum.IDLE | BossStateEnum.SPLIT_SWORD);
  }

  @Override
  public void update(CharacterContext context) {
    
    if(context.getAnimationCycleCount() > 0) { 
      if(shouldSpinAttack < 1) context.changeState(new AttackSpinState());
      else context.changeState(new AttackPreDashState());
    }
    
  }

  @Override
  public void exit(CharacterContext context) {
    // TODO Auto-generated method stub
    
  }

}
