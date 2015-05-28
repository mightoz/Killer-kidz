package view.gameStates.playfieldGUI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import view.gameStates.playfieldGUI.GUI_Foundation;


/*
 * Gör att man har ett skal som updateras hela tiden och sedan ritar
 * bara denna klassen över specfik ruta som annars har en "grå ram"
 * till en "markerad ram"
 */

/**
 * Candy_Bar
 * 
 * @author  Kim Berger
 * @version 1.0
 */
public class Candy_Bar extends GUI_Super {
	
	// Original box-sizes for our menu.
	private float squareSizeX = 75f;
	private float squareSizeY = 60f;
	private float levelSizeX = 65f;
	
//	private GUI_Foundation gui;
	private float startPointX;
	private float startPointY;
	
//	// arrays wich will represent a vector.
	protected float[] shapeX;
	protected float[] shapeY;
	
	public Candy_Bar(GUI_Foundation gui) {
		
//		this.gui = gui;
		
		startPointX = gui.getCandyBarStartPointX();
		startPointY = gui.getCandyBarStartPointY();

		// Startpoint upper-left corner.
		x = 1;
		y = height - 1;

//		shapeX = new float[13];
//		shapeY = new float[13];
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
		
		sr.rect(levelSizeX, squareSizeY, squareSizeX, levelSizeX);
		
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
		
		// Then the Current-Level box
		shapeX[7] = x + levelSizeX;
		shapeY[7] = y - squareSizeY;
		
		shapeX[8] = x + levelSizeX;
		shapeY[8] = y;
		
		// Then the candies starting from upper-right corner of Level-Box.
		// Candy One
		shapeX[9] = x + levelSizeX + squareSizeX;
		shapeY[9] = y;
		
		shapeX[10] = x + levelSizeX + squareSizeX;
		shapeY[10] = y - squareSizeY;
		
		// Candy Two
		shapeX[11] = x + levelSizeX + squareSizeX * 2;
		shapeY[11] = y - squareSizeY;
		
		shapeX[12] = x + levelSizeX + squareSizeX * 2;
		shapeY[12] = y;
		
		// repeat for future candys....
	}
	
	public float getGUISizeY() { return squareSizeY; }
}