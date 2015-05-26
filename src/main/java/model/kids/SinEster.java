package model.kids;


import model.candymodels.Candy;
import java.lang.Math;

public class SinEster extends Kid {
	
	private double vx, vy;		// velocities
	private int maxA;			// maximum amplitude of the sine wave
	private double k = 0.1;		// the wavenumber of the sine wave
	
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
		// y(x) = A * sin(k*x)
		int A = randGen.nextInt(maxA);
		vy = A*k*Math.cos(k*(RIGHT_WALL - xPos));	// vy = dy/dx (old x)
		xPos += vx*dt;								// vx = dx/dt
		yPos += vy*vx*dt;							// dy/dt = dy/dx * dx/dt
	}

	@Override
	public void hitByCandy(int damage) {
		String candyType = "JellyBean"; //candy.getType();
		switch (candyType) {
		case "candy2":			// favorite candy
			hp = 0;
			break;
		case "candy3":			// killer instinct triggering candy
			hp += 200;
			vx *= 2;
			break;
		default:
			hp -= 100;	
		}

		expired = hp <= 0;
	}

}
