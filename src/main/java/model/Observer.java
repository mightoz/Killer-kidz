package model;

/**
 * Created by Matilda on 2015-05-03.
 */
public interface Observer {

    public void update();

    public void setSubject(ObservedSubject sub);

}
