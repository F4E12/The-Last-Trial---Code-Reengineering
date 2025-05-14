package game.core.models;

import game.core.physics.RigidBody;

/*
 * Smell Code : Duplicate Code
 * Reason     : Both Player and Enemy redeclare RigidBody rb, even though it's already present (and unused) in the base Character class.
 * Treatment  : Move method
 */

 /*
  * Smell Code : Speculative Generality 
  * Reason     : Enemy class is a subclass of Character, but it doesn't implement any methods that are declared in Character.
  * Treatment  : Remove method
  */

public class Enemy extends Character{
	private RigidBody rb;
	
	public Enemy(int health, Vector2D pos, int scale) {
	  super(
	      health,
	      pos, 
	      new Vector2D[] {
	          new Vector2D(120, 0), // bottom left
	          new Vector2D(120 * (scale-1), 120 * (scale-1)) // top right
	          },
	      scale
	    );
		this.rb = new RigidBody(new Vector2D(100, 50));
		
	}
	
	@Override
	public void spawn() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	public RigidBody getRb() {
	  return this.rb;
	}

}