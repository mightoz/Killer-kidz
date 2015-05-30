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
		startHP = 50;
		hp = startHP;
	}
	
	@Override
	public String getName() { return "Sam";}

	@Override
	public void update(double dt) {
		vx += ax*dt;
		xPos += vx*dt;
		
		immuneTimeLeft -= dt;
		
		if (xPos-radius <= leftBoundary) {
			expired = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage/*, double slowRate*/) {
		if (immuneTimeLeft <= 0) {
			inKillerMode = false;
			
			switch (candyType) {
			case "acndy2":		// favourite candy
				hp = 0;
				break;
			case "JellyBean":			// killer instinct triggering candy
				hp = startHP;
				immuneTimeLeft = 2;
				inKillerMode = true;
				break;
			case "HubbaBubba":
				// This candy slows down the kid
				hp -= damage;
				//vx *= (1-slowRate);
			default:
				hp -= damage;	
			}

			if (hp <= 0) {
				expired = true;
			}
		}
	}
}