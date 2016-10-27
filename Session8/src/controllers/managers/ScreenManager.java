package controllers.managers;

import java.util.Stack;

/**
 * Created by Nhan on 10/25/2016.
 */
public interface ScreenManager {

//
//    public ScreenManager() {
//        screenStack = new Stack<>();
//    }

    void change(GameScreen gameScreen, boolean addToBackstack);
}
