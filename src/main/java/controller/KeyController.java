package controller;

import model.Model;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class KeyController extends InputListener {
    private Model model;
    private boolean[] p1Moves = {false, false, false, false};
    private boolean[] p2Moves = {false, false, false, false};
    
    private final int nbrOfPlayers = 1;		// NOTE: have to change soon
    private final int[] P1_LURD = {Keys.LEFT, Keys.UP, Keys.RIGHT, Keys.DOWN};
    private final int P1_THROW = Keys.SPACE; 
    private final int[] P2_LURD = {Keys.A, Keys.W, Keys.D, Keys.S};
    private final int P2_THROW = Keys.CONTROL_LEFT;
  
    public KeyController(Model model) {
        this.model = model;
        new TimeController(model);
        //nbrOfPlayers = this.model.getNbrOfPlayers();
    }

	public boolean keyDown(InputEvent e, int keycode) {
    	for (int i = 0; i < 4; i++) {
			if (P1_LURD[i] == keycode) {
				p1Moves[i] = true;
				model.movePlayer(1, p1Moves);
				return true;
			}
		}
		if (nbrOfPlayers == 2) {
	    	for (int i = 0; i < 4; i++) {
	    		if (P2_LURD[i] == keycode) {
	    			p2Moves[i] = true;
	    			model.movePlayer(2, p2Moves);
	    			return true;
	    		}
	    	}
		}
		return false;
	}
	
	public boolean keyUp(InputEvent event, int keycode) {
    	for (int i = 0; i < 4; i++) {
			if (P1_LURD[i] == keycode) {
				p1Moves[i] = false;
				model.movePlayer(1, p1Moves);
				return true;
			}
		}
		if (nbrOfPlayers == 2) {
	    	for (int i = 0; i < 4; i++) {
	    		if (P2_LURD[i] == keycode) {
	    			p2Moves[i] = false;
	    			model.movePlayer(2, p2Moves);
	    			return true;
	    		}
	    	}
		}
		
		if (keycode == P1_THROW) {
			model.throwCandy(1);
			return true;
		}
		if (nbrOfPlayers == 2 && keycode == P2_THROW) {
			model.throwCandy(2);
			return true;
		}
		
		return false;
	}
}
