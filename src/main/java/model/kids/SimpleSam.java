package model.kids;


public class SimpleSam extends Kid {

	private double vx, vy;			// velocities
	
	public SimpleSam(float x, float y) {
		super(x, y);
        rHead = 5;
		rBody = 10;

		vx = -40;
		vy = 0;

		startHP = 100;
		hp = startHP;
	}

	@Override
	public void update(double dt) {
		// no acceleration
		xPos += vx*dt;
		yPos += vy*dt;
	}

	@Override
	public void hitByCandy(String candy, int damage) {
		hp -= damage;
		expired = hp <= 0;
	}
	
}