import java.awt.*;

/**
 * Created by apple on 10/4/16.
 */
public class Bullet {
    private static final int BULLET_WIDTH = 13;
    private static final int BULLET_HEIGHT = 30;
    private static final int SPEED = 1;

    private int x;
    private int y;
    private Image image;

    public Bullet(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, BULLET_WIDTH, BULLET_HEIGHT, null);
    }

    public void fly() {
        y -= SPEED;
    }
}
