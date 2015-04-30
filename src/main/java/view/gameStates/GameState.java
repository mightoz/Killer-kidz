package view.gameStates;

import view.ViewGameStateManager;

public abstract class GameState {

	protected ViewGameStateManager gsm;
	
	protected GameState(ViewGameStateManager gsm) {
		this.gsm = gsm;
		init();
	}
	
	// init gets called when the GameState first start up
	public abstract void init();
	
	// update & draw are the methods we will call to do render-stuff
	public abstract void update(float dt);
	public abstract void draw();
	
	// handleinput is an help method for update, to do stuff with gamekeys
	public abstract void handleInput(int playerX, int newPosX, int newPosY);
	
	// we want to remove current window and show new one.
	public abstract void dispose();
	
}
