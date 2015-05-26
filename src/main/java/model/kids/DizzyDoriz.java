package model.kids;


public class DizzyDoriz extends Kid {
	
	private double vx, vy;		// velocities
	
	public DizzyDoriz (float x, float y) {
		super(x, y);
		rHead = 5;
		radius = 10;
		vx = -50;

		startHP = 200;
		hp = startHP;
	}


	@Override
	public void update(double dt) {
		xPos += vx*dt;
		yPos += vy*dt;
		
		if (xPos-radius <= leftBoundary) {
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
