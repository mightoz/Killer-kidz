package controller;

import model.Model;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class GameController extends InputAdapter {
    private Model model;
    private boolean[] p1Moves = {false, false, false, false};
    private boolean[] p2Moves = {false, false, false, false};
    
    private final int nbrOfPlayers;
    private final int[] P1_LURD = {Keys.LEFT, Keys.UP, Keys.RIGHT, Keys.DOWN};
    private final int P1_THROW = Keys.SPACE; 
    private final int[] P2_LURD = {Keys.A, Keys.W, Keys.D, Keys.S};
    private final int P2_THROW = Keys.CONTROL_LEFT;
  
    public GameController(Model model, int nbrOfPlayers) {
    	this.nbrOfPlayers = nbrOfPlayers;
        this.model = model;
        System.out.println("GC constructor called");
        Gdx.input.setInputProcessor(this);
        new TimeController(model);
    }

    @Override
	public boolean keyDown(int keycode) {
    	System.out.println("key down");
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
	
    @Override
	public boolean keyUp(int keycode) {
    	System.out.println("key up");
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
