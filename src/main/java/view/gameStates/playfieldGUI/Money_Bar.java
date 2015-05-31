package view.gameStates.playfieldGUI;

import model.entity.players.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/** 
 * Money_Bar
 * This class is responsible is to paint the money-string in upper right corner.
 * 
 * @author  Kim Berger
 * @version 1.0
 */
public class Money_Bar extends GUI_Super{
	
	// Using this for getting the cam-position.
	private OrthographicCamera cam;
	private Player player;
	
	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont textFont;
	
	@SuppressWarnings("deprecation")
	public Money_Bar(OrthographicCamera cam, Player player, float width, float height) {

		this.width = width;
		this.height = height;
		this.cam = cam;
		this.player = player;
		
		batch = new SpriteBatch();

		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("src/main/resources/fonts/OpenSans-CondLight.ttf"));
		
		textFont = gen.generateFont(24);
		textFont.setColor(Color.YELLOW);		
	}
		
	public void render() {
		
		// Start to draw strings.
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		// Draw title
		textFont.draw(batch,
				Integer.toString(player.getMoney()),
				(width / 128) * 111,
				(height / 24) * 23);
		
		batch.end();
	}
}
