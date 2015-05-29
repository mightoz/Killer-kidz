package model.entity.kids;

/**
 * Name:	RollingRascal
 * About:	A kid moving straightly forward, with decreasing velocity but
 * 			increasing size and hp.
 * @author  MarieKlevedal
 * @version 1.0
 */
public class RollingRascal extends Kid {

	private static final double DR_DT = 1.8;		// dr/dt - the derivative of radius per second
	private double vx;								// velocity
	private static final double AX = 5;				// acceleration
	private static final double DHP_DT = 2;			// dHP/dt - the derivative of hp per second
	
	public RollingRascal(float x, float y) {
		super(x, y);
		rHead = 2;
		radius = 5;
		
		vx = -80;

		startHP = 50;
		hp = startHP;
	}
	
	@Override
	public String getName() { return "Rascal";}

	@Override
	public void update(double dt) {
		radius += DR_DT*dt;
		vx += AX*dt;
		xPos += vx*dt;
		hp += DHP_DT*dt;
		
		if (xPos-radius <= leftBoundary) {
			System.out.println("HP: " + hp);
			expired = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage) {
		switch (candyType) {
		case "candy4":		// favourite candy
			if (inKillerMode) { 
				hp -= 3*damage; 
			} else {
				hp = 0;
			}
			break;
		case "JellyBean":	// killer instinct triggering candy
			radius = 30;
			hp = 1000;
			inKillerMode = true;
			break;
		default:
			hp -= damage;
		}

		if (hp <= 0) {
			expired = true;
		}
	}

}
