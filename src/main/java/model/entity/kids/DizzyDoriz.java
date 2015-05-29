package model.entity.kids;

/**
 * Name: 	DizzyDoriz
 * About:	A kid walking in a random pattern.
 * @author  MarieKlevedal
 * @version 1.0
 */
public class DizzyDoriz extends Kid {
	
	private double vx, vy;		// velocities
	private int updatesLeft;	// remaining updates before next change of velocity
	
	public DizzyDoriz (float x, float y) {
		super(x, y);
		rHead = 5;
		radius = 10;

		startHP = 200;
		hp = startHP;
	}

	@Override
	public void update(double dt) {
		// Velocity is changed every 200th update
		updatesLeft %= 200;
		if (updatesLeft == 0) {
			vx = 50 - randGen.nextInt(131);		// in [-80, 50]
			vy = 50 - randGen.nextInt(101);		// in [-50, 50]
		}
		xPos += vx*dt;
		yPos += vy*dt;
		
		// If Doriz escaped, put her back at playfield and set new velocity next time
		if (xPos + radius > rightBoundary) {
			xPos = rightBoundary-radius;
			updatesLeft = 1;
		}
		if (yPos + radius > upperBoundary) {
			yPos = upperBoundary-radius;
			updatesLeft = 1;
		}
		else if (yPos - radius < lowerBoundary) {
			yPos = lowerBoundary+radius;
			updatesLeft = 1;
		}
		updatesLeft--;
		
		if (xPos - radius <= leftBoundary) {
			expired = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage) {
		switch (candyType) {
		case "candy3":			// favourite candy
			hp = 0;
			break;
		case "candy4":			// killer instinct triggering candy
			hp += 200;
			vx *= 2;
			break;
		default:
			hp -= 100;	
		}
		
		if (hp <= 0) {
			expired = true;
		}
	}

}
