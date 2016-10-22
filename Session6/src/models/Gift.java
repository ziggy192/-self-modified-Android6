package models;

/**
 * Created by Nghia on 10/22/2016.
 */
public class Gift extends GameObject {

    public static final int GIFT_WIDTH = 25;
    public static final int GIFT_HEIGHT = 25;
    public Gift(int x, int y) {
        super(x, y, GIFT_WIDTH, GIFT_HEIGHT);
    }
}
