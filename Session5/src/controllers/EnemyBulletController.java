package controllers;

import controllers.Behaviors.DownFlyBehavior;
import controllers.Behaviors.FlyBehavior;
import models.Bullet;
import models.EnemyBullet;
import models.GameObject;
import models.Plane;
import utils.Utils;
import views.GameView;

/**
 * Created by apple on 10/16/16.
 */
public class EnemyBulletController extends SingleController implements Contactable {
    private static final int SPEED = 3;
    private static final int DAMAGE = 20;

    private FlyBehavior flyBehavior;

    public EnemyBulletController(GameObject gameObject, GameView gameView, FlyBehavior flyBehavior) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);
        this.flyBehavior = flyBehavior;
    }

    @Override
    public void run() {
        super.run();
        flyBehavior.doFly(gameObject,SPEED);

    }



    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof PlaneController){
            ((PlaneController) contactable).takedDamage(DAMAGE);
        }
    }

    public static EnemyBulletController create(GameObject gameObject, FlyBehavior flyBehavior){
        EnemyBulletController bulletController = new EnemyBulletController(
                new EnemyBullet(gameObject.getMiddleX() - EnemyBullet.BULLET_WIDTH / 2, gameObject.getBottom()),
                new GameView(Utils.loadImageFromRes("enemy_bullet.png")),
                flyBehavior
                );
        return bulletController;
    }
    public static EnemyBulletController create(GameObject gameObject){
        return create(gameObject,new DownFlyBehavior());
    }
}
