package id.ac.binus.solution.core.models;

import id.ac.binus.solution.core.physics.RigidBody;

public abstract class Character {
	private int health;
	private Vector2D pos;
	private Hitbox hitbox;
	private final int scale;
	private boolean invincible;
	private final RigidBody rb;

	protected Character(CharacterAttributes attr, Vector2D terminalVelocity) {
		this.health = attr.health;
		this.pos = attr.pos;
		this.hitbox = attr.hitbox;
		this.scale = attr.scale;
		this.invincible = false;
		this.rb = new RigidBody(terminalVelocity);
	}

	public RigidBody getRigidBody() {
		return this.rb;
	}

	public Vector2D[] getHitboxArray() {
		return hitbox.asArray();
	}

	public Vector2D getPos() {
		return this.pos;
	}

	public void setPos(Vector2D pos) {
		this.pos = pos;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void updateHealth(int delta) {
		this.health += delta;
	}

	public int getScale() {
		return this.scale;
	}

	public boolean isInvincible() {
		return invincible;
	}

	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}
}
