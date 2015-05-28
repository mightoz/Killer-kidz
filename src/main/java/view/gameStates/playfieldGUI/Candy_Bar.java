package view.gameStates.playfieldGUI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import view.gameStates.playfieldGUI.GUI_Foundation;
import model.entity.players.Player;


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
	private float squareSizeX;
	private float squareSizeY;
	
	private Player player;
	
	public Candy_Bar(GUI_Foundation gui) {
		
		// Startpoint lower-left corner on the "candy-part" of the bar.
		x = gui.getCandyBarStartPointX();
		y = gui.getCandyBarStartPointY();
		
		// size of the square we will draw (same as GUI_Foundation).
		squareSizeX = gui.getSquareSizeX();
		squareSizeY = gui.getSquareSizeY();

		System.out.println("StartPointX: " + x);
		System.out.println("StartPointY: " + y);

//		shapeX = new float[13];
//		shapeY = new float[13];
	}

	public void render(ShapeRenderer sr) {
		
		sr.setColor(Color.ORANGE);
		
		sr.begin(ShapeType.Line);
		
		// First candy
		sr.rect(x, y, squareSizeX, squareSizeY);
		
		// Second candy
		sr.rect(x + squareSizeX, y, squareSizeX, squareSizeY);
		
		sr.end();
	}

}