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
	
	protected int maxHP;
	protected int hp;
	protected boolean expired;
	protected boolean inStore;
	
	protected boolean inKillerMode;
	protected float transparency;
	
	protected static final Random randGen = new Random();
	
	public Kid(float x, float y) {
		super(x, y);					// initiate body position
		
		ID = generateId();
		
		expired = false;
		inStore = false;
		
		inKillerMode = false;
		transparency = 1;
		
	}
	
	// All kids are given an unique id starting with letter k
	@Override
	protected String generateId() {
		return "k" + (++idCounter);
	}

	@Override
	public String getId() {
		return ID;
	}
	
	public abstract String getName();
	
	public abstract void hitByCandy(String candyType, int damage, double slowRate);
	
	// An indicator of how "weak" the kid is, can be used by view.
	public float getHpRatio() {
		return (float)hp/maxHP;
	}
	
	public boolean enteredStore() {
		return inStore;
	}
	
	@Override
	public boolean isExpired() {
		return expired;
	}
	
	public boolean enraged() {
		return inKillerMode;
	}
	
	public float getTransparency() {
		return transparency;
	}

}