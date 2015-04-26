package controller;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GameController implements KeyListener{
    
    private Model model;
    
    private final int P1_UP = KeyEvent.VK_UP;
    private final int P1_DOWN = KeyEvent.VK_DOWN;
    private final int P1_LEFT = KeyEvent.VK_LEFT;
    private final int P1_RIGHT = KeyEvent.VK_RIGHT;
    private final int P1_THROW = KeyEvent.VK_SPACE;

    public GameController(Model model) {
        this.model = model;
        TimeController tc = new TimeController(model);
    }

    public void keyPressed(KeyEvent e) {
    	switch (e.getKeyCode()) {
    	case P1_UP:
    		model.movePlayer(1, Direction.UP);
    		break;
    	case P1_DOWN:
        	model.movePlayer(1, Direction.DOWN);
    		break;
    	case P1_LEFT:
        	model.movePlayer(1, Direction.LEFT);
    		break;
    	case P1_RIGHT:
        	model.movePlayer(1, Direction.RIGHT);
    		break;
    	default:
    		// do nothing
    	}
    }
    
    public void	keyReleased(KeyEvent e) {
    	switch (e.getKeyCode()) {
    	case P1_THROW:
    		model.throwCandy();
    		break;
    	// TODO: case changeCandy
    	default:
    		// do nothing
    	}
    }
    
    public void keyTyped(KeyEvent e) {
    	// do nothing
    }

}