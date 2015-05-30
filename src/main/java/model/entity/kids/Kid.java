package model.entity.kids;


import java.util.Random;
import model.entity.Entity;

/**
 * Name:	Kid
 * About: 	An abstract class with the general properties of all kids.
 * @author  MarieKlevedal
 * @version 1.0
 */
public abstract class Kid extends Entity {
	
	private static int idCounter = 0;
	private final String ID;
	
	protected int startHP;
	protected int hp;
	protected boolean expired;
	protected boolean inKillerMode;
	protected float transparency;

	protected float rHead;				// head radius
	
	protected static final Random randGen = new Random();
	
	public Kid(float x, float y) {
		super(x, y);					// initiate body position
		
		ID = generateId();
		expired = false;
		inKillerMode = false;
	}
	
	@Override
	protected String generateId() {
		return "k" + (++idCounter);
	}

	@Override
	public String getId() {
		return ID;
	}
	
	public abstract String getName();
	
	@Override
	public float getRadius() {
		return radius;
	}
	
	// return the ratio of the hp that is left
	public float getHpRatio() {
		return (float)hp/startHP;
	}
	
	@Override
	public abstract void update(double dt);
	
	public abstract void hitByCandy(String candyType, int damage);
	
	public boolean enteredStore() {
		return xPos <= leftBoundary;
	}
	
	@Override
	public boolean isExpired() {
		return expired;
	}
	
	public boolean enraged() {
		return inKillerMode;
	}
	
	public float getTransparancy() {
		return transparency;
	}

}