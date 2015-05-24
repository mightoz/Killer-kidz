package model;

/**
 * Created by Oscar on 06/05/15.
 */
public abstract class Entity {

    protected float xPos, yPos, radius;



    public Entity(float x, float y){
        xPos = x;
        yPos = y;
    }

    public float getX(){
        return this.xPos;
    }
    public float getY(){
        return this.yPos;
    }

    /**
     * Initializes the id for a player. Used only by constructor, should not be public.
     * @return
     */
    public abstract String generateId();

    /**
     * returns true if object has expired.
     * @return
     */
    public abstract boolean isExpired();

    public abstract void update(double delta);
    /**
     * returns the id of an object.
     * @return
     */
    public abstract String getId();

    public float getRadius(){
        return radius;
    }

}
