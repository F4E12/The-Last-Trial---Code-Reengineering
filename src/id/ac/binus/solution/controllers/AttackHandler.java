package id.ac.binus.solution.controllers;

import java.util.Random;

import id.ac.binus.solution.camera.PaneObserver;
import id.ac.binus.solution.core.interfaces.CharacterContext;
import id.ac.binus.solution.managers.GameManager;

public class AttackHandler {
    private static final int PLAYER_ID = 0;
	private static final int ENEMY_ID = 1;

	private static GameManager gm = GameManager.getInstance();
	private static Random rand = new Random();

	public static boolean attack(int attackerId, int targetId, int damage) {
		CharacterContext attacker = gm.getContext(attackerId);
		CharacterContext target = gm.getContext(targetId);

		if (isHit(attacker, target) && !target.isInvincible()) {
			applyAttackEffects(attacker, target, targetId, damage);
			return true;
		}
		return false;
	}

	private static boolean isHit(CharacterContext attacker, CharacterContext target) {
		BoundingBox attackerBox = new BoundingBox(attacker);
		BoundingBox targetBox = new BoundingBox(target);
		return attackerBox.intersects(targetBox);
	}

	private static void applyAttackEffects(CharacterContext attacker, CharacterContext target, int targetId, int damage) {
		gm.playGameSound(rand.nextInt(3));
		target.updateHealth(-damage);

		if (targetId == ENEMY_ID) {
			PaneObserver.getInstance().notifyEnemyListeners();
		} else if (targetId == PLAYER_ID) {
			target.addForce(60 * attacker.getDirection().getValue(), Direction.X);
			PaneObserver.getInstance().notifyPlayerListeners();
		}
	}
}
