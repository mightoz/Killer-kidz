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
		titleFont.draw(batch, title, (GameManager.WIDTH - width) / 2, 300);
		
		// Draw menuitems
		for(int i = 0; i < menuItems.length; i++) {
			layout.setText(textFont, menuItems[i]);
			width = layout.width;
			if(currentItem == i) textFont.setColor(Color.RED);
			else textFont.setColor(Color.WHITE);
			titleFont.draw(batch, menuItems[i], (GameManager.WIDTH - width) / 2, 300);
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




//import view.GameViewManager;
//import view.GameViewStateManager;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.GlyphLayout;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
//
//public class MainMenu extends GameState {
//
////	private GameView gv = new GameView();
//	
//	// For the text
//	private SpriteBatch batch;
//	private BitmapFont titleFont;
//	private BitmapFont textFont;
//	
//	// Used to add strings to view.
//	GlyphLayout layout = new GlyphLayout(); //dont do this every frame! Store it as member
//	
//	private final String title = "KillerKids";
//	
//	private int currentItem;
//	private String[] menuItems;
//	
////	private int button1[]
//	
//	public MainMenu(GameViewStateManager gsm) {
//		super(gsm);
//	}
//
//	@SuppressWarnings("deprecation")
//	@Override
//	public void init() {
//		batch = new SpriteBatch();
//
//		
//		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
//				Gdx.files.internal("fonts/OpenSans-CondLight.ttf"));
//		
//		titleFont = gen.generateFont(56);
//		titleFont.setColor(Color.YELLOW);
//		
////		font = new BitmapFont();
//		textFont = gen.generateFont(20);
//		textFont.setColor(Color.WHITE);
//		
//		menuItems = new String[] {
//				"Play",
//				"Settings",
//				"HighScore",
//				"HowToPlay",
//				"Quit"
//		};
////		int fontSize = (int)(28 * Gdx.graphics.getDensity());
////        font = createFont(generator, 64);
////        generator.dispose();
//
//	}
//
//	// for now, only paints the player and then updates
//	@Override
//	public void update(float dt) {
//		
//		handleInput();
//	}
//
//	public void draw() {
//		
//		// Start to draw strings.
//		batch.setProjectionMatrix(GameViewManager.cam.combined);
//		batch.begin();
//		
//		
//		layout.setText(titleFont, title);
//		float width = layout.width;// contains the width of the current set text
//		float height = layout.height; // contains the height of the current set text
//		
//		// Draw title
//		titleFont.draw(batch, title, (GameViewManager.WIDTH - width) / 2, 300);
//		
//		// Draw menuitems
//		for(int i = 0; i < menuItems.length; i++) {
//			layout.setText(textFont, menuItems[i]);
//			width = layout.width;
//			if(currentItem == i) textFont.setColor(Color.RED);
//			else textFont.setColor(Color.WHITE);
//			titleFont.draw(batch, menuItems[i], (GameViewManager.WIDTH - width) / 2, 300);
//		}
//		
//		batch.end();
//		
//	}
//
//	@Override
//	public void handleInput() {
//		
//		if(Gdx.input.isKeyJustPressed(Keys.UP)) {
//			if(currentItem > 0) currentItem--;
//		}
//		if(Gdx.input.isKeyJustPressed(Keys.DOWN)) {
//			if(currentItem < menuItems.length - 1){
//				currentItem++;
//			}
//		}
//		if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
//			select();
//		}
//	}
//	
//	private void select() {
//		
//		// Play
//		if (currentItem == 0) {
//			gsm.setState(GameViewStateManager.PLAY);
//		}
//		// Settings
//		else if (currentItem == 1) {
////			gsm.setState(ViewGameStateManager.MENU_SETTINGS);
//		}
//		// HighScore
//		else if (currentItem == 2) {
////			gsm.setState(ViewGameStateManager.HIGHSCORE);
//		}
//		// HowToPlay
//		else if (currentItem == 3) {
////			gsm.setState(ViewGameStateManager.MENU_HELP);
//		}
//		// Quit
//		else if (currentItem == 4) {
//			Gdx.app.exit();
//		}
//	}
//	
//	@Override
//	public void dispose() {}
//}



