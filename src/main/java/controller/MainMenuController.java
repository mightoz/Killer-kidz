package controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import model.Model;
import view.GameManager;
import view.gameStates.MainMenu;

public class MainMenuController extends InputAdapter {

	private final Model model;
	private final GameManager view;
	private final MainMenu menu;
	
	public MainMenuController(Model model, GameManager view) {
		this.model = model;
		this.view = view;
		this.menu = this.view.getMainMenu();
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
				GameController gc = new GameController(model, 1);
				Gdx.input.setInputProcessor(gc);
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
