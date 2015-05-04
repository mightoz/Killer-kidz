package model;

/**
 * Created by Matilda on 2015-05-03.
 */
public interface ObservedSubject {

    public void register(Observer o);
    public void unregister(Observer o);

    //Notify observers of change
    public void notifyObserver();

}
