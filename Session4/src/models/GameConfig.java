package models;

/**
 * Created by Nghia on 10/16/2016.
 */
public class GameConfig {
    public final static int DEFAULT_DELAY = 17;
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;

    private int threadDelayInMiliseconds = 17;
    private int screenWidth;
    private int screenHeight;

    private GameConfig(int threadDelayInMiliseconds, int screenWidth, int screenHeight) {
        this.threadDelayInMiliseconds = threadDelayInMiliseconds;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public double getSeconds(int count){
        return threadDelayInMiliseconds*count /1000.0;
    }

    public double getMiliseconds (int count){
        return threadDelayInMiliseconds * count;
    }
//    public static models.GameConfig getInstance(){
//        instance = new models.GameConfig(DEFAULT_DELAY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
//        return instance;
//    }

    public static final GameConfig instance = new GameConfig(
            DEFAULT_DELAY,
            DEFAULT_WIDTH,
            DEFAULT_HEIGHT
            );

}
