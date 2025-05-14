package id.ac.binus.solution.core.models;

public class Enemy extends Character{
	
	public Enemy(int health, Vector2D pos, int scale) {
		super(new CharacterAttributes(
		health,
		pos,
		scale,
		new Hitbox(new Vector2D(120, 0), new Vector2D(120 * (scale - 1), 120 * (scale - 1)))
		), new Vector2D(100, 50));
	}
}