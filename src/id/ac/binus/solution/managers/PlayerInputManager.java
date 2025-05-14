package id.ac.binus.solution.managers;

import id.ac.binus.solution.core.constants.PlayerStateEnum;
import id.ac.binus.solution.core.models.Player;
import javafx.scene.input.KeyCode;

public class PlayerInputManager {
    private final Input input = Input.getInstance();

    public void handleInput(Player player, PlayerCombatManager combatManager) {
        if (input.getKey(KeyCode.SPACE)) {
            if (combatManager.canAttack(player)) {
                combatManager.performAttack(player);
                return;
            }
        }

        if (player.hasState(PlayerStateEnum.ATTACKING)) return;

        if (player.getRb().getDelta().getY() > 0) {
            player.setState(PlayerStateEnum.FALLING);
            return;
        }

        if (input.getKey(KeyCode.W) && !player.hasState(PlayerStateEnum.FALLING)) {
            player.addState(PlayerStateEnum.JUMPING);
        } else {
            player.removeState(PlayerStateEnum.JUMPING);
        }

        if (input.getKey(KeyCode.A) || input.getKey(KeyCode.D)) {
            player.setState(PlayerStateEnum.WALKING);
        } else {
            player.setState(PlayerStateEnum.IDLE);
        }
    }
}
