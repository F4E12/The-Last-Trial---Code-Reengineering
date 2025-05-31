package id.ac.binus.solution.core.interfaces;

import id.ac.binus.solution.controllers.Direction;

public interface VectorMotion {
  public void addForce(double force, Direction direction);
  public Direction getDirection();
}