package id.ac.binus.solution.core.models;

public class Vector2D {
	
	private double x;
	private double y;

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(double x, double y) {
    this.x += x;
    this.y += y;
  }

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void updateX(double x) {
		this.x += x;
	}
	
	public void updateY(double y) {
		this.y += y;
	}

	public void clampToRange(Vector2D min, Vector2D max) {
		this.x = Math.max(min.getX(), Math.min(this.x, max.getX()));
		this.y = Math.max(min.getY(), Math.min(this.y, max.getY()));
	}

	public Vector2D negate() {
		return new Vector2D(-this.x, -this.y);
	}

	
}
