package view.gameStates.playfieldGUI;

import com.badlogic.gdx.graphics.Texture;
import model.Model;

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

    private Texture shopToProtect;
    private SpriteBatch spriteBatch;
	
	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont textFont;
	
	private Model model;

	private OrthographicCamera cam;
	
	private int remainingLives;
	private String lives;
	private String livesLeft;
	
	@SuppressWarnings("deprecation")
	public ShopToProtect(OrthographicCamera cam, Model model, GUI_Foundation gui, float height) {

		this.cam = cam;
		this.model = model;
		
		batch = new SpriteBatch();
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("src/main/resources/fonts/OpenSans-CondLight.ttf"));
		
		textFont = gen.generateFont(22);
		textFont.setColor(Color.WHITE);

		// endpoint for box (upper right corner)
		x = 45;
		y = height - gui.getSquareSizeY() + 1;

		livesLeft = "Lives left:";

        spriteBatch = new SpriteBatch();
        loadTextures();

	}

    private void loadTextures() {
        shopToProtect = new Texture(Gdx.files.internal("images/toystore.png"));
    }

    // Draw an box "shop" from bottomleft to the GUI border at top.
	public void render(ShapeRenderer sr) {

        spriteBatch.begin();
        drawShopToProtect();
        spriteBatch.end();
		
		// Update remainingLives.
		remainingLives = model.getLevel().getMaxKidsInStore() - model.getLevel().getKidsInStore();
		lives = Integer.toString(remainingLives);

		// Start to draw strings.
		batch.setProjectionMatrix(cam.combined);
		batch.begin();

		// Draw title
		textFont.draw(batch, lives, (x / 2) + 100, (y / 30) * 29);
		textFont.draw(batch, livesLeft, (x / 2) + 30, (y / 30) * 29);

		batch.end();
		
		// Draw the line to easier see lives for themself.
		sr.setColor(1, 1, 1, 1);
		sr.begin(ShapeType.Line);

		sr.end();
	}

    private void drawShopToProtect() {
        spriteBatch.draw(shopToProtect,0,0, 45, 420);
    }

}
