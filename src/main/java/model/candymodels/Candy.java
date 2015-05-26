package model.candymodels;

import model.Entity;

/**
 * Created by Oscar on 28/04/15.
 */
public abstract class Candy extends Entity{

    private static int cIdGenerator;
    protected String type;
    protected int damage;

    private final String cId;

    public Candy(float x, float y){
        super(x,y);
        cId = generateId();
    }

    public abstract void update(double delta);

    @Override
    public String generateId() {
        int tmp = cIdGenerator;
        cIdGenerator++;
        return "c"+tmp;

    }

    public String getType(){
    	return type;
    }
    public int getDamage(){
        return damage;
    }
    public String getId(){
        return cId;
    }

}
