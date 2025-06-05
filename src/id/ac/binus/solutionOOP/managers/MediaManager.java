package id.ac.binus.solutionOOP.managers;

import id.ac.binus.solutionOOP.config.Config;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaManager {
    private final MediaPlayer backgroundMusic;
    private final MediaPlayer videoPlayer;
    private final MediaView mediaView;

    public MediaManager() {
        Media bgMusicMedia = new Media(getClass().getResource(Config.BG_MUSIC_PATH).toExternalForm());
        backgroundMusic = new MediaPlayer(bgMusicMedia);
        backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundMusic.setVolume(1);

        Media videoMedia = new Media(new java.io.File(Config.BATTLE_BG_VIDEO).toURI().toString());
        videoPlayer = new MediaPlayer(videoMedia);
        mediaView = new MediaView(videoPlayer);
        mediaView.setFitWidth(Config.CANVAS_WIDTH);
        mediaView.setFitHeight(Config.CANVAS_HEIGHT);
        mediaView.setPreserveRatio(true);
        mediaView.setTranslateY(-50);

        videoPlayer.setOnError(() -> System.out.println("Error loading media: " + videoPlayer.getError().getMessage()));
        videoPlayer.setOnReady(videoPlayer::play);
    }

    public void play() {
        backgroundMusic.play();
        videoPlayer.play();
    }

    public MediaView getMediaView() {
        return mediaView;
    }
}