package models;

/**
 * Created by Nghia on 10/20/2016.
 */
public class EnemyBullet extends GameObject {
    public static final int BULLET_WIDTH = 30;
    public static final int BULLET_HEIGHT = 30;

    public EnemyBullet(int x, int y) {
        super(x, y, BULLET_WIDTH, BULLET_HEIGHT);
    }
}
