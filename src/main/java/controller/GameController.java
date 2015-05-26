package controller;

import model.Model;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;


public class GameController extends InputAdapter {
    private Model model;
    private final int nbrOfPlayers;
    
    private boolean[] p1Moves = {false, false, false, false};
    private boolean[] p2Moves = {false, false, false, false};

    private final int[] P1_LURD = new int[4];
    private final int[] P1_CANDY = {Keys.NUM_1, Keys.NUM_2, Keys.NUM_3, Keys.NUM_4};
    private final int P1_THROW = Keys.SPACE;
    private final int[] P2_LURD = new int [4];
    private final int[] P2_CANDY = {Keys.NUMPAD_1, Keys.NUMPAD_2, Keys.NUMPAD_3, Keys.NUMPAD_4};
    private final int P2_THROW = Keys.ENTER;
  
    public GameController(Model model, int nbrOfPlayers) {
        this.model = model;
    	this.nbrOfPlayers = nbrOfPlayers;

    	if (this.nbrOfPlayers == 1) {
    	    P1_LURD[0] = Keys.LEFT;
    	    P1_LURD[1] = Keys.UP;
    	    P1_LURD[2] = Keys.RIGHT;
    	    P1_LURD[3] = Keys.DOWN;
    	}
    	else if (this.nbrOfPlayers == 2) {
    	    P1_LURD[0] = Keys.A;
    	    P1_LURD[1] = Keys.W;
    	    P1_LURD[2] = Keys.D;
    	    P1_LURD[3] = Keys.S;
    	    P2_LURD[0] = Keys.LEFT;
    	    P2_LURD[1] = Keys.UP;
    	    P2_LURD[2] = Keys.RIGHT;
    	    P2_LURD[3] = Keys.DOWN;
    	}
    	else {
    		System.out.println("Number of players must be 1 or 2");
    	}
        
        Gdx.input.setInputProcessor(this);
        TimeController tc = new TimeController(model);
        tc.startLogic();
    }

    @Override
	public boolean keyDown(int keycode) {
        // If the player started to move
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
		
		// If any of the other keys was pressed, is wasn't handled.
		return false;
	}
	
    @Override
	public boolean keyUp(int keycode) {
        // If the player stopped moving
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
		
		// If the player changed candy
		for (int i = 0; i < 4; i++) {
			if(P1_CANDY[i] == keycode) {
				model.changeCandy(1, i+1);
				return true;
			}
		}
		if (nbrOfPlayers == 2) {
			for (int i = 0; i < 4; i++) {
				if(P2_CANDY[i] == keycode) {
					model.changeCandy(2, i+1);
					return true;
				}
			}
		}
		
		// If the player threw candy
		if (keycode == P1_THROW) {
			model.throwCandy(1);
			return true;
		}
		if (nbrOfPlayers == 2 && keycode == P2_THROW) {
			model.throwCandy(2);
			return true;
		}
		
		// If another key was released, it wasn't handled.
		return false;
	}
}
