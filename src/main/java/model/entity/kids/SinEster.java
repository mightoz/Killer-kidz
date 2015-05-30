package model.entity.kids;


import java.lang.Math;

/**
 * Name:	SinEster
 * About:	A kid walking in a sine wave.
 * @author  MarieKlevedal
 * @version 1.0
 */
public class SinEster extends Kid {
	
	private float vx, vy;		// velocities
	private int maxA;			// maximum amplitude of the sine wave
	private float k = 0.1f;		// the wavenumber of the sine wave
	private float dTransp;		// dTransp/dt
	
	public SinEster (float x, float y) {
		super(x, y);
		radius = 10;
		
		vx = -50;
		maxA = (int)Math.min(upperBoundary - yPos, yPos - lowerBoundary);

		startHP = 200;
		hp = startHP;
	}

	@Override
	public String getName() { return "Ester";}

	@Override
	public void update(double dt) {
		// y(x) = A * sin(k*x)
		int A = randGen.nextInt(maxA);
		vy = (float) (A*k*Math.cos(k*(rightBoundary - xPos)));	// vy = dy/dx (old x)
		xPos += vx*dt;									// vx = dx/dt
		yPos += vy*vx*dt;								// dy/dt = dy/dx * dx/dt
		
		transparency+=dTransp*dt;
		
		if (xPos-radius <= leftBoundary) {
			expired = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage/*, double slowRate*/) {
		switch (candyType) {
		case "candy2":			// favourite candy
			hp = 0;
			break;
		case "candy3":			// killer instinct triggering candy
			hp = startHP;
			vx *= 2;
			inKillerMode = true;
			dTransp = -0.2f;
			break;
		default:
			hp -= damage;	
		}

		if (hp <= 0) {
			expired = true;
		}
	}

}
