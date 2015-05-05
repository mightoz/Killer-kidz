//package view.gameStates;
//
//import view.GameViewStateManager;
//
//public abstract class GameState {
//
//	protected GameViewStateManager gsm;
//	
//	protected GameState(GameViewStateManager gsm) {
//		this.gsm = gsm;
//		init();
//	}
//	
//	// init gets called when the GameState first start up
//	public abstract void init();
//	
//	// update & draw are the methods we will call to do render-stuff
//	public abstract void update(float dt);
//	public abstract void draw();
//	
//	// handleinput will handle inputs like pressing "startNewGame" and such.
//	public abstract void handleInput();
//	
//	// we want to remove current window and show new one.
//	public abstract void dispose();
//	
//}
