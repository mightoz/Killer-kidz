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
		System.out.println("constructor called");
		this.model = model;
		this.view = view;
		this.menu = this.view.getMainMenu();
		Gdx.input.setInputProcessor(this);
		//GameController gc = new GameController(model);
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
			System.out.println(choise);
			return true;
		}
		return false;
	}


}
