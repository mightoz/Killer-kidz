package model;

/**
 * Created by Matilda on 2015-05-03.
 */
public interface Observer {

    public void update(String id, float posX, float posY);

    //Vet inte om vi behöver den här
    public void setSubject(ObservedSubject sub);

}
