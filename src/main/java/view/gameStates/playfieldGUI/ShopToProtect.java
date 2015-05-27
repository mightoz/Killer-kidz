package view.gameStates.playfieldGUI;

//import view.GameManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/** 
 * ShopToProtect
 * This class is responisble is to draw the shop to the left, which the player(s)
 * is to protect from kids. Which contains a red box, and an indicator of how many
 * kids the player may accidently let pass.
 * 
 * @author  Kim Berger
 * @version 1.0
 */
public class ShopToProtect extends GUI_Super {
	
	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont textFont;
	
	// used to get cam.
//	private GameManager gm;
	private OrthographicCamera cam;
	
	private String lives;
	private String shopText;
	
	@SuppressWarnings("deprecation")
	public ShopToProtect(OrthographicCamera cam, GUI gui, int height) {

		this.cam = cam;
		
		batch = new SpriteBatch();
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("src/main/java/view/fonts/OpenSans-CondBold.ttf"));
		
		textFont = gen.generateFont(22);
		textFont.setColor(Color.WHITE);

		// endpoint for box (upper right corner)
		x = 45;
		y = height - gui.getGUISizeY() + 1;
		
		lives = "5";
		shopText = "T\no\ny\ns\n \nR\n \nu\ns";

	}


	/*
	 * Draw an box "shop" from bottomleft to the GUI border at top.
	 */
	public void render(ShapeRenderer sr) {

		sr.setColor(Color.MAROON);
		
		sr.begin(ShapeType.Filled);
		sr.box(0, 0, 0, x, y, 0);
		sr.end();

		// Start to draw strings.
		batch.setProjectionMatrix(cam.combined);
		batch.begin();

		// Draw title
		textFont.draw(batch, lives, (x / 2) - 6, (y / 30) * 29);
		textFont.draw(batch, shopText, (x / 2) - 6, (y / 30) * 24);

		batch.end();
		
		// Draw the line to easier see lives for themself.
		sr.setColor(1, 1, 1, 1);
		sr.begin(ShapeType.Line);
		
		sr.line(0, (y / 30) * 27, x, (y / 30) * 27);;
		
		sr.end();
	}

}
