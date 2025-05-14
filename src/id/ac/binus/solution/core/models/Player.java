package id.ac.binus.solution.core.models;

public class Player extends Character {
	private int state;
	private int stamina;

	public Player(int health, Vector2D pos, int state, int scale) {
		super(new CharacterAttributes(
		health,
		pos,
		scale,
		new Hitbox(new Vector2D(60, 0), new Vector2D(60 * scale, 60 * scale))
		), new Vector2D(20, 50));

		this.state = state;
		this.stamina = 1000;
	}

	public void resetState() {
		this.state = 0;
	}

	public void addState(int newState) {
		this.state |= newState;
	}

	public void removeState(int stateToRemove) {
		this.state &= ~stateToRemove;
	}

	public boolean hasState(int checkState) {
		return (this.state & checkState) != 0;
	}

	public boolean hasStateCombination(int requiredStates, int forbiddenStates) {
		return (this.state & requiredStates) == requiredStates && (this.state & forbiddenStates) == 0;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return this.state;
	}

	public void updateStamina(int staminaModifier) {
		if (this.stamina + staminaModifier < 0 || this.stamina + staminaModifier > 1000)
			return;
		this.stamina += staminaModifier;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

}
