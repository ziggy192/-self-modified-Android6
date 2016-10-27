package controllers;

/**
 * Created by Nhan on 10/25/2016.
 */
public interface Subcriber {
    void onEvent(EventType eventType, SingleController singleController);
}
