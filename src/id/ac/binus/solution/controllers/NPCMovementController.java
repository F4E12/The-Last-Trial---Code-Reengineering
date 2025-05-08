package id.ac.binus.solution.controllers;

import game.controllers.RigidBodyController;
import game.core.constants.Vector;
import game.core.models.Vector2D;
import game.core.physics.RigidBody;

/*
 * Smell Code : Primitive Obsession
 * Reason     : Using integer to store direction
 * Treatment  : Extract variable to enum
 */

/*
 * Smell Code : Comment
 * Reason     : Existed comment in void update to explain the method
 * Treatment  : Remove comment
 */

public class NPCMovementController extends RigidBodyController {
  private Vector direction;

  public NPCMovementController(RigidBody rb) {
    super(rb);
    this.direction = Vector.LEFT;
  }

  @Override
  public void update(Vector2D pos) {
    rb.update(pos);
  }

  @Override
  public void addForce(double force, int direction) {
    if(direction ==  Vector.X) {
      rb.getVelocity().updateX(force);
    }
    else if(direction == Vector.Y) {
      rb.getVelocity().updateY(force);
    }
  }
  
  @Override
  public Vector getDirection() {
    return this.direction;
  }
  
  public void setDirection(int direction) {
    this.direction = direction;
  }
}
