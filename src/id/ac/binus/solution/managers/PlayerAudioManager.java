package id.ac.binus.solution.managers;

import id.ac.binus.solution.controllers.AudioController;
import id.ac.binus.solution.core.audio.Audio;
import id.ac.binus.solution.core.audio.IAudio;
import id.ac.binus.solution.core.constants.PlayerStateEnum;

public class PlayerAudioManager {
    private final AudioController audioController = new AudioController();

    public PlayerAudioManager() {
        audioController.addAudio(PlayerStateEnum.JUMPING, new Audio("src/assets/audio/sfx/jump.wav"));
        audioController.addAudio(PlayerStateEnum.ATTACKING, new Audio("src/assets/audio/sfx/swordswing1.wav"));
    }

    public void play(int state) {
        audioController.setCurrentSound(state);
    }

    public IAudio getCurrentSound() {
        return audioController.getCurrentSound();
    }
}
