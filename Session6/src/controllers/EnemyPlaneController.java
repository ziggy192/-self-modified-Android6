package controllers;

import models.*;
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
    private ShootBehavior shootBehavior;

    private GameObject planeGameObject;

    public EnemyPlaneController(GameObject gameObject, GameView gameView,
                                FlyBehavior flyBehavior,
                                ShootBehavior shootBehavior) {
        super(gameObject, gameView);
        this.flyBehavior = flyBehavior;
        this.shootBehavior = shootBehavior;

        butletControllerManager = new ControllerManager();
        CollisionPool.instance.register(this);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        butletControllerManager.draw(g);
    }




    @Override
    public void run() {
        // Fly
        // Needs game object
        //gameObject.move(0, SPEED);
        if(flyBehavior != null) {
            this.flyBehavior.doFly(this.gameObject);
            this.flyBehavior = this.flyBehavior.newDirectionIfNeeded(this.gameObject);

        }
        // End Fly


        // Shot
        // Needs: count, butletControllerManager
        count++;
        if (GameConfig.instance.getSeconds(count) > 1) {
            count = 0;
            if (shootBehavior != null) {
                shootBehavior.doShoot(this.gameObject, this.butletControllerManager);
            }
//            EnemyBulletController bulletController = new EnemyBulletController(
//                    new Bullet(gameObject.getMiddleX() - Bullet.BULLET_WIDTH / 2, gameObject.getBottom()),
//                    new GameView(Utils.loadImageFromRes("enemy_bullet.png")
//                    ));
//            butletControllerManager.add(bulletController);
        }
        // End Shot

        butletControllerManager.run();
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof BulletController) {
            ((BulletController) contactable).destroy();
        }
    }

    public static EnemyPlaneController create(int x, int y, EnemyPlaneType type,GameObject planeGameObject) {

        Image image = null;
        FlyBehavior flyBehavior = null;
        ShootBehavior shootBehavior = null;
        EnemyPlane enemyPlane = new EnemyPlane(x,y);
        if (type == EnemyPlaneType.GRAY) //Gray
        {
            image = Utils.loadImageFromRes("plane1.png");
            flyBehavior = new DownFlyBehavior(1);
            shootBehavior = new DownShootBehavior();
        } else if (type == EnemyPlaneType.RED) // Red
        {
            image = Utils.loadImageFromRes("plane2.png");
            flyBehavior = new DownRightFlyBehavior(SPEED);
        }
            else if(type == EnemyPlaneType.YELLOW) {
            image = Utils.loadImageFromRes("enemy_plane_yellow_3.png");
            flyBehavior= new DownLeftFlyBehavior(SPEED);
            shootBehavior = new SmartShootBehavior(planeGameObject);


        }

        return new EnemyPlaneController(
                enemyPlane,
                new GameView(image),
                flyBehavior,
                shootBehavior);
    }

    public static EnemyPlaneController create(int x, int y, EnemyPlaneType type){
        return create(x,y,type,null);
    }
}
