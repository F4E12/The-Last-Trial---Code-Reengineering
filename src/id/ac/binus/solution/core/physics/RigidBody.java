package id.ac.binus.solution.core.physics;

import id.ac.binus.solution.core.models.Vector2D;

public class RigidBody {

  private id.ac.binus.solution.core.models.Vector2D velocity;
  private Vector2D delta;
  private final Vector2D terminalVelocity;
  private final PhysicsEngine physics;

  public RigidBody(Vector2D terminalVelocity) {
    this.velocity = new Vector2D(0, 0);
    this.delta = new Vector2D(0, 0);
    this.terminalVelocity = terminalVelocity;
    this.physics = PhysicsEngine.getInstance();
  }

  public void update(Vector2D pos) {
    physics.applyFriction(velocity);
    physics.applyGravity(velocity);

    velocity.clampToRange(terminalVelocity.negate(), terminalVelocity);
    delta.set(velocity.getX(), velocity.getY());

    physics.applyBoundaryLimits(pos, delta);
    pos.update(delta.getX(), delta.getY());
  }

  public Vector2D getVelocity() {
    return velocity;
  }

  public void setVelocity(Vector2D velocity) {
    this.velocity = velocity;
  }

  public Vector2D getDelta() {
    return delta;
  }
}
