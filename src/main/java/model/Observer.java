package model;

import model.entity.Entity;

/**
 * Created by Matilda on 2015-05-03.
 */
public interface Observer {

    public void update(Entity entity);
    public void removeEntity(Entity entity);
}
