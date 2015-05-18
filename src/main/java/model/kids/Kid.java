package model.kids;

import model.Entity;
import model.candymodels.Candy;

public abstract class Kid extends Entity {
	
	private static int idCounter = 0;
	private final String ID;
	protected boolean expired;

	protected double xHead, yHead;		// head position
	protected double rHead;				// head radius
	protected double rBody;				// body radius
	
	public Kid(float x, float y) {
		// initiate position
		super(x, y);					// initiate body position
		xHead = x;
		yHead = y + rBody + rHead;
		
		ID = generateId();
		expired = false;	// if not default for booleans?
	}
	
	@Override
	public String generateId() {
		return "k" + (++idCounter);
	}

	@Override
	public String getId() {
		return ID;
	}
	
	public double getHeadX() {
		return xHead;
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
	
	@Override
	public boolean isExpired() {
		return expired;
	}

}