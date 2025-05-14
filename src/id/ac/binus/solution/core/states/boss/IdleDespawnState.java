package id.ac.binus.solution.core.states.boss;

import java.util.Random;

import id.ac.binus.solution.core.constants.BossStateEnum;
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

/*
 * Smell Code : Primitive Obssesion
 * Reason     : Developer memakai primitive data type untuk atribut yang 
 *              bisa dibikin object
 * Smell      : Extract Class
 */

/*
 * Smell Code : Data Clumps
 * Reason     : Sekumpulan variable/attribute memiliki identical groups 
 *              sehingga dapat dikelompokkan dalam satu class
 * Smell      : Extract Class
 */

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