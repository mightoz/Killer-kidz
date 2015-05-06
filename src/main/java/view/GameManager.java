package view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

import view.gameStates.MainMenu;
import view.gameStates.PlayfieldView;


// ------------------------------------------------------------------------------ Omvandlats till en Controller =P?
public class GameManager extends Game {

	public static final String TITLE = "KillerKids";
	private int WIDTH = 640;
	private int HEIGHT = 480;
	
	// ---------------------------------------------------------------------------- Behöver vi dessa för framtiden? Isf. inte spara dom i view'n.
//	public static final int MAIN_MENU = 1;
//	public static final int MENU_HELP = 2;
//	public static final int MENU_SETTINGS = 3;
//	public static final int HIGHSCORE = 3;
//	public static final int PLAY = 4;
//	public static final int SHOP = 5;
	
	// We need this camera to see our game.
	private static OrthographicCamera cam;
	
	// All types of "Game-States" we will see.
	private MainMenu mainMenuView;
	public PlayfieldView playfieldView;
	
	@Override
	public void create() {

		// Create the canvas with given width & height.
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
		/*
		 * default cam look at origo with a box: (-1, -1) to (1, 1) so we make
		 * it our resolution-size with parameters, and then move camera to
		 * center of our window with translate, and lastly we have to update
		 * camera to see the change.
		 */
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		cam.translate(WIDTH / 2, HEIGHT / 2);
		cam.update();
		
		// create an object for each "Game-State".
		mainMenuView = new MainMenu(this);
		playfieldView = new PlayfieldView(this);
		
		// Sets our mainMenu to be first screen we will see.
		setScreen(mainMenuView);
	}
	
	@Override
	public void render () {
		if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
	}
	
	// ------------------------------------------------------------------------------ Ta bort senare, har bara som referens, för att slippa kolla metoden online.
	/**
	 * Sets the current screen. {@link Screen#hide()} is called on any old
	 * screen, and {@link Screen#show()} is called on the new screen, if any.
	 * 
	 * @param screen
	 *            may be {@code null}
	 */
	public void setScreen (Screen screen) {
		if (this.screen != null) { 
			this.screen.hide(); 
			this.screen = screen;
		}
		if (this.screen != null) {
			this.screen.show();
			this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
	}
	
	public OrthographicCamera getCam(){	return cam;	}
	public int getWidth(){ return WIDTH; }
	public int getHeight(){	return HEIGHT; }
}