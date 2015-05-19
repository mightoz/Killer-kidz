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
	private final MainMenu menu;
	
	public MainMenuController(Model model, GameManager view) {
		this.model = model;
		
		// Needs to wait for the GameManager to be done with creating a working
		// "shell", in this case, initialized the mainMenu object.
		while(!view.getgmStatus()) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		menu = view.getMainMenu();
		if (menu == null) {
			System.out.println("constr: menu is null");
		}
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public boolean keyUp(int keycode) {
		if (menu == null) {		// REMOVE THIS LATER
			System.out.println("menu is null");
		}
			
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
