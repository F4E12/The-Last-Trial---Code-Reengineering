package id.ac.binus.solution.controllers;

import id.ac.binus.solution.core.interfaces.VectorMotion;
import id.ac.binus.solution.core.models.Vector2D;
import id.ac.binus.solution.core.physics.RigidBody;

public abstract class RigidBodyController implements VectorMotion {

  protected RigidBody rb;
  public abstract void update(Vector2D pos);
  
  protected RigidBodyController(RigidBody rb) {
    this.rb = rb;
  }
}
