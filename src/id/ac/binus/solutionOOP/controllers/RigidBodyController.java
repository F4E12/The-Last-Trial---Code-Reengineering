package id.ac.binus.solutionOOP.controllers;

import id.ac.binus.solutionOOP.core.interfaces.VectorMotion;
import id.ac.binus.solutionOOP.core.models.Vector2D;
import id.ac.binus.solutionOOP.core.physics.RigidBody;

public abstract class RigidBodyController implements VectorMotion {

  protected RigidBody rb;
  public abstract void update(Vector2D pos);
  
  protected RigidBodyController(RigidBody rb) {
    this.rb = rb;
  }
}
