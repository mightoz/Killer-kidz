package view.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * MainMenu
 * This class is responsible to draw the mainMenu the user will see when he/she
 * starts the game.
 * 
 * @author  Kim Berger
 * @version 1.0
 */
public class MainMenu implements Screen {

	// used to get cam which is needed to draw batches os strings.
	private OrthographicCamera cam;
	
	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont titleFont;
	private BitmapFont textFont;
	private float width;
	
	// This is used to add strings to view (we use it to get center of each string
	// so the text will be centered in the menu).
	GlyphLayout layout = new GlyphLayout();
	
	private static final String title = "KillerKids";
	private int currentItem;
	private String[] menuItemsList;

	@SuppressWarnings("deprecation")
	public MainMenu(OrthographicCamera cam, float width) {
		
		this.cam = cam;
		this.width = width;
		
		batch = new SpriteBatch();

		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("src/main/resources/fonts/OpenSans-CondLight.ttf"));
		
		titleFont = gen.generateFont(56);
		titleFont.setColor(Color.YELLOW);
		
		textFont = gen.generateFont(40);
		textFont.setColor(Color.WHITE);
		
		menuItemsList = new String[] {
				"Play",
				"Settings",
				"HighScore",
				"HowToPlay",
				"Quit"
		};
	}
	
	@Override
	public void render(float delta) {
		
		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Start to draw strings.
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		layout.setText(titleFont, title);
		
		// contains the width of the current set text
		float layoutWidth = layout.width;
		
		// Draw title
		titleFont.draw(batch, title, (width - layoutWidth) / 2, 450);
		
		// Draw menuitems
		for(int i = 0; i < menuItemsList.length; i++) {
			layout.setText(textFont, menuItemsList[i]);
			layoutWidth = layout.width;
			if(currentItem == i) textFont.setColor(Color.RED);
			else textFont.setColor(Color.WHITE);
			textFont.draw(batch, menuItemsList[i], (width - layoutWidth) / 2, 350-(i*50));
		}
		
		batch.end();
	}
	
	public int getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(int currentItem) {
		this.currentItem = currentItem;
	}
	
	public String[] getMenuItems() {
		return menuItemsList;
	}

	public void setMenuItems(String[] menuItems) {
		this.menuItemsList = menuItems;
	}

	@Override
	public void hide() {}
	@Override
	public void show() {}
	@Override
	public void resize(int arg0, int arg1) {}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void dispose() {}
}