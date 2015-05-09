package controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import model.Model;
import view.GameManager;

public class MainMenuController extends InputListener {

	private final Model model;
	private final GameManager view;
	
	public MainMenuController(Model model, GameManager view) {
		this.model = model;
		this.view = view;
		new GameController(model);
	}
	
	public boolean keyUp(InputEvent event, int keycode) {
		if (keycode == Keys.UP) {
			// do stuff
			return true;
		}
		else if (keycode == Keys.DOWN) {
			// do stuff
			return true;
		}
		return false;
	}


}
