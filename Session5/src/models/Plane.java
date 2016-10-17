package models;

/**
 * Created by apple on 10/4/16.
 */
public class Plane extends GameObject  {
    public static final int PLANE_WIDTH = 50;
    public static final int PLANE_HEIGHT = 35;
    public static final int DEFAULT_HEALTH_POINT = 100;

    private int healthPoint ;

    public Plane(int x, int y) {
        super(x, y, PLANE_WIDTH, PLANE_HEIGHT);
        healthPoint = DEFAULT_HEALTH_POINT;
    }

    public void changeHealthPoint(int change){
        healthPoint+=change;
    }

    public int getHealthPoint() {
        return healthPoint;
    }
}
