package controller;

import com.badlogic.gdx.Input.Keys;

import model.Model;

class CandyShopController {
	
    private Model model;
	private static final int[] LURD = {Keys.LEFT, Keys.UP, Keys.RIGHT, Keys.DOWN};
	private boolean finished;

	CandyShopController(Model model) {
        this.model = model;
		finished = false;
	}
	
	boolean keyUp(int keycode) {
		// Move marker
		for (int i = 0; i < 4; i++) {
			if (keycode == LURD[i]) {
                model.moveMarkerInStore(i);
				return true;
			}
		}
			
		if (keycode == Keys.ENTER) {
            if (model.getStatusInShop().equals("Next level")) { 
            	finished = true;
            	return true;
            }
            model.choose();
			return true;
		}
			
		return false;
	}
	
	boolean isFinished() {
		return finished;
	}
	
}
