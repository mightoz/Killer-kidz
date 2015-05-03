package view.gameStates;

import view.GameView;
import view.ViewGameStateManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class MainMenu extends GameState {

//	private GameView gv = new GameView();
	
	// For the text
	private SpriteBatch batch;
	private BitmapFont titleFont;
	private BitmapFont textFont;
	
	// Used to add strings to view.
	GlyphLayout layout = new GlyphLayout(); //dont do this every frame! Store it as member
	
	private final String title = "KillerKids";
	
	private int currentItem;
	private String[] menuItems;
	
//	private int button1[]
	
	public MainMenu(ViewGameStateManager gsm) {
		super(gsm);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void init() {
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
//		int fontSize = (int)(28 * Gdx.graphics.getDensity());
//        font = createFont(generator, 64);
//        generator.dispose();

	}

	// for now, only paints the player and then updates
	@Override
	public void update(float dt) {
		
		handleInput();
	}

	public void draw() {
		
		// Start to draw strings.
		batch.setProjectionMatrix(GameView.cam.combined);
		batch.begin();
		
		
		layout.setText(titleFont, title);
		float width = layout.width;// contains the width of the current set text
		float height = layout.height; // contains the height of the current set text
		
		// Draw title
		titleFont.draw(batch, title, (GameView.WIDTH - width) / 2, 300);
		
		// Draw menuitems
		for(int i = 0; i < menuItems.length; i++) {
			layout.setText(textFont, menuItems[i]);
			width = layout.width;
			if(currentItem == i) textFont.setColor(Color.RED);
			else textFont.setColor(Color.WHITE);
			titleFont.draw(batch, menuItems[i], (GameView.WIDTH - width) / 2, 300);
		}
		
		batch.end();
		
	}

	@Override
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
			gsm.setState(ViewGameStateManager.PLAY);
		}
		// Settings
		if (currentItem == 1) {
//			gsm.setState(ViewGameStateManager.MENU_SETTINGS);
		}
		// HighScore
		if (currentItem == 1) {
//			gsm.setState(ViewGameStateManager.HIGHSCORE);
		}
		// HowToPlay
		if (currentItem == 1) {
//			gsm.setState(ViewGameStateManager.MENU_HELP);
		}
		// Quit
		if (currentItem == 1) {
			Gdx.app.exit();
		}
	}
	
	@Override
	public void dispose() {}
}



