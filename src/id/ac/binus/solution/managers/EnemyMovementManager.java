package id.ac.binus.solution.managers;

import id.ac.binus.solution.controllers.Direction;
import id.ac.binus.solution.controllers.NPCMovementController;
import id.ac.binus.solution.core.models.Vector2D;
import id.ac.binus.solution.core.physics.RigidBody;

public class EnemyMovementManager {
    private NPCMovementController movementController;

    public EnemyMovementManager(RigidBody rb) {
        this.movementController = new NPCMovementController(rb);
    }

    public void update(Vector2D pos) {
        movementController.update(pos);
    }

    public void addForce(double force, Direction direction) {
        movementController.addForce(force, direction);
    }

    public Direction getDirection() {
        return movementController.getDirection();
    }

    public void setDirection(Direction direction) {
        movementController.setDirection(direction);
    }
}