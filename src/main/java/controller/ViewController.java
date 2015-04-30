package controller;

import model.Model;
import view.GameView;

public class ViewController {

	Model model;
	GameView view;
	
	public ViewController(Model model, GameView view) {
		this.model = model;
		this.view = view;
		
		new KeyController(model);
	}
}
