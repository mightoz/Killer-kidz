package model.entity.kids;

/**
 * Name:	RollingRascal
 * About:	A kid moving as if rolling down a slope, with increasing
 *          size, like a snowball.
 * @author  MarieKlevedal
 * @version 1.0
 */
public class RollingRascal extends Kid {

	private double vx, vy;		// velocities
	private double ax, ay;		// accelerations
	
	public RollingRascal(float x, float y) {
		super(x, y);
		rHead = 1;
		radius = 5;

		vx = -40;
		ax = -5;

		startHP = 50;
		hp = startHP;
	}

	@Override
	public void update(double dt) {
		vx += ax*dt;
		vy += ay*dt;
		xPos += vx*dt;
		yPos += vy*dt;
		
		if (xPos-radius <= leftBoundary) {
			expired = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage) {
		switch (candyType) {
		case "candy4":		// favorite candy
			hp = 0;
			break;
		case "JellyBean":	// killer instinct triggering candy
			hp = 1000;
			break;
		default:
			hp -= damage;	
		}

		if (hp <= 0) {
			expired = true;
		}
	}

}
