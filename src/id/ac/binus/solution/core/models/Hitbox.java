package id.ac.binus.solution.core.models;

public class Hitbox {
    private final Vector2D bottomLeft;
    private final Vector2D topRight;

    public Hitbox(Vector2D bottomLeft, Vector2D topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Vector2D[] asArray() {
        return new Vector2D[]{bottomLeft, topRight};
    }
}
