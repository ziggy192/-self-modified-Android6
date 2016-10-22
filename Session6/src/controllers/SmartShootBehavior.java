package controllers;

import models.EnemyBullet;
import models.GameObject;
import utils.Utils;
import views.GameView;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nghia on 10/22/2016.
 */
public class SmartShootBehavior implements ShootBehavior {

    private static final int SPEED = 5;

    GameObject planeGameObject;

    public SmartShootBehavior(GameObject planeGameObject) {
        this.planeGameObject = planeGameObject;
    }

    @Override
    public void doShoot(GameObject gameObject, ControllerManager bulletControllerManager) {
//        BufferedImage image = Utils.loadImageFromRes("enemy_bullet.png");
//        Utils.rotateImage(image,90);


        EnemyBulletController enemyBulletController = new EnemyBulletController(
                new EnemyBullet(gameObject.getX(), gameObject.getY()),
                new GameView(Utils.loadImageFromRes("enemy_bullet.png")),
                new SmartFlyBehavior(gameObject,planeGameObject,SPEED)
        );

        bulletControllerManager.add(enemyBulletController);
    }
}
