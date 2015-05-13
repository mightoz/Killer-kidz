package model.kids;

import model.Entity;
import model.candymodels.Candy;

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
	
	// Default: no acceleration
//	@Override ------------------------------------------------------------------------ TODO
	public void update(int delta) {
		xPos += vx*delta;
		yPos += vy*delta;
	}
	
	boolean hitByCandy(Candy c) {
		int rCandy = 2; //c.getRadius();				// NOTE: change!
		
		if (pow2(xHead - c.getX()) + pow2(yHead - c.getY()) <= pow2(rHead + rCandy)) {
			// Candy hit head
			return true;
		}
		else if (pow2(xPos - c.getX()) + pow2(yPos - c.getY()) <= pow2(rBody + rCandy)) {
			// Candy hit body
			return true;
		}
		
		return false;
	}
	
	private double pow2(double x) {
		return x*x;
	}
	
	@Override
	public boolean isExpired() {
		return false;
	}

}