package id.ac.binus.solutionOOP.core.interfaces;

import id.ac.binus.solutionOOP.controllers.Direction;

public interface VectorMotion {
  public void addForce(double force, Direction direction);
  public Direction getDirection();
}