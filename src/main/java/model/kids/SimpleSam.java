package model.kids;

import model.candymodels.Candy;

public class SimpleSam extends Kid {

	private double vx, vy;			// velocities
	
	public SimpleSam(float x, float y) {
		super(x, y);
        rHead = 5;
		rBody = 10;
		yHead = y + rBody + rHead;	// have to initialize it here; radiuses are 0 in Kid

		vx = -10;
		vy = 0;

		startHP = 100;
		hp = startHP;
	}

	@Override
	public void update(double delta) {
		// no acceleration
		double deltaMovement = delta*4;
		xPos += vx*deltaMovement;
		yPos += vy*deltaMovement;
		yHead += vy*deltaMovement;

		expired = xPos <= LEFT_WALL;

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