package model.kids;

import model.Entity;
import model.candymodels.Candy;

public abstract class Kid extends Entity {
	
	private static int idCounter = 0;
	private final String ID;
	protected int hp;
	protected boolean expired;

	protected double yHead;				// head y position (x always same as body)
	protected double rHead;				// head radius
	protected double rBody;				// body radius
	
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
		return yHead;
	}
	
	public double getHeadRadius() {
		return rHead;
	}
	
	public double getBodyRadius() {
		return rBody;
	}
	
	@Override
	public abstract void update(double delta);
	
	/**
	 * hitByCandy handles the changes in kid if it's hit by a candy
	 * @param candy: the candy which hit the kid
	 * @return: void 
	 */
	public abstract void hitByCandy(Candy candy);
	
	public boolean enteredStore() {
		return xPos <= 0;
	}
	
	@Override
	public boolean isExpired() {
		return expired;
	}

}