package model.kids;

import model.Entity;

public abstract class Kid extends Entity {

	private static int idCounter = 0;
	private final String ID;

	protected double xHead, yHead;
	protected int rHead;
	protected int rBody;
	
	protected int vx, vy;
	
	public Kid(float x, float y) {
		// initiate position
		super(x, y);			// body position
		xHead = x;
		yHead = y + rBody + rHead;
		
		ID = generateId();
	}
	
	@Override
	public String generateId() {
		return "k" + (++idCounter);
	}

	@Override
	public String getId() {
		return ID;
	}
	
	
	@Override
	public void update(double delta) {
		xPos += vx*delta;
		yPos += vy*delta;
	}
		
	@Override
	public boolean isExpired() {
		return false;
	}

}