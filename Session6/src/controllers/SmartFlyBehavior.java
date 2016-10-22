package controllers;

import models.GameObject;

/**
 * Created by Nghia on 10/22/2016.
 */
public class SmartFlyBehavior implements FlyBehavior {
    private double sin;
    private double cos;
    private int speed;

    public SmartFlyBehavior(double sin, double cos, int speed) {
        this.sin = sin;
        this.cos = cos;
        this.speed = speed;
    }

    public SmartFlyBehavior(GameObject source, GameObject destination, int speed){
        // if the square triangle ABC with B is the right angle, A is on the top, C is on the right
        // then adjcentSide is AB
        //      oppositeSite is BC
        //      hypothenueseSide is AC
        double adjacentSide = Math.abs(destination.getMiddleY()-source.getMiddleY());
        double oppositeSite = Math.abs(destination.getMiddleX()-source.getMiddleX());
        double hypothenuseSide = Math.sqrt(adjacentSide*adjacentSide+oppositeSite*oppositeSite);
        this.sin = oppositeSite/hypothenuseSide;
        this.cos = adjacentSide/hypothenuseSide;
        this.speed =  speed;

    }



    @Override
    public void doFly(GameObject gameObject) {
        gameObject.move( (speed*sin),  (speed*cos));
    }

    @Override
    public FlyBehavior changeDirection() {
        return this;
    }

    @Override
    public FlyBehavior newDirectionIfNeeded(GameObject gameObject) {
        return this;
    }
}
