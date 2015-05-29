package view.inGameEntities;

import com.badlogic.gdx.graphics.Color;
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

    public void render(Entity ent, ShapeRenderer sr){

    	Kid kid = (Kid) ent;
    	
    	if (kid.isVisible()) {
    		float x = kid.getX();
            float y = kid.getY();
            float r = kid.getRadius();
    		
    		// Draw body
    		if (kid.isKillerKid()) {
    			sr.setColor(1, 0, 0, kid.getHpRatio());					// red
    		}
    		else {
	    		switch (kid.getName()) {
	    		case "Sam":
	    			sr.setColor((float)0.75, 0, 1, kid.getHpRatio());	// purple
	    			break;
	    		case "Ester":
	    			sr.setColor(0, 1, 0, kid.getHpRatio());				// green
	    			break;
	    		case "Doriz":
	    			sr.setColor(1, (float)0.5, 0, kid.getHpRatio());	// orange
	    			break;
	    		case "Rascal":
	    			sr.setColor(1, 1, 1, kid.getHpRatio());				// white
	    			break;
	    		default:
	    			System.out.println("Not a valid child");
	    		}
    		}
    		sr.begin(ShapeType.Filled);
    		sr.circle(x, y, r);

    		// Draw face
			sr.setColor(Color.BLACK);
			sr.triangle(x+r/8, y+r/8, x+2*r/3, y+r/8, x+2*r/3, y+2*r/3);	// right eye
			sr.triangle(x-r/8, y+r/8, x-2*r/3, y+r/8, x-2*r/3, y+2*r/3);	// left eye
			sr.circle(x, y+r/10-r/2, (float)(0.45*r));						// mouth
    		
            sr.end();
    	}

		// TODO - description at begining of class.
//		sr.setColor(0, 0, 0, 1);
//        sr.arc(iconPosX + squareSizeX, iconPosY, 21, 5, 45);
//		sr.circle(x, y, radius-1, segments);
//		radius = (float)kid.getBodyRadius();
//		hungerPoint = kid.getHpRatio();
//		segment = (int) (2 * hungerPoint);

    }
}