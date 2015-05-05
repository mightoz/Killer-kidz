//package view;
//
//import view.gameStates.GameState;
//import view.gameStates.MainMenu;
//import view.gameStates.PlayfieldView;
//
///*
// * Denna koden skall anropas i n�gon ModelGameStateManager som avg�r om vi klarat 
// * en runda eller liknande, eller kanske i kontrollern, men lekte lite med den f�r att
// * f� kontroll p� hur den fungerar. 
// * ------------------------------------------------------------------------------------------------------------------------- OBS!
// */
//
///*
// * The class who has the responsability to tell gameView which state to show
// */
//public class GameViewStateManager {
//
//	// current game state
//	private GameState gameState;
//	
//	public static final int MAIN_MENU = 1;
//	public static final int MENU_HELP = 2;
//	public static final int MENU_SETTINGS = 3;
//	public static final int HIGHSCORE = 3;
//	public static final int PLAY = 4;
//	public static final int SHOP = 5;
//	
//	
//	private int currentState = 0;
//	
//	// Have Play as default for now (later we want to start in MainMenu)
//	public GameViewStateManager() {
//		setState(MAIN_MENU);
//	}
//	
//	// Switch between states if we change view to i.e. enter shop, mainMenu.
//	public void setState(int state) {
//		
//		if(gameState != null) {
//			gameState.dispose();
//		}
//		
//		// Using currentState to avoid moving the non-existing-character when 
//		// you are in a menu.
//		switch(state) {
//		case MAIN_MENU:		gameState = new MainMenu(this);
//							currentState = MAIN_MENU;
//							break;
//		case PLAY:			gameState = new PlayfieldView(this);
//							currentState = PLAY;
//							break;
//		case SHOP:			// switch to shop state.
//							break;
//		case MENU_HELP:		// switch to menu_help state.
//							break;
//		case MENU_SETTINGS: // switch to menu_settings state.
//							break;
//		}
//	}
//	
//	/*
//	 *  dt = the timespan between current frame and the last frame in seconds.
//	 *  i.e. the amount of time has passed since we last called GameView.render()
//	 *  so in other words, how much we need to move the game forward.
//	 */
//	public void update(float dt) {
//		gameState.update(dt);
//	}
//	
//	public void draw() {
//		gameState.draw();
//	}
//	
//}
