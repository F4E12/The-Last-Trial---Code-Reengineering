package id.ac.binus.solution.managers;

import game.controllers.AudioController;
import game.core.audio.Audio;
import game.core.interfaces.CharacterContext;
import java.util.HashMap;
import java.util.Map;

public class GameManager {

	private static volatile GameManager instance;
	private Map<Integer, CharacterContext> contexts;
	private AudioController audioController;

	private GameManager() {
		contexts = new HashMap<>();
		audioController = new AudioController();
		initializeGameSounds();
	}

	public static GameManager getInstance() {
		if (instance == null) {
			synchronized (GameManager.class) {
				if (instance == null) {
					instance = new GameManager();
				}
			}
		}
		return instance;
	}

	public void initializeGameSounds() {
		String[] sounds = {
			"src/assets/audio/sfx/player_hurt.wav",
			"src/assets/audio/sfx/player_hurt2.wav",
			"src/assets/audio/sfx/player_hurt3.wav"
		};
		
		for (int i = 0; i < sounds.length; i++) {
			audioController.addAudio(i, new Audio(sounds[i]));
		}
	}

	public void playGameSound(int soundId) {
		audioController.setCurrentSound(soundId);
	}

	public void addContext(Integer id, CharacterContext context) {
		contexts.put(id, context);
	}

	public CharacterContext getContext(Integer id) {
		return contexts.get(id);
	}
}