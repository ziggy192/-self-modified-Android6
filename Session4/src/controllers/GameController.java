package controllers;
import java.awt.*;
import models.GameObject;
import views.GameView;

/**
 * Created by apple on 10/11/16.
 */
public class GameController {
    private GameView gameView;
    protected GameObject gameObject;

    public GameController(GameObject gameObject, GameView gameView) {
        this.gameView = gameView;
        this.gameObject = gameObject;
    }

    public void draw(Graphics g) {
        gameView.drawImage(g, gameObject);
    }
}
