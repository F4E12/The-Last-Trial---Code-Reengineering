package id.ac.binus.solutionOOP.managers;

import id.ac.binus.solutionOOP.controllers.AudioController;
import id.ac.binus.solutionOOP.controllers.AudioState;
import id.ac.binus.solutionOOP.core.audio.Audio;
import id.ac.binus.solutionOOP.core.audio.IAudio;

public class PlayerAudioManager {
    private final AudioController audioController = new AudioController();

    public PlayerAudioManager() {
        audioController.addAudio(AudioState.JUMP.getValue(), new Audio("src/assets/audio/sfx/jump.wav"));
        audioController.addAudio(AudioState.ATTACK.getValue(), new Audio("src/assets/audio/sfx/swordswing1.wav"));
    }

    public void play(int state) {
        audioController.setCurrentSound(state);
    }

    public IAudio getCurrentSound() {
        return audioController.getCurrentSound();
    }
}
