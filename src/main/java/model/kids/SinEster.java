package model.kids;

import java.util.Random;

import model.candymodels.Candy;

public class SinEster extends Kid {
	
	private double vx, vy;		// velocities
	
	private final Random randGen;
	private int A;				// amplitude of the sine wave
	
	public SinEster (float x, float y) {
		super(x, y);
		rHead = 5;
		rBody = 10;
		vx = -1;
		vy = 0;

		startHP = 200;
		hp = startHP;
		
		randGen = new Random();
	}


	@Override
	public void update(double delta) {
		// no acceleration
		xPos += vx*delta;
		yPos += vy*delta;
	}

	@Override
	public void hitByCandy(Candy candy) {
		hp -= 100;
		expired = hp <= 0;
	}

}
