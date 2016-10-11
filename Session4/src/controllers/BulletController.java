package controllers;

import models.Bullet;
import models.GameObject;
import views.GameView;

/**
 * Created by apple on 10/9/16.
 */
public class BulletController extends GameController {

    public static final int SPEED = 10;

    public BulletController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
    }


    public void run() {
        gameObject.move(0, -SPEED);
    }
}
