package controller;

import com.badlogic.gdx.Input.Keys;

import core.GameManager;
import model.Model;

class CandyShopController {
	
	//private CandyShop cs;
	private static final int[] LURD = {Keys.LEFT, Keys.UP, Keys.RIGHT, Keys.DOWN};
	private boolean finished;		// will be set true when user presses StartNextLevel

	CandyShopController(Model model) {
		//cs = model.getCandyShop();
		finished = false;
	}
	
	boolean keyUp(int keycode) {
		// Move marker
		for (int i = 0; i < 4; i++) {
			if (keycode == LURD[i]) {
				//cs.move(i);
				return true;
			}
		}
			
		if (keycode == Keys.ENTER) {
			finished = true; // cs.getCurrentRow() == 5;
			if (!finished) {
				//cs.choose();
			}
			return true;
		}
			
		return false;
	}
	
	boolean isFinished() {
		return finished;
	}
	
}
