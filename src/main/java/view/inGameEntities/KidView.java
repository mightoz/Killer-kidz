package view.inGameEntities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import model.entity.Entity;
import model.entity.kids.Kid;

/**
 * KidView
 * This class is responsible to paint kids on the screen.
 * 
 * @author  Kim Berger
 * @version 1.0
 */
public class KidView extends VisibleObjects{
	/*
	 * My idea is to make every kids have a "pie-chart" within its circle
	 * to tell the player(s) how much hp the kid has remaining.
	 */
	
//	//fields below are for making the kids show their remaining hp as segments.
//	// kids hunger as a percentage
//	private double hungerPoint;
//	private int segments = 3;
//	private Kid kid;

	public void render(Entity ent, ShapeRenderer sr) {

		Gdx.gl.glEnable(GL20.GL_BLEND);
	    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	    
		Kid kid = (Kid) ent;

		float x = kid.getX();
		float y = kid.getY();
		float r = kid.getRadius();
		
		sr.begin(ShapeType.Filled);
		sr.setAutoShapeType(true);
		
		// Draw body
		if (kid.enraged()) {
			
			switch (kid.getName()) {
			
			case "Sam":
				sr.set(ShapeType.Line);
				sr.setColor(Color.WHITE);
				sr.circle(x, y, r);
				
				sr.set(ShapeType.Filled);
				sr.setColor(Color.PURPLE);
				break;
				
			case "Ester":
				sr.setColor(0, 1, 0, kid.getTransparency());
				break;
				
			case "Doriz":
				sr.setColor(Color.RED);
				break;
				
			case "Grandalf":
				sr.setColor(Color.WHITE);
				break;
				
			default:
				System.out.println("Not a valid child");
				break;
				
			}
			
			sr.circle(x, y, r);
			
			// Angry eyes
			sr.setColor(0, 0, 0, kid.getTransparency());
			sr.triangle(x+r/8, y+r/8, x+2*r/3, y+r/8, x+2*r/3, y+2*r/3);	// right eye
			sr.triangle(x-r/8, y+r/8, x-2*r/3, y+r/8, x-2*r/3, y+2*r/3);	// left eye
			
		} else {
			switch (kid.getName()) {
			case "Sam":
				sr.setColor(Color.PURPLE);
				break;
				
			case "Ester":
				sr.setColor(Color.GREEN);
				break;
				
			case "Doriz":
				sr.setColor(Color.ORANGE);
				break;
				
			case "Grandalf":
				sr.setColor(Color.GRAY);
				break;
				
			default:
				System.out.println("Not a valid child");
			}
			
			sr.set(ShapeType.Filled);
			sr.circle(x, y, r);
			
			// Normal eyes
			sr.setColor(Color.BLACK);
			sr.circle(x+0.4f*r, y+0.4f*r, r/4);		// right
			sr.circle(x-0.4f*r, y+0.4f*r, r/4);		// left
			
		}
		
		// Mouth
		sr.setColor(0, 0, 0, kid.getTransparency());
		sr.circle(x, y+r/10-r/2, (float)(0.45*r));
		
        sr.end();
        
        Gdx.gl.glDisable(GL20.GL_BLEND);

		// TODO - description at begining of class.
//		sr.setColor(0, 0, 0, 1);
//        sr.arc(iconPosX + squareSizeX, iconPosY, 21, 5, 45);
//		sr.circle(x, y, radius-1, segments);
//		radius = (float)kid.getBodyRadius();
//		hungerPoint = kid.getHpRatio();
//		segment = (int) (2 * hungerPoint);

	}
}