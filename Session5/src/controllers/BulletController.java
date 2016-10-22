package controllers;

import models.Bullet;
import models.GameObject;
import utils.Utils;
import views.GameView;

/**
 * Created by apple on 10/9/16.
 */
public class BulletController extends SingleController implements Contactable {

    public static final int SPEED = 10;

    public BulletController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);
    }

    @Override
    public void run() {
        gameObject.move(0, -SPEED);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof EnemyPlaneController) {
            ((EnemyPlaneController) contactable).destroy();
        }
    }

    public static BulletController create(GameObject gameObject){
        BulletController bulletController = new BulletController(
                new Bullet(gameObject.getMiddleX(), gameObject.getY()),
                new GameView(Utils.loadImageFromRes("bullet.png"))
        );
        return bulletController;
    }
}
