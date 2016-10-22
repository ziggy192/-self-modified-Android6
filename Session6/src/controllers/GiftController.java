package controllers;

import models.GameObject;
import models.Gift;
import views.GameView;

/**
 * Created by Nghia on 10/22/2016.
 */
public class GiftController extends SingleController implements Contactable{
    private static final int SPEED = 1;

    public GiftController(Gift gameObject, GameView gameView) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);

    }

    @Override
    public void run() {
        gameObject.move(0,SPEED);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof PlaneController){
            ((PlaneController) contactable).gotPowerUp();
            this.destroy();
        }
    }
}
