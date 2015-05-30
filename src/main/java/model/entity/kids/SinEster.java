package model.entity.kids;


import java.lang.Math;

/**
 * Name:	SinEster
 * About:	A kid walking in a sine wave.
 * @author  MarieKlevedal
 * @version 1.0
 */
public class SinEster extends Kid {
	
	private float vx, vy;			// velocities
	private final int MAX_A;		// maximum amplitude of the sine wave
	private final float K = 0.02f;	// the wavenumber of the sine wave
	private float dTransp = 0.9f;   // dTransp/dt
	private double invTimeLeft;		// invisibility time left
	
	public SinEster (float x, float y) {
		super(x, y);
		radius = 10;
		
		vx = -40;
		MAX_A = (int)Math.min(Math.min(upperBoundary - yPos, yPos - lowerBoundary), 0);
		
		invTimeLeft = 0;
		
		startHP = 200;
		hp = startHP;
	}

	@Override
	public String getName() { return "Ester";}

	@Override
	public void update(double dt) {
		// y(x) = A * sin(K*x)
		int A = randGen.nextInt(MAX_A);	//************************************************ERROR************************
		vy = (float) (A*K*Math.cos(K*(rightBoundary - xPos)));	// vy = dy/dx (old x)
		xPos += vx*dt;											// vx = dx/dt
		yPos += vy*vx*dt;										// dy/dt = dy/dx * dx/dt
		
		if (invTimeLeft > 0 && transparency > 0) {
			transparency -= dTransp*dt;
			invTimeLeft -= dt;
		}
		else if (transparency < 1) {
			transparency += dTransp*dt;
		}
		else {
			inKillerMode = false; 
		}
		
		// Entered toy store
		if (xPos+radius <= leftBoundary) {
			expired = true;
		}
	}

	@Override
	public void hitByCandy(String candyType, int damage/*, double slowRate*/) {
		switch (candyType) {
		case "Hubbabubba":			// favourite candy
			hp = 0;
			break;
		case "JellyBean":				// killer instinct triggering candy
			hp = startHP;
			inKillerMode = true;
			invTimeLeft = 1.5;
			break;
		default:
			hp -= damage;	
		}

		if (hp <= 0) {
			expired = true;
		}
	}

}
