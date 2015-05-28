package view.gameStates.playfieldGUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
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
	
	// number box
	private float nbrBoxPosX;
	private float nbrBoxPosY;
	private float nbrBoxSize;
	
	// numberPos
	private float nbrPosX;
	private float nbrPosY;
	
	private Player player;
	
	// Using this for getting the cam-position.
	private OrthographicCamera cam;

	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont textFont;

	@SuppressWarnings("deprecation")
	public Candy_Bar(OrthographicCamera cam, GUI_Foundation gui) {
		
		this.cam = cam;
		
		// Startpoint lower-left corner on the "candy-part" of the bar.
		x = gui.getCandyBarStartPointX();
		y = gui.getCandyBarStartPointY();
		
		// size of the square we will draw (same as GUI_Foundation).
		squareSizeX = gui.getSquareSizeX();
		squareSizeY = gui.getSquareSizeY();

		// The small box with corresponding number to candy.
		nbrBoxSize = 20;
		nbrBoxPosX = x + squareSizeX - nbrBoxSize;
		nbrBoxPosY = y + squareSizeY - nbrBoxSize;
		
		nbrPosX = nbrBoxPosX + (nbrBoxSize / 3);
		nbrPosY = nbrBoxPosY + ((nbrBoxSize / 5) * 4);
		
		batch = new SpriteBatch();

		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("src/main/resources/fonts/OpenSans-CondLight.ttf"));
		
		textFont = gen.generateFont(20);
		
	}

	/*
	 * So candyBar first paints all unlocked candies, and give colors to the
	 * chosen candy (rest will be gray), and also shows a corresponding number
	 * to unlocked candies.
	 */
	public void render(ShapeRenderer sr) {
		
		
		// Start to draw strings.
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		sr.setColor(Color.GREEN);
		
		sr.begin(ShapeType.Line);
		
		// Unlocked one candy, so paintorder: outerBox, number-box, number
//		if(player.getCandyData().size() == 1){
		if(true) {
			
			sr.rect(x, y, squareSizeX, squareSizeY);
			sr.rect(nbrBoxPosX, nbrBoxPosY, nbrBoxSize, nbrBoxSize);
			textFont.draw(batch, "1", nbrPosX, nbrPosY);
		}
		
		// unlocked two candies
//		if(player.getCandyData().size() == 2){	
		if(true) {
			
			sr.rect(x + squareSizeX, 
					y, 
					squareSizeX, 
					squareSizeY);
			
			sr.rect(nbrBoxPosX + squareSizeX, 
					nbrBoxPosY, 
					nbrBoxSize, 
					nbrBoxSize);
			
			textFont.draw(batch, "2", 
					nbrPosX + squareSizeX, 
					nbrPosY);
		}
		
		// unlocked three candies
//		if (player.getCandyData().size() == 3) {
		if(true) {

			sr.rect(x + squareSizeX * 2, y, squareSizeX, squareSizeY);
			
			sr.rect(nbrBoxPosX + squareSizeX*2, 
					nbrBoxPosY, 
					nbrBoxSize, 
					nbrBoxSize);
			
			textFont.draw(batch, "3", 
					nbrPosX + squareSizeX*2, 
					nbrPosY);
		}


		
//		sr.end();
		
		textFont.setColor(Color.YELLOW);
		
		//
		sr.setColor(Color.ORANGE);
		
//		sr.begin(ShapeType.Line);
		
		// determine which candy is selected, and show that.
//		switch(player.getSelectedCandy()){
		int one = 1;
		switch(one){
		
		// First candy
		case 1:
			sr.rect(x, y, squareSizeX, squareSizeY);
			sr.rect(nbrBoxPosX, nbrBoxPosY, nbrBoxSize, nbrBoxSize);
			break;
			
		// Second candy is selected
		case (2):
			System.out.println("test");
			sr.rect(x + squareSizeX, y, squareSizeX, squareSizeY);
			sr.rect(nbrBoxPosX + squareSizeX*2, 
					nbrBoxPosY + squareSizeY*2, 
					nbrBoxSize, 
					nbrBoxSize);
			break;
			
		// Third candy is selected
		case 3:
			break;
			
		default:
//			System.out.println("Candy_Bar.render: "
//					+ "tried to select a candy which don't exists, number: " 
//					+ player.getSelectedCandy());
			break;
		}
		
		batch.end();
		sr.end();
	}

}