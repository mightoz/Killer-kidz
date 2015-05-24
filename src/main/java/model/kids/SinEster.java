package model.kids;

import model.candymodels.Candy;

public class SinEster extends Kid {
	
	private double vx, vy;
	
	public SinEster (float x, float y) {
		super(x, y);
		rHead = 5;
		rBody = 10;

		vx = -10;
		vy = 0;

		hp = 200;
	}


	@Override
	public void update(double delta) {
		// no acceleration
		xPos += vx*delta;
		yPos += vy*delta;

		expired = xPos <= LEFT_WALL;
	}

	@Override
	public void hitByCandy(Candy candy) {
		hp -= 100;
		expired = hp <= 0;
	}

}
