package model.kids;


import model.candymodels.Candy;
import java.lang.Math;

public class SinEster extends Kid {
	
	private double vx, vy;		// velocities
	private int maxA;		// maximum amplitude of the sine wave
	
	public SinEster (float x, float y) {
		super(x, y);
		rHead = 5;
		rBody = 10;
		vx = -50;
		
		maxA = (int)Math.min(CEILING - yPos, yPos - FLOOR); 

		startHP = 200;
		hp = startHP;
	}


	@Override
	public void update(double dt) {
		double A = maxA; //randGen.nextInt(maxA);
		vy = A*5*Math.cos(RIGHT_WALL - xPos);
		xPos += vx*dt;
		yPos += vy*dt;
	}

	@Override
	public void hitByCandy(Candy candy) {
		hp -= 100;
		expired = hp <= 0;
	}

}
