package model.kids;

import model.candymodels.Candy;

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
	public void hitByCandy(Candy candy) {
		hp -= candy.getDamage();
		expired = hp <= 0;
	}

    public float getRadius(){
        return rBody;
    }
	
}