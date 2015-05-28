package view.gameStates.playfieldGUI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * GUI
 * This class is responsible drawing the "shell" for the GUI at top, which is
 * painted on afterwards, so for an example you have the layer to draw currentLevel:
 * "background then a box border and lastly the string on top of it, to show
 * the currentLevel with a nice box and a GUI-background.
 * 
 * @author  Kim Berger
 * @version 1.0
 */
public class GUI_Foundation extends GUI_Super{
	
	// Original box-sizes for our menu.
	private float squareSizeX = 75f;
	private float squareSizeY = 60f;
	private float levelSizeX = 65f;
	
//	// arrays wich will represent a vector.
	protected float[] shapeX;
	protected float[] shapeY;
	
	public GUI_Foundation(float width, float height) {
		
		this.width = width;
		this.height = height;

		// Startpoint upper-left corner.
		x = 1;
		y = height - 1;

		shapeX = new float[9];
		shapeY = new float[9];
	}

	public void render(ShapeRenderer sr) {
		
		// Draw ActionBar's background
		sr.setColor(Color.DARK_GRAY);
		sr.begin(ShapeType.Filled);
		sr.box(0, height - squareSizeY-2, 0, width, height, 0);
		sr.end();
		
		/*
		 *  Draw ActionBar's outline
		 *  first set the shape to draw. then set color, then draw
		 */
		setShape();

		sr.setColor(0, 1, 0, 1);
		
		sr.begin(ShapeType.Line);
		
		for (int i = 0, j = shapeX.length - 1; i < shapeX.length; j = i++) {
			sr.line(shapeX[i], shapeY[i], shapeX[j], shapeY[j]);
		}
		
		sr.end();
	}
	
	/*
	 * This code below, is not the most elegant way to draw all "default-GUI"
	 * But i thought it was simple and fun do instead of drawing "new boxes"
	 */
	private void setShape() {

		// first draw the outline of all boxes
		shapeX[0] = x;
		shapeY[0] = y;
		
		shapeX[1] = x;
		shapeY[1] = y - squareSizeY;

		shapeX[2] = width - 1;
		shapeY[2] = y - squareSizeY;
		
		shapeX[3] = width - 1;
		shapeY[3] = y;
		
		shapeX[4] = x;
		shapeY[4] = y;
		
		// Then MoneyBox
		shapeX[5] = width - squareSizeX * 1.2f;
		shapeY[5] = y;
		
		shapeX[6] = width - squareSizeX * 1.2f;
		shapeY[6] = y - squareSizeY;
		
		// Then the Current-Level right side of the box.
		shapeX[7] = x + levelSizeX;
		shapeY[7] = y - squareSizeY;
		
		shapeX[8] = x + levelSizeX;
		shapeY[8] = y;
		
		// repeat for future candys....
	}
	
	public float getSquareSizeX() { return squareSizeX; }
	public float getSquareSizeY() { return squareSizeY; }
	public float getCandyBarStartPointX() { return (x + levelSizeX); }
	public float getCandyBarStartPointY() { return (y - squareSizeY); }
}
