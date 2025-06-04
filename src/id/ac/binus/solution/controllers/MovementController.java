package id.ac.binus.solution.controllers;

import id.ac.binus.solution.core.models.Vector2D;
import id.ac.binus.solution.core.physics.PhysicsEngine;
import id.ac.binus.solution.core.physics.RigidBody;
import id.ac.binus.solution.managers.Input;
import javafx.scene.input.KeyCode;

public class MovementController extends RigidBodyController {
    private static final int DEFAULT_ACCELERATION = 5;
    private static final double DEFAULT_JUMP_STRENGTH = 40.0;

    private final int acceleration;
    private final double jumpStrength;
    private final Input input;
    private Direction direction;

    public MovementController(RigidBody rb) {
        super(rb);
        this.acceleration = DEFAULT_ACCELERATION;
        this.jumpStrength = DEFAULT_JUMP_STRENGTH;
        this.input = Input.getInstance();
        this.direction = Direction.LEFT;
    }

    private void handleHorizontalMovement() {
        if (input.getKey(KeyCode.A)) {
            rb.getVelocity().updateX(-acceleration);
            direction = Direction.LEFT;
        } else if (input.getKey(KeyCode.D)) {
            rb.getVelocity().updateX(acceleration);
            direction = Direction.RIGHT;
        }
    }

    private void handleJumping(Vector2D pos) {
        if (input.getKey(KeyCode.W) && pos.getY() >= PhysicsEngine.getGroundBoundary()) {
            rb.getVelocity().setY(-jumpStrength);
        }
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void addForce(double force, Direction direction) {
        if (direction == Direction.X) {
            rb.getVelocity().updateX(force);
        } else if (direction == Direction.Y) {
            rb.getVelocity().updateY(force);
        }
    }

    @Override
    public void update(Vector2D pos) {
        handleHorizontalMovement();
        handleJumping(pos);
        rb.update(pos);
    }
}
