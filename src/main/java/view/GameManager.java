package view;

import view.gameStates.MainMenu;
import view.gameStates.PlayfieldView;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;


// ------------------------------------------------------------------------------ Omvandlats till en Controller =P?
public class GameManager extends Game {

	public String title;
	private int width;
	private int height;
	private boolean gmIsStarted = false;
	
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
	private PlayfieldView playfieldView;
	
	public GameManager(int width, int height, String title){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	@Override
	public void create() {

		// Create the canvas with given width & height.
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		
		/*
		 * default cam look at origo with a box: (-1, -1) to (1, 1) so we make
		 * it our resolution-size with parameters, and then move camera to
		 * center of our window with translate, and lastly we have to update
		 * camera to see the change.
		 */
		cam = new OrthographicCamera(width, height);
		cam.translate(width / 2, height / 2);
		cam.update();
		
		// create an object for each "Game-State".
		mainMenuView = new MainMenu(this);
		playfieldView = new PlayfieldView(this);
		
		// Sets our mainMenu to be first screen we will see.
		setScreen(mainMenuView);
		
		// used for Controller who needs to wait for this libGDX shell to be done.
		gmIsStarted = true;
		
	}
	
	@Override
	public void render () {
		if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
	}
	
	public OrthographicCamera getCam(){	return cam;	}
	public int getWidth(){ return width; }
	public int getHeight(){	return height; }
	public MainMenu getMainMenu() { return mainMenuView; }
	public PlayfieldView getPlayfieldView() { return playfieldView; }
	public boolean getgmStatus() { return gmIsStarted; }
}