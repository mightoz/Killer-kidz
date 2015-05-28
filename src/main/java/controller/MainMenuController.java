package controller;

import core.GameManager;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import model.Model;

/**
 * MainMenuController
 * @author  MarieKlevedal
 * @version 1.0
 */
public class MainMenuController extends InputAdapter {

	private final Model model;
	private final GameManager gm;
	private MainMenuStates state;
	
	public MainMenuController(Model model, GameManager gm) {
		this.model = model;
		this.gm = gm;
		
		// Needs to wait for the GameManager to be done with creating a working
		// "shell", i.e. creating the views that the controller needs.
		while(!this.gm.getgmStatus()) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		state = MainMenuStates.MENU;
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public boolean keyUp(int keycode) {			
		switch(state) {
		case MENU:
			return mainController(keycode);
		case SETTINGS:
			return settingsController(keycode);
		case HIGHSCORE:
			return highscoreController(keycode);
		case HOW_TO_PLAY:
			return howToPlayController(keycode);
		}
		return false;
	}
	
	// Takes care of key input if user is in main menu
	private boolean mainController(int keycode) {
		switch (keycode) {
		case Keys.UP:
			gm.updateMenu("Up");
			return true;
		case Keys.DOWN:
			gm.updateMenu("Down");
			return true;
		case Keys.ENTER:
			String choise = gm.updateMenu("Enter");
			switch (choise) {
			case "Play":
				gm.dispose();
				gm.setScreen(gm.getPlayfieldView());
				new GameController(gm, model, 1);
				return true;
			case "Settings":
				//state = MainMenuStates.SETTINGS;
				return false;
			case "HighScore":
				//state = MainMenuStates.HIGHSCORE;
				return false;
			case "HowToPlay":
				gm.dispose();
				gm.setScreen(gm.getHowToPlayView());
				state = MainMenuStates.HOW_TO_PLAY;
				return true;
			case "Quit":
				Gdx.app.exit();
				return true;
			}
		}
		return false;
	}
	
	private boolean settingsController(int keycode) {
		return false;
	}
	
	private boolean highscoreController(int keycode) {
		return false;
	}
	
	// Handles the key input if user is viewing how to play
	private boolean howToPlayController(int keycode) {
		if (keycode == Keys.ENTER) {
			gm.dispose();
			gm.setScreen(gm.getMainMenu());
			state = MainMenuStates.MENU;
			return true;
		}
		return false;
	}
	
}
