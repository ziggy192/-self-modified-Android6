package controllers.managers;

import controllers.EnemyPlaneController;
import controllers.EnemyPlaneType;
import models.EnemyPlane;

/**
 * Created by apple on 10/11/16.
 */
public class EnemyPlaneControllerManager extends ControllerManager {

    public EnemyPlaneControllerManager() {
        super();

        for(int i = 0; i < 10; i++) {
            int y = 60;
            int x = i * (EnemyPlane.ENEMY_PLANE_WIDTH + 5);
            EnemyPlaneController enemyPlaneController =
                    EnemyPlaneController.create(x, y, EnemyPlaneType.GRAY);
            baseControllers.add(enemyPlaneController);
        }

        for(int i = 0; i < 10; i++) {
            int y = 100;
            int x = i * (EnemyPlane.ENEMY_PLANE_WIDTH + 5);
            EnemyPlaneController enemyPlaneController =
                    EnemyPlaneController.create(x, y, EnemyPlaneType.RED);
            baseControllers.add(enemyPlaneController);
        }
    }
}
