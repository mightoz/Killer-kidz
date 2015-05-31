package view.gameStates.playfieldGUI;

import model.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * CurrentLevel_Bar
 * 
 * This class is responsible for painting the currentLevel string in upper left
 * corner when the user has started a new game.
 * 
 * @author  Kim Berger
 * @version 1.0
 */
public class CurrentLevel_Bar extends GUI_Super {

	private OrthographicCamera cam;
	private Model model;
	
	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont textFont;	
	private String currentLevel;
	
	@SuppressWarnings("deprecation")
	public CurrentLevel_Bar(OrthographicCamera cam, Model model, float width, float height) {

		this.cam = cam;
		this.width = width;
		this.height = height;
		
		batch = new SpriteBatch();

		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("src/main/resources/fonts/OpenSans-CondLight.ttf"));
		
		textFont = gen.generateFont(22);
		textFont.setColor(Color.GREEN);
		
		currentLevel = "Level\n   "; //+ Model.getCurrentLevel();
		currentLevel += Integer.toString(model.getCurrentLevelNumber());
	}
		
	public void render() {
		
		// Start to draw strings.
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		// Draw title
		textFont.draw(batch, currentLevel, (width / 64), (height / 480) * 472);
		
		batch.end();
	}
}