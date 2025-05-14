package id.ac.binus.solution.managers;

import id.ac.binus.solution.controllers.AttackHandler;
import id.ac.binus.solution.core.constants.PlayerStateEnum;
import id.ac.binus.solution.core.models.Player;

public class PlayerCombatManager {
    private final int staminaThreshold = 250;
    private final int attackDuration = 12;
    private int attackTimer = 0;

    public void updateAttack(Player player) {
        if (attackTimer > 0) {
            attackTimer--;
            if (attackTimer == 0) {
                player.removeState(PlayerStateEnum.ATTACKING);
            }
        }
    }

    public boolean canAttack(Player player) {
        return attackTimer == 0 && player.getStamina() >= staminaThreshold;
    }

    public void performAttack(Player player) {
        player.addState(PlayerStateEnum.ATTACKING);
        AttackHandler.attack(0, 1, 20);
        attackTimer = attackDuration;
        player.updateStamina(-staminaThreshold);
    }

    public void restoreStamina(Player player) {
        player.updateStamina(5);
    }
}