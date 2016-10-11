import controllers.BulletController;
import controllers.PlaneController;
import models.Plane;
import utils.Utils;
import views.GameView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by apple on 10/2/16.
 */
public class GameWindow extends Frame implements Runnable {

    private static final int BACKGROUND_WIDTH = 600;
    private static final int BACKGROUND_HEIGHT = 400;

    Image backgroundImage = null;
    Image backBufferImage;

    PlaneController planeController;
    Vector<EnemyPlane> enemyPlaneVector;
    Vector<EnemyBullet> enemyBulletVector;

    public GameWindow() {

        planeController = new PlaneController(
                new Plane(BACKGROUND_WIDTH  / 2, BACKGROUND_HEIGHT - Plane.PLANE_HEIGHT),
                new GameView(Utils.loadImageFromRes("plane3.png"))
        );
        backBufferImage = new BufferedImage(BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        enemyPlaneVector = new Vector<>();
        enemyBulletVector = new Vector<>();

        Image enemyPlaneImage = Utils.loadImageFromRes("plane1.png");

        for(int i = 0; i < 10; i++) {
            int y = 60;
            int x = i * (EnemyPlane.ENEMY_PLANE_WIDTH + 5);
            EnemyPlane enemyPlane = new EnemyPlane(
                    x, y, enemyPlaneImage
            );
            enemyPlaneVector.add(enemyPlane);
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
//                plane2.mouseMoved(e);
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
                planeController.keyPressed(e);

//                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
//                    Image bulletImage = Utils.loadImage("resources/bullet.png");
//                    models.Bullet newBullet = new models.Bullet(
//                            plane.getMiddleX() - models.Bullet.BULLET_WIDTH / 2,
//                            plane.getY() - models.Bullet.BULLET_HEIGHT,
//                            bulletImage);
//                    bulletVector.add(newBullet);
//                }


            }

            @Override
            public void keyReleased(KeyEvent e) {
                planeController.keyReleased(e);
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

        planeController.draw(backBufferGraphics);
//        plane2.drawImage(backBufferGraphics);

        for(EnemyPlane enemyPlane : enemyPlaneVector) {
            enemyPlane.drawImage(backBufferGraphics);
        }

        for(EnemyBullet enemyBullet : enemyBulletVector) {
            enemyBullet.drawImage(backBufferGraphics);
        }

        g.drawImage(backBufferImage,
                0, 0,
                BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
    }

    int count = 0;

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(17);
                repaint();
                planeController.run();

                count++;

//                for (models.Bullet bullet : bulletVector) {
//                    bullet.fly();
//                }
//
//                for (EnemyPlane enemyPlane : enemyPlaneVector) {
//                    enemyPlane.fly();
//                }
//
//                if(count >= 10) {
//                    count = 0;
//                    for (EnemyPlane enemyPlane : enemyPlaneVector) {
//                        EnemyBullet enemyBullet = new EnemyBullet(
//                                enemyPlane.getMiddleX(),
//                                enemyPlane.getBottom(),
//                                Utils.loadImageFromRes("enemy_bullet.png")
//                        );
//                        enemyBulletVector.add(enemyBullet);
//                    }
//                }

//                for(EnemyBullet enemyBullet : enemyBulletVector) {
//                    enemyBullet.fly();
//                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
