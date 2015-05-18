package view.gameStates;

import view.GameManager;

import com.badlogic.gdx.Gdx;
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
	public MainMenu(GameManager gm) {
		this.gm = gm;
		
		batch = new SpriteBatch();

		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("src/main/java/view/fonts/OpenSans-CondLight.ttf"));
		
		titleFont = gen.generateFont(56);
		titleFont.setColor(Color.YELLOW);
		
		textFont = gen.generateFont(40);
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
		
		
//		handleInput();
		
		// Start to draw strings.
		batch.setProjectionMatrix(gm.getCam().combined);
		batch.begin();
		
		layout.setText(titleFont, title);
		float width = layout.width;// contains the width of the current set text
		
		// Draw title
		titleFont.draw(batch, title, (gm.getWidth() - width) / 2, 450);
		
		// Draw menuitems
		for(int i = 0; i < menuItems.length; i++) {
			layout.setText(textFont, menuItems[i]);
			width = layout.width;
			if(currentItem == i) textFont.setColor(Color.RED);
			else textFont.setColor(Color.WHITE);
			textFont.draw(batch, menuItems[i], (gm.getWidth() - width) / 2, 350-(i*50));
		}
		
		batch.end();
	}
	
	// Called by a controller when user press specific key in MainMenu.
	public String handleInput(String key) {
		
		if(key.equals("Up")) {
			if(currentItem > 0) currentItem--;
			return "Up";
		}
		else if(key.equals("Down")) {
			if(currentItem < menuItems.length - 1){
				currentItem++;
				return "Down";
			}
		}
		else if(key.equals("Enter")) {
			select();
			return menuItems[currentItem];
		}
		return "Error, Controller called MainMenu.handleInput with unknown parameter";
	}
	
	private void select() {
		
		// Play
		if (currentItem == 0) {
			gm.dispose();
			gm.setScreen(gm.getPlayfieldView());
		}
		// Settings
		else if (currentItem == 1) {
//			gsm.setScreen(gm.MENU_SETTINGS);
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