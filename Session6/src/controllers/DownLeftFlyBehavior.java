package controllers;

import models.GameObject;

/**
 * Created by Nghia on 10/18/2016.
 */
public class DownLeftFlyBehavior implements FlyBehavior{
    private int speed;

    public DownLeftFlyBehavior(int speed) {
        this.speed = speed;
    }


    @Override
    public void doFly(GameObject gameObject) {
        gameObject.move(-speed,speed);
    }

    @Override
    public FlyBehavior changeDirection() {
        return new DownRightFlyBehavior(speed);
    }

    @Override
    public FlyBehavior newDirectionIfNeeded(GameObject gameObject) {
        if (gameObject.getX()<=0)
            return changeDirection();
        else
            return this;
    }


}
