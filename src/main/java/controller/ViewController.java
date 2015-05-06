package controller;

import model.Model;
import view.GameManager;

public class ViewController {

	Model model;
	GameManager view;
	
	public ViewController(Model model, GameManager view) {
		this.model = model;
		this.view = view;
		
		new KeyController(model);
	}
}
