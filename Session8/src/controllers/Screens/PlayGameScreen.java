package controllers.Screens;

import controllers.GiftController;
import controllers.PlaneController;
import controllers.managers.*;
import models.GameConfig;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Nhan on 10/25/2016.
 */
public class PlayGameScreen extends GameScreen {

    private static final String backgroundMusic = "resources/playing_music.wav";

    private Image backgroundImage = null;
    private PlaneController planeController;
    private PlaneController planeController2;
    private ControllerManager controllerManager;


    public PlayGameScreen(ScreenManager screenManager) {
        super(screenManager);
        NotificationCenter.refresh();
        CollisionPool.refresh();
        controllerManager = new ControllerManager();

        planeController = PlaneController.newPlaneController1();
        planeController2 = PlaneController.newPlaneController2();

        controllerManager.add(planeController);
        controllerManager.add(planeController2);
        controllerManager.add(new EnemyPlaneControllerManager());
        controllerManager.add(CollisionPool.instance);
        controllerManager.add(ControllerManager.explosionManager);
        controllerManager.add(GiftController.create(GameConfig.instance.getScreenMiddleX(), 0));
        backgroundImage = Utils.loadImageFromRes("background.png");
    }

    @Override
    public String getBackgroundMusic(){
        return backgroundMusic;
    }
    @Override
    public void run() {

        controllerManager.run();
        if (!planeController.getGameObject().isAlive()
                || !planeController2.getGameObject().isAlive() )
            this.screenManager.change(new GameOverScreen(screenManager),false);
    }

    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(backgroundImage,
                0, 0,
                GameConfig.instance.getScreenWidth(),
                GameConfig.instance.getScreenHeight(), null);
        controllerManager.draw(graphics);
    }
/*----------------------------------------------------------Key Listener -----------------------------------------*/
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        planeController.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        planeController.keyReleased(e);
    }

    /*---------------------------------------------------------- Mouse Listener -----------------------------------------*/
    @Override
    public void mouseClicked(MouseEvent e) {
        planeController2.mouseClicked(e);
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
    /*--------------------------------------------------------- Mouse Motion -----------------------------------------*/
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        planeController2.mouseMoved(e);
    }

}
