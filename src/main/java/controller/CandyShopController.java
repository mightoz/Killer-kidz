package controller;

import core.GameManager;
import model.Model;

class CandyShopController {
	
	private GameManager gm;
	private Model model;
	private boolean finished;		// will be set true when user presses finished

	CandyShopController(GameManager gm, Model model) {
		this.gm = gm;
		this.model = model;
		finished = false;
	}
	
	boolean keyUp(int keycode) {
		return true;
	}
	
	boolean isFinished() {
		return finished;
	}
	
}
