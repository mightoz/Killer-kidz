package view.inGameEntities;

import model.entity.kids.Kid;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * KidView
 * This class is responsible to paint kids on the screen.
 * 
 * @author  Kim Berger
 * @version 1.0
 */
public class KidView extends VisibleObjects{
	
	private String id;
	private float radius;
	
	/*
	 * My idea is to make every kids have a "pie-chart" within its circle
	 * to tell the player(s) how much hp the kid has remaining.
	 */
	
//	//fields below are for making the kids show their remaining hp as segments.
//	// kids hunger as a percentage
//	private double hungerPoint;
//	private int segments = 3;
//	private Kid kid;
	
	
	public KidView(String id,  float width, float height) {

		this.id = id;

		x = width / 4;
		y = height / 2;

		radius = 10f;
	}

	// Updates players position, called by model (through interface).
	public void update(float newXPos, float newYPos) {


		//kid = (Kid)entity;
		x = newXPos;
		y = newYPos;
		
		// TODO - description above fields.
//		radius = (float)kid.getBodyRadius();
//		
//		hungerPoint = kid.getHpRatio();
//		segment = (int) (2 * hungerPoint);
		
		
	}

	public void render(ShapeRenderer sr) {
        sr.setColor(0, 1, 1, 1);

		// Then draw the new player-figure.
		sr.begin(ShapeType.Filled);
		
		sr.circle(x, y, radius);
		
		// TODO - description below fields.
//		sr.setColor(0, 0, 0, 1);
//		sr.circle(x, y, radius-1, segments);

		sr.end();
	}

	public String getId(){
		return id;
	}
}