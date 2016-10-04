import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by apple on 10/2/16.
 */
public class GameWindow extends Frame implements Runnable {

    private static final int BACKGROUND_WIDTH = 600;
    private static final int BACKGROUND_HEIGHT = 400;

    Image backgroundImage = null;
    Image backBufferImage;

    Plane plane;
    Plane plane2;
    Bullet bullet;

    public GameWindow() {

        backBufferImage = new BufferedImage(BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        try {
            plane = new Plane(350, 250,
                    ImageIO.read(new File("resources/plane3.png")));
            plane2 = new Plane(450, 250,
                    ImageIO.read(new File("resources/plane4.png")));
            bullet = new Bullet(BACKGROUND_WIDTH / 2, BACKGROUND_HEIGHT,
                    ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setVisible(true);
        this.setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                plane2.mouseMoved(e);
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                plane.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });

        try {
            backgroundImage = ImageIO.read (
                    new File("resources/background.png"));
            System.out.println("Loaded backgroundImage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("draw background image");
    }

    @Override
    public void update(Graphics g) {

        Graphics backBufferGraphics = backBufferImage.getGraphics();

        backBufferGraphics.drawImage(backgroundImage,
                0, 0,
                BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);

        plane.drawImage(backBufferGraphics);
        plane2.drawImage(backBufferGraphics);
        bullet.drawImage(backBufferGraphics);

        g.drawImage(backBufferImage,
                0, 0,
                BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(17);
                bullet.fly();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
