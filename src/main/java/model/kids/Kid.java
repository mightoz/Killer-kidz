package model.kids;

import model.Entity;

public abstract class Kid extends Entity {
	
	private static int idCounter = 0;
	private final String ID;
	private boolean expired;

	protected double xHead, yHead;
	protected double rHead;
	protected double rBody;
	
	protected double vx, vy;
	
	public Kid(float x, float y) {
		// initiate position
		super(x, y);			// body position
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
	
	public double getHeadRadius() {
		return rHead;
	}
	
	public double getBodyRadius() {
		return rBody;
	}
			
	@Override
	public boolean isExpired() {
		return expired;
	}

}