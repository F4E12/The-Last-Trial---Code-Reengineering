package id.ac.binus.solution.core.states.boss;

import java.util.Random;

import id.ac.binus.solution.core.interfaces.CharacterContext;

public class Position {
	private final double MIN_DISPLACEMENT = 100f;
	private Double displacement;
	
	private Double currentX;
	private Double maxDLeft;
	private Double maxDRight;
	private Double nextSpawnPositionX;

	private Boolean canGoLeft;
	private Boolean canGoRight;
	
	private Random rand;
	private Double factor;
	
	private void initVariables() {
		rand = new Random();
		factor = (double) (rand.nextInt(10 - 5) + 5) / 10.0f;
	}
	
	private void validateDirection() {
		if (canGoLeft) {
			this.displacement = factor * maxDLeft + MIN_DISPLACEMENT;
			this.nextSpawnPositionX = currentX - displacement;
		} else if (canGoRight) {
			this.displacement = factor * maxDRight + MIN_DISPLACEMENT;
			this.nextSpawnPositionX = currentX + displacement;
		}
	}
	
	public Position(CharacterContext context) {
		initVariables();
		this.currentX = context.getPos().getX();
		this.maxDLeft = this.currentX - 300 - MIN_DISPLACEMENT;
		this.maxDRight = 1300 - this.currentX - MIN_DISPLACEMENT;
		this.canGoLeft = this.maxDLeft >= 0;
		this.canGoRight = this.maxDRight >= 0;
		validateDirection();
	}

	public double getMIN_DISPLACEMENT() {
		return MIN_DISPLACEMENT;
	}

	public Double getDisplacement() {
		return displacement;
	}

	public Double getCurrentX() {
		return currentX;
	}

	public Double getMaxDLeft() {
		return maxDLeft;
	}

	public Double getMaxDRight() {
		return maxDRight;
	}

	public Double getNextSpawnPositionX() {
		return nextSpawnPositionX;
	}

	public Boolean isCanGoLeft() {
		return canGoLeft;
	}

	public Boolean isCanGoRight() {
		return canGoRight;
	}

	public Random getRand() {
		return rand;
	}

	public Double getFactor() {
		return factor;
	}

	
}
