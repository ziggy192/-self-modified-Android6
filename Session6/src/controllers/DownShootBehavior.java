package controllers;

import models.EnemyBullet;
import models.GameObject;
import utils.Utils;
import views.GameView;

/**
 * Created by apple on 10/18/16.
 */

public class DownShootBehavior implements ShootBehavior {

    private static final int SPEED = 5;

    @Override
    public void doShoot(GameObject gameObject, ControllerManager bulletControllerManager) {

        EnemyBulletController enemyBulletController = new EnemyBulletController(
                new EnemyBullet(gameObject.getX(), gameObject.getY()),
                new GameView(Utils.loadImageFromRes("enemy_bullet.png")),
                new DownFlyBehavior(SPEED)
        );

        bulletControllerManager.add(enemyBulletController);
    }
}
