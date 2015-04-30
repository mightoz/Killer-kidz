package com.edu.guchl.killerKids.view.inGameEntities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.edu.guchl.killerKids.view.GameView;

/*
 * Slog ihop denna med Models temporärt, så den kunde läsa korrekt data för
 * visa spelarens nya koordinater.
 */


public class PlayerView extends VisibleObjects {

//	private boolean up;
//	private boolean down;
//	private boolean left;
//	private boolean right;
	
	public PlayerView() {
		
		x = GameView.W_WIDTH / 4;
		y = GameView.W_HEIGHT / 2;
		
		shapeX = new float[3];
		shapeY = new float[3];
		
		radians = 3.1415f / 2;
		speed = 5;
	}
	
	private void setShape() {
		shapeX[0] = x + MathUtils.cos(radians) * 32;
		shapeY[0] = y + MathUtils.sin(radians) * 32;
		
		shapeX[1] = x + MathUtils.cos(radians - 4 * 3.1415f / 5) * 32;
		shapeY[1] = y + MathUtils.sin(radians - 4 * 3.1415f / 5) * 32;
		
		
		shapeX[2] = x + MathUtils.cos(radians + 4 * 3.1415f / 5) * 32;
		shapeY[2] = y + MathUtils.sin(radians + 4 * 3.1415f / 5) * 32;
	}
	
//	public void setUp(boolean b) { up = b; }
//	public void setDown(boolean b) { down = b; }
//	public void setLeft(boolean b) { left = b; }
//	public void setRight(boolean b) { right = b; }
	
	public void update(float dt, int newPosX, int newPosY) {
		
		// setting new position for player
		x = newPosX;
		y = newPosY;
		System.out.println("NewPosition: (" + x + ", " + y + ")");
		
		// set shape
		setShape();
	}
	
	public void update(float dt) {
		
		// set shape
		setShape();
	}
	
	public void draw(ShapeRenderer sr) {
		
		sr.setColor(1, 0, 0, 1);
		
		// all drawing should go between this and sr.end() at bottom.
		sr.begin(ShapeType.Line);
		
		for(int i = 0, j = shapeX.length - 1;
			i < shapeX.length;
			j = i++){
			
			sr.line(shapeX[i], shapeY[i], shapeX[j], shapeY[j]);
		}
		
		sr.end();
	}
}