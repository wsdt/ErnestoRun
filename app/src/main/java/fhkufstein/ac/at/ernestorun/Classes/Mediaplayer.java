package fhkufstein.ac.at.ernestorun.Classes;

import android.content.Context;
import android.media.MediaPlayer;


public class Mediaplayer {
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private int music_position = 0;

    public Mediaplayer (Context context, int soundFile) {
        this.setMediaPlayer(MediaPlayer.create(context,soundFile));
        this.getMediaPlayer().setLooping(true);
    }

    public void startMusik() {
        this.getMediaPlayer().start();
    }

    public void pauseMusik() {
        getMediaPlayer().pause();
        setMusic_position(getMediaPlayer().getCurrentPosition());
    }
    public void resumeMusik() {
        getMediaPlayer().start();
        getMediaPlayer().seekTo(getMusic_position());
    }
    public void stopMusik() {
        getMediaPlayer().stop();
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public int getMusic_position() {
        return music_position;
    }

    public void setMusic_position(int music_position) {
        this.music_position = music_position;
    }
}
