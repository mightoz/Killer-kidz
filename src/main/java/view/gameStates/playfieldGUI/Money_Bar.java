package view.gameStates.playfieldGUI;

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
	
	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont textFont;
	
	// This is used to add strings to view (we use it to get center of each string
	// so the text will be centered in the menu).
//	GlyphLayout layout = new GlyphLayout();
	
	private String money;
	
	@SuppressWarnings("deprecation") // ----------------------------------------- Får kolla upp senare.
	public Money_Bar(OrthographicCamera cam, float width, float height) {

		this.width = width;
		this.height = height;
		this.cam = cam;
		
		batch = new SpriteBatch();

		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("src/main/java/view/fonts/OpenSans-CondLight.ttf"));
		
//			font = new BitmapFont();
		textFont = gen.generateFont(24);
		textFont.setColor(Color.YELLOW);
		
		// ----------------------------------------------------------------------- Player måste ha en money-value, lägg till när det är dags för slippa konflikter med merge.
		money = "$$$$$"; //+ player.getMoney();
	}
		
	public void render() {
		
		// Start to draw strings.
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		// Draw title
		textFont.draw(batch, money, (width / 24) * 22, (height / 24) * 23); // ----------- Ta reda på mer korrekta koordinater.
		
		batch.end();
	}
}
