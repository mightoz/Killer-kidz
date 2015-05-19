package view.gameStates.playfieldGUI;

import view.GameManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class ShopToProtect extends GUI_Super {
	
	// player id looks like (p.1) or something ------------------------------------ Kom fram till ett id-system eller använd objekt i anrop.
	private String id;
	
	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont textFont;
	
	// used to get cam.
	private GameManager gm;
	
	private String lives;
	private String shopText;
	
	public ShopToProtect(GameManager gm, GUI gui, float width, float height) {
		
		this.gm = gm;
		this.width = width;
		this.height = height;
		this.id = id; // ------------------------------------------------------- If we're gonna use this.
		
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
		
//		int lineWidth = 20;
//		Gdx.gl20.glLineWidth(lineWidth);
		
		sr.box(0, 0, 0, x, y, 0);

		sr.end();
		
		
		
		// Start to draw strings.
		batch.setProjectionMatrix(gm.getCam().combined);
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
