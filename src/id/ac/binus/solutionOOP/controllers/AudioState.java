package id.ac.binus.solutionOOP.controllers;

public enum AudioState {
    BACKGROUND_MUSIC(0),
    JUMP(1),
    ATTACK(2),
    DEATH(3);

    private final int value;

    AudioState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

