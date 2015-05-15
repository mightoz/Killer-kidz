package model.kids;

public class SimpleSam extends Kid {

	public SimpleSam(float x, float y) {
		super(x, y);		
		rHead = 5;		// NOTE: This may perhaps not work, as Kid needs rHead and rBody
		rBody = 10;
		
		vx = -10;
		vy = 0;
	}




}