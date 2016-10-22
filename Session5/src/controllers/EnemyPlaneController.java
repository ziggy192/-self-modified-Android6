package controllers;

import controllers.Behaviors.DownFlyBehavior;
import controllers.Behaviors.FlyBehavior;
import models.Bullet;
import models.GameConfig;
import models.GameObject;
import utils.Utils;
import views.GameView;

import java.awt.*;

/**
 * Created by apple on 10/11/16.
 */
public class EnemyPlaneController extends SingleController implements Contactable {

    private static final int SPEED = 1;

    private ControllerManager butletControllerManager;

    private int count = 0;

    private FlyBehavior flyBehavior;

    public EnemyPlaneController(GameObject gameObject, GameView gameView, FlyBehavior flyBehavior) {
        super(gameObject, gameView);
        butletControllerManager = new ControllerManager();
        CollisionPool.instance.register(this);
        this.flyBehavior=flyBehavior;
    }

    public EnemyPlaneController(GameObject gameObject, GameView gameView) {
        this(gameObject,gameView,new DownFlyBehavior());
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        butletControllerManager.draw(g);
    }


    @Override
    public void run() {
        flyBehavior.doFly(gameObject,SPEED);

        butletControllerManager.run();

        count++;
        if (GameConfig.instance.getSeconds(count)*2 > 1) {
            count = 0;

            //convert into factory design pattern
            EnemyBulletController enemyBulletController = EnemyBulletController.create(gameObject);
            butletControllerManager.add(enemyBulletController);

        }
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof BulletController) {
            ((BulletController) contactable).destroy();
        }
    }
}
