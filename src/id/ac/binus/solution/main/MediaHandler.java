package id.ac.binus.solution.main;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class MediaHandler {
    private MediaPlayer backgroundMusic;
    private MediaPlayer videoBackground;

    public void loadAndPlayBackgroundMusic(String path) {
        Media media = new Media(getClass().getResource(path).toExternalForm());
        backgroundMusic = new MediaPlayer(media);
        backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundMusic.setVolume(1);
        backgroundMusic.play();
    }

    public void loadVideoBackground(String videoPath) {
        File file = new File(videoPath);
        Media media = new Media(file.toURI().toString());
        videoBackground = new MediaPlayer(media);
        videoBackground.setCycleCount(MediaPlayer.INDEFINITE);
        videoBackground.play();
    }

    public MediaView getMediaView() {
        return new MediaView(videoBackground);
    }
}
