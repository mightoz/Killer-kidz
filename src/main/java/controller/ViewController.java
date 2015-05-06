package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.GameManager;

public class ViewController implements ActionListener {

	private final Model model;
	private final GameManager view;
	
	public ViewController(Model model, GameManager view) {
		this.model = model;
		this.view = view;
		new KeyController(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		switch (e.paramString()) {
//		case "newGame1p":
//			this.model = new Model("Player");
//			new KeyController(model);
//			break;
//		case "newGame2p":
//			this.model = new Model("Player1", "Player2");
//			new KeyController(model);
//			break;
//		default:
//			System.out.println(e.paramString() + ": listener not yet implemented");
//		}
	}
}
