import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by apple on 10/2/16.
 */
public class GameWindow extends Frame {
    Image backgroundImage = null;
    Image plain;
    private int planeX = 350;
    private int planeY = 250;

    public GameWindow() {
        this.setVisible(true);
        this.setSize(600, 400);

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
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        System.out.println("Key right");
                        planeX += 10;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        planeX -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY +=10;
                        repaint();
                        break;
                    case KeyEvent.VK_UP:
                        planeY -= 10;
                        repaint();
                        break;

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });

        try {
            backgroundImage = ImageIO.read(
                    new File("resources/background.png"));
            plain = ImageIO.read(new File("resources/plane3.png"));
            System.out.println("Loaded backgroundImage");
        } catch (IOException e) {
            e.printStackTrace();
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("draw background image");
        g.drawImage(backgroundImage, 0, 0, 600, 400, null);
        g.drawImage(plain, planeX, planeY, 50, 30, null);
    }
}
