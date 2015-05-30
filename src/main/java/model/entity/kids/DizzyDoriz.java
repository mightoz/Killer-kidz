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
	
	private double stopTimeLeft;
	
	public DizzyDoriz (float x, float y) {
		super(x, y);
		radius = 10;

		stopTimeLeft = 0;
		
		startHP = 200;
		hp = startHP;
	}
	
	@Override
	public String getName() { return "Doriz";}

	@Override
	public void update(double dt) {
		
		if (inKillerMode) {
			if (stopTimeLeft > 0) {
				stopTimeLeft -= dt;
				return;
			}
			else {
				xPos -= 200*dt;
				
				// Entered toy store
				if (xPos+radius <= leftBoundary) {
					expired = true;
				}
				return;
			}
			
		}
		
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
		
		// Entered toy store
		if (xPos+radius <= leftBoundary) {
			expired = true;
			inStore = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage/*, double slowRate*/) {
		switch (candyType) {
		case "candy3":			// favourite candy
			hp = 0;
			break;
		case "JellyBean":		// killer instinct triggering candy
			hp = startHP;
			inKillerMode = true;
			stopTimeLeft = 2;
			break;
		case "Hubbabubba":
			hp -= damage;
			//vx *= (1-slowRate);	// slows down the kid
		default:
			hp -= 100;	
		}
		
		if (hp <= 0) {
			expired = true;
		}
	}

}
