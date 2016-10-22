package controllers;

import models.EnemyPlane;
import utils.Utils;
import views.GameView;

/**
 * Created by apple on 10/11/16.
 */
public class EnemyPlaneControllerManager extends ControllerManager {

    public EnemyPlaneControllerManager() {
        super();

        for(int i = 0; i < 10; i++) {
            int y = 60;
            int x = i * (EnemyPlane.ENEMY_PLANE_WIDTH + 5);
            EnemyPlaneController enemyPlaneController = EnemyPlaneController.create(x,y,0);
            baseControllers.add(enemyPlaneController);
        }

        for(int i = 0; i < 10; i++) {
            int y = 100;
            int x = i * (EnemyPlane.ENEMY_PLANE_WIDTH + 5);
            EnemyPlaneController enemyPlaneController = EnemyPlaneController.create(x,y,1);
            baseControllers.add(enemyPlaneController);
        }
    }
}
