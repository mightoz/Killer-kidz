package controller;

/**
 * Created by Oscar on 24/04/15.
 */
public class GameController implements KeyListener {
    private Model model;
    
    private final int P1_UP = KeyEvent.VK_UP;
    private final int P1_DOWN = KeyEvent.VK_DOWN;
    private final int P1_LEFT = KeyEvent.VK_LEFT;
    private final int P1_RIGHT = KeyEvent.VK_RIGHT;
    private final int P1_THROW = KeyEvent.VK_SPACE;

    public Controller(Model model) {
        this.model = model;
    }
}
