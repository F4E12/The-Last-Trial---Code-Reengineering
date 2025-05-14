package id.ac.binus.solution.core.states.boss;

import id.ac.binus.solution.controllers.AttackHandler;
import id.ac.binus.solution.core.constants.BossStateEnum;
import id.ac.binus.solution.core.constants.Vector;
import id.ac.binus.solution.core.interfaces.CharacterContext;

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

/*
 * Smell Code : Data Class
 * Reason     : Atribut sudah diencapsulate tapi belum ada getter
 * Smell      : Getter 
 */

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
				int force = 20 * (context.getDirection()*-1);
				context.addForce(force, Vector.X);
				
				context.changeState(new SplitSwordState());
			} else {
				context.changeState(new IdleDespawnState());
			}
		}
	}

	public Boolean getHasAttacked() {
		return hasAttacked;
	}
	
}
