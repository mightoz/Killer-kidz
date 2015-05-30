package model.entity.kids;

/**
 * Name:	GrandalfTheGrey
 * About:	A kid moving straightly forward, with decreasing velocity but
 * 			increasing size and hp.
 * @author  MarieKlevedal
 * @version 1.0
 */
public class GrandalfTheGrey extends Kid {
	
	private static final float MAX_R = 30;			// maximum possible radius
	private static final float DR_DT = 1.8f;		// dr/dt - the derivative of radius per second
	private double vx;								// velocity
	private static final float AX = 5;				// acceleration
	private static final float DHP_DT = 400;		// dHP/dt - the derivative of hp per second
	
	public GrandalfTheGrey(float x, float y) {
		super(x, y);
		radius = 5;
		
		vx = -80;

		maxHP = 500;
		hp = 200;
	}
	
	@Override
	public String getName() { return "Grandalf";}

	@Override
	public void update(double dt) {
		radius = (float) Math.min(radius + DR_DT*dt, MAX_R);
		vx += AX*dt;
		xPos += vx*dt;
		hp = (int) Math.min(hp + DHP_DT*dt, maxHP);
		
		if (xPos+radius <= leftBoundary) {
			expired = true;
			inStore= true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage, double slowRate) {
		switch (candyType) {
		case "candy4":		// favourite candy
			if (inKillerMode) { 
				hp -= 3*damage; 
			} else {
				hp = 0;
			}
			break;
		case "Hubbabubba":	// killer instinct triggering candy
			radius = MAX_R;
			hp = maxHP;
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
