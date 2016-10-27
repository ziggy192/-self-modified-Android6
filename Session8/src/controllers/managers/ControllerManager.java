package controllers.managers;

import controllers.BaseController;
import controllers.SingleController;
import controllers.Subcriber;
import models.GameObject;

import java.awt.*;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by apple on 10/11/16.
 */
public class ControllerManager implements BaseController {

    protected Vector<BaseController> baseControllers;

    public static final ControllerManager explosionManager = new ControllerManager();

    public ControllerManager() {
        this.baseControllers = new Vector<>();
    }

    public void add(BaseController baseController) {
        this.baseControllers.add(baseController);
    }

    @Override
    public void run() {
        synchronized (baseControllers) {
            Iterator<BaseController> iterator = baseControllers.iterator();
            while (iterator.hasNext()) {
                BaseController baseController = iterator.next();
                if (baseController != null){
                    if (baseController instanceof SingleController) {
                        GameObject gameObject =
                                ((SingleController) baseController).getGameObject();

                        if (!gameObject.isAlive()) {
                            if (iterator instanceof Subcriber ){
                                NotificationCenter.instance.unregister((Subcriber)iterator);
                                System.out.println("unrigisteed");
                            }
                            iterator.remove();
                        } else {
                            baseController.run();
                        }
                    } else {
                        baseController.run(); // Manager
                    }
                }

            }
        }
    }

    @Override
    public void draw(Graphics g) {
        synchronized (baseControllers) {
            for (BaseController baseController : baseControllers) {
                if (baseController != null)
                    baseController.draw(g);
            }
        }
    }
}
