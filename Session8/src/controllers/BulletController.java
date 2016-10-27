package controllers;

import controllers.managers.CollisionPool;
import models.GameObject;
import views.SingleDrawer;

/**
 * Created by apple on 10/9/16.
 */
public class BulletController extends SingleController implements Contactable {

    public static final int SPEED = 10;

    public BulletController(GameObject gameObject, SingleDrawer singleDrawer) {
        super(gameObject, singleDrawer);
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
}
