package model.entity.kids;

/**
 * Name:	SimpleSam
 * About:	A simple kid, just walking straightly forward with a slight acceleration.
 * @author  MarieKlevedal
 * @version 1.0
 */
public class SimpleSam extends Kid {

	private double vx;			// velocity
	private double ax;			// acceleration
	
	public SimpleSam(float x, float y) {
		super(x, y);
        rHead = 5;
		radius = 10;

		vx = -40;
		ax = -5;

		startHP = 50;
		hp = startHP;
	}
	
	@Override
	public String getName() { return "Sam";}

	@Override
	public void update(double dt) {
		vx += ax*dt;
		xPos += vx*dt;
		
		if (xPos-radius <= leftBoundary) {
			expired = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage) {
		switch (candyType) {
		case "JellyBean":		// favourite candy
			hp = 0;
			break;
		case "candy2":			// killer instinct triggering candy
			hp = startHP;
			// TODO: become immune for two seconds
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