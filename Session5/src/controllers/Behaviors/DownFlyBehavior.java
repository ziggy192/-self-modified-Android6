package controllers.Behaviors;

import models.GameObject;

/**
 * Created by Nghia on 10/20/2016.
 */
public class DownFlyBehavior implements FlyBehavior{

    @Override
    public void doFly(GameObject gameObject, int speed) {
        gameObject.move(0, speed);
    }
}
