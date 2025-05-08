package id.ac.binus.solution.core.interfaces;

import game.core.audio.IAudio;

public interface AudioBehaviour {
	public IAudio getCurrentSound();

	public void setSound(int soundId);
}
