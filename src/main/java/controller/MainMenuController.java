package controller;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import model.Model;
import view.GameManager;
import view.gameStates.MainMenu;

/**
 * MainMenuController
 * @author  MarieKlevedal
 * @version 1.0
 */
public class MainMenuController extends InputAdapter {

	private final Model model;
	private final GameManager gm;
	private final MainMenu menu;
	private MainMenuStates state;
	
	public MainMenuController(Model model, GameManager gm) {
		this.model = model;
		this.gm = gm;
		
		// Needs to wait for the GameManager to be done with creating a working
		// "shell", in this case, initialized the mainMenu object.
		while(!this.gm.getgmStatus()) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		menu = this.gm.getMainMenu();
		state = MainMenuStates.MENU;
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public boolean keyUp(int keycode) {			
		switch(state) {
		case MENU:
			return handleMain(keycode);
		case SETTINGS:
			return handleSettings(keycode);
		case HIGHSCORE:
			return handleHighscore(keycode);
		case HOW_TO_PLAY:
			return handleHowToPlay(keycode);
		}
		return false;
	}
	
	private boolean handleMain(int keycode) {
		switch (keycode) {
		case Keys.UP:
			menu.handleInput("Up");
			return true;
		case Keys.DOWN:
			menu.handleInput("Down");
			return true;
		case Keys.ENTER:
			String choise = menu.handleInput("Enter");
			switch (choise) {
			case "Play":
				new GameController(model, 1);
				return true;
			case "Settings":
				state = MainMenuStates.SETTINGS;
				return true;
			case "HighScore":
				state = MainMenuStates.HIGHSCORE;
				return true;
			case "HowToPlay":
				state = MainMenuStates.HOW_TO_PLAY;
				return true;
			case "Quit":
				return true;
			}
		}
		return false;
	}
	
	private boolean handleSettings(int keycode) {
		return false;
	}
	
	private boolean handleHighscore(int keycode) {
		return false;
	}
	
	private boolean handleHowToPlay(int keycode) {
		return false;
	}
	
}
