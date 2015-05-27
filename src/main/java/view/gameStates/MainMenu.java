package view.gameStates;

import view.GameManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class MainMenu implements Screen {

	// used to get cam which is needed to draw batches os strings.
	private OrthographicCamera cam;
	
	// Used for having strings on-screen.
	private SpriteBatch batch;
	private BitmapFont titleFont;
	private BitmapFont textFont;
	private int width;
	
	// This is used to add strings to view (we use it to get center of each string
	// so the text will be centered in the menu).
	GlyphLayout layout = new GlyphLayout();
	
	private static final String title = "KillerKids";
	private int currentItem;
	private String[] menuItemsList;

	@SuppressWarnings("deprecation") // ----------------------------------------- Får kolla upp senare.
	public MainMenu(OrthographicCamera cam, int width) {
		
		this.cam = cam;
		this.width = width;
		
		batch = new SpriteBatch();

		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("src/main/java/view/fonts/OpenSans-CondLight.ttf"));
		
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
		
//		handleInput();
		
		// Start to draw strings.
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		layout.setText(titleFont, title);
		float layoutWidth = layout.width;// contains the width of the current set text
		
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
	
//	// Called by a controller when user press specific key in MainMenu.
//	public String handleInput(String key) {
//		
//		switch(key) {
//		
//		case "Up":
//			if(currentItem > 0)	{ currentItem--; }
//			return "Up";
//		
//		case "Down":
//			if(currentItem < menuItemsList.length - 1) { currentItem++; }
//			return "Down";
//			
//		case "Enter":
//			select();
//			return menuItemsList[currentItem];
//			
//		default: 
//			return "Error, Controller called MainMenu.handleInput with unknown parameter";
//		}
//
//	}
//	
//	private void select() {
//		
//		switch(currentItem){
//
//		// Play
//		case 0:
//			gm.dispose();
//			gm.setScreen(gm.getPlayfieldView());
//			break;
//			
//		// Settings
//		case 1:
////			gm.setScreen(gm.MENU_SETTINGS);
//			break;
//			
//		// HighScore
//		case 2:
////			gm.setState(gm.HIGHSCORE);
//			break;
//			
//		// HowToPlay
//		case 3:
//			gm.dispose();
//			gm.setScreen(gm.getHowToPlayView());
//			break;
//			
//		// Quit
//		case 4:
//			Gdx.app.exit();
//			break;
//			
//		default: 
//			System.out.println("Error, MainMenu.select had selected an unkown string.");
//			break;
//		}
//	}
	
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