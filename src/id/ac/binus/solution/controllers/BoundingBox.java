package id.ac.binus.solution.controllers;

import game.core.interfaces.CharacterContext;

public class BoundingBox {
    private double left, bottom, right, top;

    public BoundingBox(CharacterContext character) {
        this.left = character.getPos().getX() + character.getHitbox()[0].getX();
        this.bottom = character.getPos().getY() + character.getHitbox()[0].getY();
        this.right = character.getPos().getX() + character.getHitbox()[1].getX();
        this.top = character.getPos().getY() + character.getHitbox()[1].getY();
    }

    public boolean intersects(BoundingBox other) {
        return this.left < other.right && this.right > other.left &&
               this.bottom < other.top && this.top > other.bottom;
    }

    public double getLeft() {
        return left;
    }

    public double getBottom() {
        return left;
    }

    public double getRight() {
        return left;
    }

    public double getTop() {
        return left;
    }
}
