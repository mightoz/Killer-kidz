package view.gameStates.playfieldGUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class CurrentLevel_Bar extends GUI_Super {

	private OrthographicCamera cam;
	
	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont textFont;
	
	// This is used to add strings to view (we use it to get center of each string
	// so the text will be centered in the menu).
//	GlyphLayout layout = new GlyphLayout();
	
	private String currentLevel;
	
	@SuppressWarnings("deprecation") // ----------------------------------------- Får kolla upp senare.
	public CurrentLevel_Bar(OrthographicCamera cam, float width, float height) {

		this.cam = cam;
		this.width = width;
		this.height = height;
		
		batch = new SpriteBatch();

		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("src/main/java/view/fonts/OpenSans-CondBold.ttf"));
		
//			font = new BitmapFont();
		textFont = gen.generateFont(22);
		textFont.setColor(Color.GREEN);
		
		// ----------------------------------------------------------------------- Player måste ha en money-value, lägg till när det är dags för slippa konflikter med merge.
		currentLevel = "Level\n   1"; //+ Model.getCurrentLevel();
	}
		
	public void render() {
		
		// Start to draw strings.
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		// Draw title
		textFont.draw(batch, currentLevel, (width / 64), (height / 480) * 472); // ----------- Ta reda på mer korrekta koordinater.
		
		batch.end();
	}
}