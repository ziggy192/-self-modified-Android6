package controllers;

import models.GameConfig;
import models.GameObject;

/**
 * Created by apple on 10/18/16.
 */
public class DownRightFlyBehavior implements FlyBehavior {
    private int speed;

    public DownRightFlyBehavior(int speed) {
        this.speed = speed;
    }

    @Override
    public void doFly(GameObject gameObject) {
        gameObject.move(speed, speed);
    }

    @Override
    public FlyBehavior changeDirection() {
        return new DownLeftFlyBehavior(speed);
    }

    @Override
    public FlyBehavior newDirectionIfNeeded(GameObject gameObject) {
        if (gameObject.getX()>= GameConfig.instance.getScreenWidth()){
            return changeDirection();
        }
        else
            return this;
    }
}
