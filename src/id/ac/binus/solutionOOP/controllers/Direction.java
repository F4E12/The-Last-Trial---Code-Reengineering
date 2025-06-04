package id.ac.binus.solutionOOP.controllers;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    X(1),
    Y(-1);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
