package controllers.managers;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.peer.MouseInfoPeer;

/**
 * Created by Nhan on 10/25/2016.
 */
public abstract class GameScreen implements MouseListener, KeyListener, MouseMotionListener  {
    protected ScreenManager screenManager;
    public GameScreen(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public abstract void run();
    public abstract void update(Graphics graphics);
    public abstract String getBackgroundMusic();
}
