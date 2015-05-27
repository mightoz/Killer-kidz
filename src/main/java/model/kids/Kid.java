package model.kids;


import java.util.Random;
import model.Entity;

/**
 * Kid
 * @author  MarieKlevedal
 * @version 1.0
 */
public abstract class Kid extends Entity {
	
	private static int idCounter = 0;
	private final String ID;
	
	protected int startHP;
	protected int hp;
	protected boolean expired;

	protected float rHead;				// head radius
	
	protected static final Random randGen = new Random();
	
	public Kid(float x, float y) {
		super(x, y);					// initiate body position
		
		ID = generateId();
		expired = false;
	}
	
	@Override
	protected String generateId() {
		return "k" + (++idCounter);
	}

	@Override
	public String getId() {
		return ID;
	}
	
	public double getHeadY() {
		return yPos + radius + rHead;
	}
	
	public float getHeadRadius() {
		return rHead;
	}
	
	@Override
	public float getRadius() {
		return radius;
	}
	
	// return the ratio of the hp that is left
	public double getHpRatio() {
		return (double)hp/startHP;
	}
	
	@Override
	public abstract void update(double dt);
	
	/**
	 * hitByCandy handles the changes in kid if it's hit by a candy
	 * @param damage: the candy dmg hit the kid
	 * @return: void 
	 */
	public abstract void hitByCandy(String candyType, int damage);
	
	public boolean enteredStore() {
		return xPos <= leftBoundary;
	}
	
	@Override
	public boolean isExpired() {
		return expired;
	}

}