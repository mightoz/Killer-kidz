package model.kids;

public class SimpleSam extends Kid {

	public SimpleSam(float x, float y, int w, int h) {
		super(x, y);		
		rHead = 5;		// NOTE: This may perhaps not work, as Kid needs rHead and rBody
		rBody = 10;
		
		vx = -10;
		vy = 0;
	}

	@Override
	public void update(double delta) {
		// no acceleration
		xPos += vx*delta;
		yPos += vy*delta;
	}
	
}