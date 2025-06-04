package id.ac.binus.solution.controllers;

import id.ac.binus.solution.core.models.Vector2D;
import id.ac.binus.solution.core.physics.RigidBody;

public class NPCMovementController extends RigidBodyController {
  private Direction direction;

  public NPCMovementController(RigidBody rb) {
    super(rb);
    this.direction = Direction.LEFT;
  }

  @Override
  public void update(Vector2D pos) {
    rb.update(pos);
  }

  @Override
  public void addForce(double force, Direction direction) {
    if(direction ==  Direction.X) {
      rb.getVelocity().updateX(force);
    }
    else if(direction == Direction.Y) {
      rb.getVelocity().updateY(force);
    }
  }
  
  @Override
  public Direction getDirection() {
    return this.direction;
  }
  
  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}
