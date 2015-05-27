package model.entity;

/**
 * Created by Oscar on 06/05/15.
 */
public abstract class Entity {

    protected float xPos, yPos, radius;

    protected static float leftBoundary;		// right wall of toy store
    protected static float rightBoundary;
    protected static float upperBoundary;
    protected static float lowerBoundary;

    public Entity(float x, float y){
        xPos = x;
        yPos = y;
    }

    public static void setBoundaries(float left, float right, float upper, float lower) {
    	leftBoundary = left;
    	rightBoundary = right;
    	upperBoundary = upper;
    	lowerBoundary = lower;
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
    protected abstract String generateId();

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

    public static float getUpperBoundary(){
        return upperBoundary;
    }
    public static float getLowerBoundary(){
        return lowerBoundary;
    }
    public static float getLeftBoundary(){
        return leftBoundary;
    }
    public static float getRightBoundary(){
        return rightBoundary;
    }

}
