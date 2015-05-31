package model.entity.kids;

/**
 * Name:	SimpleSam
 * About:	A simple kid, just walking straightly forward with a slight acceleration.
 * @author  MarieKlevedal
 * @version 1.0
 */
public class SimpleSam extends Kid {

	private float vx;			// velocity
	private float ax;			// acceleration
	
	private double immuneTimeLeft;
	
	public SimpleSam(float x, float y) {
		super(x, y);
		radius = 10;

		vx = -40;
		ax = -5;

		immuneTimeLeft = 0;
		maxHP = 100;
		hp = maxHP;
	}
	
	@Override
	public String getName() { return "Sam";}

	@Override
	public void update(double dt) {
		vx += ax*dt;
		xPos += vx*dt;
		
		immuneTimeLeft -= dt;
		if (immuneTimeLeft <= 0) {
			inKillerMode = false;
		}
		
		// Entered toy store
		if (xPos+radius <= leftBoundary) {
			expired = true;
			inStore = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage, double slowRate) {
		if (immuneTimeLeft <= 0) {
			inKillerMode = false;
			
			switch (candyType) {
			case "JellyBean":			// favourite candy
				hp = 0;
				break;
			case "Chocolate":			// killer instinct triggering candy
				hp = maxHP;
				immuneTimeLeft = 1;
				inKillerMode = true;
				break;
			case "Hubbabubba":
				hp -= damage;
				vx *= (1-slowRate);		// slows down the kid

			default:
				hp -= damage;	
			}

			if (hp <= 0) {
				expired = true;
			}
		}
	}
}