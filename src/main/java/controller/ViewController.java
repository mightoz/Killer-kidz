package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.GameView;

public class ViewController implements ActionListener {

	private Model model;
	private final GameView view;
	
	public ViewController(GameView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.paramString()) {
		case "newGame1p":
			this.model = new Model("Player");
			new KeyController(model);
			break;
		case "newGame2p":
			this.model = new Model("Player1", "Player2");
			new KeyController(model);
			break;
		default:
			System.out.println(e.paramString() + ": listener not yet implemented");
		}
	}
}
