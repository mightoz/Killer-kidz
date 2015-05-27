package model.entity.kids;

/**
 * SimpleSam
 * @author  MarieKlevedal
 * @version 1.0
 */
public class SimpleSam extends Kid {

	private double vx;			// velocity
	
	public SimpleSam(float x, float y) {
		super(x, y);
        rHead = 5;
		radius = 10;

		vx = -40;

		startHP = 100;
		hp = startHP;
	}

	@Override
	public void update(double dt) {
		//vx += 
		xPos += vx*dt;
		
		if (xPos-radius <= leftBoundary) {
			expired = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage) {
		hp -= damage;

		if (hp <= 0) {
			expired = true;
		}
	}
}