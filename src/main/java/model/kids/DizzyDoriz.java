package model.kids;

import model.candymodels.Candy;

public class DizzyDoriz extends Kid {
	
	private double vx, vy;		// velocities
	
	public DizzyDoriz (float x, float y) {
		super(x, y);
		rHead = 5;
		rBody = 10;
		vx = -50;

		startHP = 200;
		hp = startHP;
	}


	@Override
	public void update(double dt) {
		xPos += vx*dt;
		yPos += vy*dt;
	}

	@Override
	public void hitByCandy(Candy candy) {
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
