package view;

import view.gameStates.HowToPlayView;
import view.gameStates.MainMenu;
import view.gameStates.PlayfieldView;
import model.Model;
import controller.TimeController;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameManager extends Game {

	private int width;
	private int height;
	private boolean gmIsStarted = false;
    private Model model;

	// We need this camera to see our game.
	private static OrthographicCamera cam;
	
	// All types of "Game-States" we will see.
	private MainMenu mainMenuView;
	private PlayfieldView playfieldView;
	private HowToPlayView howToPlayView;

	
	public GameManager(Model model, int width, int height){
        this.model = model;
		this.width = width;
		this.height = height;
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
		howToPlayView = new HowToPlayView(this);
        model.register(playfieldView);

		
		// Sets our mainMenu to be first screen we will see.
		setScreen(mainMenuView);
		
		// used for Controller who needs to wait for this libGDX initiater to be done.
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
	public HowToPlayView getHowToPlayView() {return howToPlayView; }
	public boolean getgmStatus() { return gmIsStarted; }
}