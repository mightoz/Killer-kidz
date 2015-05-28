package view.inGameEntities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import model.entity.Entity;

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

    public void render(Entity kid, ShapeRenderer sr){

        sr.setColor(1, 1, 5, 1);

        sr.begin(ShapeType.Filled);

        sr.circle(kid.getX(), kid.getY(), kid.getRadius());

        sr.end();

		// TODO - description at begining of class.
//		sr.setColor(0, 0, 0, 1);
//        sr.arc(iconPosX + squareSizeX, iconPosY, 21, 5, 45);
//		sr.circle(x, y, radius-1, segments);
//		radius = (float)kid.getBodyRadius();
//		hungerPoint = kid.getHpRatio();
//		segment = (int) (2 * hungerPoint);

    }
}