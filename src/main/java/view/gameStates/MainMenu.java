package view.gameStates;

import view.GameManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class MainMenu implements Screen {

	private GameManager gm;
	
	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont titleFont;
	private BitmapFont textFont;
	
	// This is used to add strings to view (we use it to get center of each string
	// so the text will be centered in the menu).
	GlyphLayout layout = new GlyphLayout();
	
	private final String title = "KillerKids";
	private int currentItem;
	private String[] menuItems;
	
	@SuppressWarnings("deprecation") // ----------------------------------------- Får kolla upp senare.
	public MainMenu(GameManager gvm) {
		this.gm = gvm;
		
		batch = new SpriteBatch();

		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("fonts/OpenSans-CondLight.ttf"));
		
		titleFont = gen.generateFont(56);
		titleFont.setColor(Color.YELLOW);
		
//		font = new BitmapFont();
		textFont = gen.generateFont(20);
		textFont.setColor(Color.WHITE);
		
		menuItems = new String[] {
				"Play",
				"Settings",
				"HighScore",
				"HowToPlay",
				"Quit"
		};
	}
	
	@Override
	public void render(float delta) {
		
		// Check for keyEvents.
		handleInput();
		
		// Start to draw strings.
		batch.setProjectionMatrix(gm.getCam().combined);
		batch.begin();
		
		layout.setText(titleFont, title);
		float width = layout.width;// contains the width of the current set text
		
		// Draw title
		titleFont.draw(batch, title, (gm.getWidth() - width) / 2, 300);
		
		// Draw menuitems
		for(int i = 0; i < menuItems.length; i++) {
			layout.setText(textFont, menuItems[i]);
			width = layout.width;
			if(currentItem == i) textFont.setColor(Color.RED);
			else textFont.setColor(Color.WHITE);
			titleFont.draw(batch, menuItems[i], (gm.getWidth() - width) / 2, 300);
		}
		
		batch.end();
	}
	
	// ---------------------------------------------------------------------------- Flytta till en Controller.
	public void handleInput() {
		
		if(Gdx.input.isKeyJustPressed(Keys.UP)) {
			if(currentItem > 0) currentItem--;
		}
		if(Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			if(currentItem < menuItems.length - 1){
				currentItem++;
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			select();
		}
	}
	
	private void select() {
		
		// Play
		if (currentItem == 0) {
			gm.setScreen(gm.playfieldView);
		}
		// Settings
		else if (currentItem == 1) {
//			gsm.setState(gm.MENU_SETTINGS);
		}
		// HighScore
		else if (currentItem == 2) {
//			gsm.setState(gm.HIGHSCORE);
		}
		// HowToPlay
		else if (currentItem == 3) {
//			gsm.setState(gm.MENU_HELP);
		}
		// Quit
		else if (currentItem == 4) {
			Gdx.app.exit();
		}
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