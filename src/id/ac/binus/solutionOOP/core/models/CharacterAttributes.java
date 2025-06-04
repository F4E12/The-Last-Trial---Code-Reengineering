package id.ac.binus.solutionOOP.core.models;

public class CharacterAttributes {
    public final int health;
    public final Vector2D pos;
    public final int scale;
    public final Hitbox hitbox;

    public CharacterAttributes(int health, Vector2D pos, int scale, Hitbox hitbox) {
        this.health = health;
        this.pos = pos;
        this.scale = scale;
        this.hitbox = hitbox;
    }
}
