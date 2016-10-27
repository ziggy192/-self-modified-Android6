package controllers;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nghia on 10/26/2016.
 */
public class BackgroundMusicPlayer implements Runnable {

    AudioInputStream audioIn =null;
    Clip clip = null;

    public BackgroundMusicPlayer() {
    }

    public void start(String audioUrl){
        File soundFile = new File(audioUrl);
        try {
            if (clip!= null && clip.isRunning()) {
                clip.stop();
                clip.setFramePosition(0);
                System.out.println("change");
            }
            audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }



    public void run(){
        if (clip != null)
            if (clip.getFramePosition() == clip.getFrameLength()){
                clip.stop();
                clip.setFramePosition(0);
                clip.start();
            }
    }
}
