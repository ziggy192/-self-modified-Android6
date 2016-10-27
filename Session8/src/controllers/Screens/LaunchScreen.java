package controllers.Screens;

import controllers.managers.GameScreen;
import controllers.managers.ScreenManager;
import models.GameConfig;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Nhan on 10/25/2016.
 */
public class LaunchScreen extends GameScreen {

    private static final String backgroundMusic = "resources/launcher_music.wav";

    private final Image backgroundImage = Utils.loadImageFromRes("launch_screen.png");
    public LaunchScreen(ScreenManager screenManager) {
        super(screenManager);
    }


    @Override
    public String getBackgroundMusic(){
        return backgroundMusic;
    }

    @Override
    public void run() {

    }

    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(
                backgroundImage,
                0,
                0,
                GameConfig.instance.getScreenWidth(),
                GameConfig.instance.getScreenHeight(),
                null
        );
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            this.screenManager.change(
                    new PlayGameScreen(screenManager),
                    true
            );

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
