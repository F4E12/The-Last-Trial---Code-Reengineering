package id.ac.binus.solution.managers;

import id.ac.binus.solution.controllers.NPCMovementController;
import game.core.models.Vector2D;
import game.core.physics.RigidBody;

public class EnemyMovementManager {
    private NPCMovementController movementController;

    public EnemyMovementManager(RigidBody rb) {
        this.movementController = new NPCMovementController(rb);
    }

    public void update(Vector2D pos) {
        movementController.update(pos);
    }

    public void addForce(double force, int direction) {
        movementController.addForce(force, direction);
    }

    public Vector2D getDirection() {
        return movementController.getDirection();
    }

    public void setDirection(int direction) {
        movementController.setDirection(direction);
    }
}