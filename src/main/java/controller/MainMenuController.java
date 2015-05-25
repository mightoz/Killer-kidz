package controller;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import model.Model;
import view.GameManager;
import view.gameStates.MainMenu;

public class MainMenuController extends InputAdapter {

	private final Model model;
	private final GameManager gm;
	private final MainMenu menu;
	
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
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public boolean keyUp(int keycode) {			
		if (keycode == Keys.UP) {
			menu.handleInput("Up");
			return true;
		}
		else if (keycode == Keys.DOWN) {
			menu.handleInput("Down");
			return true;
		}
		else if (keycode == Keys.ENTER) {
			String choise = menu.handleInput("Enter");
			System.out.println("choise: " + choise);
			switch (choise) {
			case "Play":
				new GameController(model, 1);
				return true;
			case "Settings":
				return true;
			case "HighScore":
				return true;
			case "HowToPlay":
				return true;
			case "Quit":
				return true;
			}
		}
		return false;
	}

}
