package model.kids;

import model.Model;
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

		if(xPos <= Model.leftBoundary){
			expired = true;
		}
	}

	@Override
	public void hitByCandy(int damage) {
		hp -= candy.getDamage();
		expired = hp <= 0;
	}
}