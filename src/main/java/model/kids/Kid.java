package model.kids;

import java.util.Random;

import model.Entity;
import model.Model;
import model.candymodels.Candy;

public abstract class Kid extends Entity {
	
	private static int idCounter = 0;
	private final String ID;
	
	protected int startHP;
	protected int hp;
	protected boolean expired;

	protected float yHead;				// head y position (x always same as body)
	protected float rHead;				// head radius
	protected float rBody;				// body radius
	
	protected static final double LEFT_WALL = Model.leftBoundary;
	protected static final double RIGHT_WALL = Model.rightBoundary;
	protected static final double FLOOR = 0;
	protected static final double CEILING = FLOOR + Model.height;
	
	protected static final Random randGen = new Random();
	
	public Kid(float x, float y) {
		super(x, y);					// initiate body position
		
		ID = generateId();
		expired = false;
	}
	
	@Override
	public String generateId() {
		return "k" + (++idCounter);
	}

	@Override
	public String getId() {
		return ID;
	}
	
	public double getHeadY() {
		return yPos + rBody + rHead;
	}
	
	public float getHeadRadius() {
		return rHead;
	}
	
	public float getRadius() {
		return rBody;
	}
	
	// return the ratio of the hp that is left
	public double getHpRatio() {
		return (double)hp/startHP;
	}
	
	@Override
	public abstract void update(double dt);
	
	/**
	 * hitByCandy handles the changes in kid if it's hit by a candy
	 * @param candy: the candy which hit the kid
	 * @return: void 
	 */
	public abstract void hitByCandy(Candy candy);
	
	public boolean enteredStore() {
		return xPos <= LEFT_WALL;
	}
	
	@Override
	public boolean isExpired() {
		return expired;
	}

}