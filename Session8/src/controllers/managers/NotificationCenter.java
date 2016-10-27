package controllers.managers;

import controllers.EventType;
import controllers.SingleController;
import controllers.Subcriber;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Nhan on 10/25/2016.
 */
public class NotificationCenter {
    private Vector<Subcriber> subcriberVector;

    public NotificationCenter() {
        subcriberVector = new Vector<>();
    }

    public void onEvent(EventType eventType, SingleController sender) {

        collectDeadBody();

        for (Subcriber subcriber : subcriberVector) {
            subcriber.onEvent(eventType, sender);
        }
        //remove dead Subscriber
        collectDeadBody();

    }

    public void register(Subcriber subcriber) {
        subcriberVector.add(subcriber);
    }

    private void collectDeadBody(){
        Iterator<Subcriber> iterator = subcriberVector.iterator();
        while (iterator.hasNext()){
            Subcriber subcriber = iterator.next();
            if (!((SingleController)subcriber).getGameObject().isAlive())
                iterator.remove();
        }
    }

    public void unregister(Subcriber subcriber) {
        subcriberVector.remove(subcriber);
    }
    public final static void refresh(){
        instance = new NotificationCenter();
    }
    public  static NotificationCenter instance =null;
}
