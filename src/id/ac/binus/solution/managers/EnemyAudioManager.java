package id.ac.binus.solution.managers;

import id.ac.binus.solution.controllers.AudioController;
import id.ac.binus.solution.core.audio.Audio;
import id.ac.binus.solution.core.audio.IAudio;
import id.ac.binus.solution.core.constants.BossStateEnum;

public class EnemyAudioManager {
    private AudioController audioController;

    public EnemyAudioManager() {
        this.audioController = new AudioController();
        initializeAudio();
    }

    public void initializeAudio() {
		audioController.addAudio(BossStateEnum.DESPAWN, new Audio("src/assets/audio/sfx/boss_disappear.wav", 0.1f));
		audioController.addAudio(BossStateEnum.ATTACK | BossStateEnum.DASH,
				new Audio("src/assets/audio/sfx/boss_dash.wav"));
		audioController.addAudio(BossStateEnum.SPAWN | BossStateEnum.LEVITATE,
				new Audio("src/assets/audio/sfx/boss_reappear.wav"));
		audioController.addAudio(BossStateEnum.LEVITATE, new Audio("src/assets/audio/sfx/boss_flame.wav"));
		audioController.addAudio(BossStateEnum.SPIN | BossStateEnum.ATTACK,
				new Audio("src/assets/audio/sfx/boss_spin.wav", 0.6));
	}


    public IAudio getCurrentSound() {
        return audioController.getCurrentSound();
    }

    public void setCurrentSound(int id) {
        audioController.setCurrentSound(id);
    }
}
