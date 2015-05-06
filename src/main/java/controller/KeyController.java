package controller;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import model.Model;

public class KeyController implements KeyListener{
    
    private Model model;
    private boolean[] p1Moves = {false, false, false, false};
    private boolean[] p2Moves = {false, false, false, false};
    
    private final int[] P1_LURD = {KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN};
    private final int P1_THROW = KeyEvent.VK_SPACE;
    private final int[] P2_LURD = {KeyEvent.VK_A, KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S};
    private final int P2_THROW = KeyEvent.VK_CONTROL;

    public KeyController(Model model) {
        this.model = model;
    }

	// skicka array[4] med booleans LURD ist for direction
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	for (int i = 0; i < 4; i++) {
    		if (P1_LURD[i] == key) {
    			p1Moves[i] = true;
    			model.movePlayer(p1Moves, 1);
    		}
    	}
    	for (int i = 0; i < 4; i++) {
    		if (P2_LURD[i] == key) {
    			p2Moves[i] = true;
    			model.movePlayer(p2Moves, 1);
    		}
    	}
    }
    
    public void	keyReleased(KeyEvent e) {
    	int key = e.getKeyCode();
    	for (int i = 0; i < 4; i++) {
    		if (P1_LURD[i] == key) {
    			p1Moves[i] = false;
    			model.movePlayer(p1Moves, 1);
    		}
    	}
    	for (int i = 0; i < 4; i++) {
    		if (P2_LURD[i] == key) {
    			p2Moves[i] = false;
    			model.movePlayer(p2Moves, 2);
    		}
    	}
    	
    	if (key == P1_THROW) {
    		model.throwCandy(1);
    	}
    	if (key == P2_THROW) {
    		model.throwCandy(2);
    	}
    }
    
    public void keyTyped(KeyEvent e) {
    	// do nothing
    }
}