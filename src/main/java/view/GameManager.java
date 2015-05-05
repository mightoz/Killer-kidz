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
	public int WIDTH = 640; // -------------------------------------------------- ändrade ifrån static, kolla krockar.
	public int HEIGHT = 480;
	
	// ---------------------------------------------------------------------------- Behöver vi dessa för framtiden? Isf. inte spara dom i view'n.
	public static final int MAIN_MENU = 1;
	public static final int MENU_HELP = 2;
	public static final int MENU_SETTINGS = 3;
	public static final int HIGHSCORE = 3;
	public static final int PLAY = 4;
	public static final int SHOP = 5;
	
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
	
	public OrthographicCamera getCam(){
		return cam;
	}
}
//import com.badlogic.gdx.ApplicationListener;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//
//
//public class GameView implements ApplicationListener {
//
//	public static final String TITLE = "KillerKids";
//	public static int WIDTH = 640;
//	public static int HEIGHT = 480;
//	
//	
//	// change gameStates
//	private GameViewStateManager gvsm;
//	
//	// We need this camera to see our game.
//	public static OrthographicCamera cam;
//	
//	
//	// Called one time at startup
//	public void create() {
//		
//		WIDTH = Gdx.graphics.getWidth();
//		HEIGHT = Gdx.graphics.getHeight();
//		
//		/*
//		 *  default cam look at origo with a box: (-1, -1) to (1, 1)
//		 *  so we make it our resolution-size with parameters,
//		 *  and then move camera to center of our window with translate,
//		 *  and lastly we have to update camera to see the change.
//		 */
//		cam = new OrthographicCamera(WIDTH, HEIGHT);
//		cam.translate(WIDTH / 2, HEIGHT / 2);
//		cam.update();
//		
//		// initiate our GameStateManager
//		gvsm = new GameViewStateManager();
//		
////		Gdx.input.setInputProcessor(controller);
//		
//	}
//
//	// "Gameloop" - you want to update gamelogic and draw stuff in here
//	// This is the main-renderer for our project.
//	public void render() {
//		
//		// clears the screen to black
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		
//		// getDeltaTime - info in ViewGameStateManager.update(dt);
//		// ------------------------------------------------------------------------ Måste ersättas, för view'n får inte hålla på med något annat än visa saker.
//		// long startTime = System.currentTimeMillis();
//		// System.out.println("Time elapsed in seconds = " + ((System.currentTimeMillis() - startTime) / 1000));
//		gvsm.update(Gdx.graphics.getDeltaTime());
//		
//		gvsm.draw();
////		tempMove();
////		controller.KeyEvent();
//		
//	}
//
//	public void pause() {}
//	public void resume() {}
//	public void dispose() {}
//	public void resize(int width, int height) {}
//}