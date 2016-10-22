package controllers;

import models.EnemyBullet;
import models.EnemyPlane;
import models.GameObject;
import utils.Utils;
import views.GameView;

/**
 * Created by apple on 10/11/16.
 */
public class EnemyPlaneControllerManager extends ControllerManager {
    public GameObject planeGameObject;

    public EnemyPlaneControllerManager(GameObject planeGameObject) {

        this.planeGameObject = planeGameObject;

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
                    EnemyPlaneController.create(x, y, EnemyPlaneType.YELLOW,planeGameObject);
            baseControllers.add(enemyPlaneController);
        }


    }



}
