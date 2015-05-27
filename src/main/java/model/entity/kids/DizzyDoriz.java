package model.entity.kids;

/**
 * DizzyDoriz
 * @author  MarieKlevedal
 * @version 1.0
 */
public class DizzyDoriz extends Kid {
	
	private double vx, vy;		// velocities
	
	public DizzyDoriz (float x, float y) {
		super(x, y);
		rHead = 5;
		radius = 10;

		startHP = 200;
		hp = startHP;
	}

	@Override
	public void update(double dt) {
		vx = 50 - randGen.nextInt(151);		// in [-100, 50]
		vy = 50 - randGen.nextInt(101);		// in [-50, 50]
		xPos += vx*dt;
		yPos += vy*dt;
		
		// If Doriz escaped, put her back at playfield
		if (xPos + radius > rightBoundary) {
			xPos = rightBoundary-radius;
		}
		if (yPos + radius > upperBoundary) {
			yPos = upperBoundary-radius;
		}
		else if (yPos - radius < lowerBoundary) {
			yPos = lowerBoundary+radius;
		}
		
		if (xPos - radius <= leftBoundary) {
			expired = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage) {
		switch (candyType) {
		case "candy3":			// favorite candy
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
