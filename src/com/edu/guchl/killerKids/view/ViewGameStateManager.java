package com.edu.guchl.killerKids.view;

import com.edu.guchl.killerKids.view.gameStates.GameState;
import com.edu.guchl.killerKids.view.gameStates.MainMenu;
import com.edu.guchl.killerKids.view.gameStates.PlayfieldView;

/*
 * Denna koden skall anropas i någon ModelGameStateManager som avgör om vi klarat 
 * en runda eller liknande, eller kanske i kontrollern, men lekte lite med den för att
 * få kontroll på hur den fungerar. 
 * ------------------------------------------------------------------------------------------------------------------------- OBS!
 */

/*
 * The class who has the responsability to tell gameView which state to show
 */
public class ViewGameStateManager {

	// current game state
	private GameState gameState;
	
	public static final int MAIN_MENU = 0;
	public static final int PLAY = 1;
	public static final int SHOP = 2;
	public static final int MENU_HELP = 3;
	public static final int MENU_SETTINGS = 4;
	
	
	// Have Play as default for now (later we want to start in MainMenu)
	public ViewGameStateManager() {
		setState(MAIN_MENU);
	}
	
	// Switch between states if we change view to i.e. enter shop, mainMenu.
	public void setState(int state) {
		
		if(gameState != null) {
			gameState.dispose();
		}
		
		switch(state) {
		case MAIN_MENU:		// switch to mainMenu state.
							gameState = new MainMenu(this);
							break;
		case PLAY:			gameState = new PlayfieldView(this);
							break;
		case SHOP:			// switch to shop state.
							break;
		case MENU_HELP:		// switch to menu_help state.
							break;
		case MENU_SETTINGS: // switch to menu_settings state.
							break;
		}
	}
	
	/*
	 *  dt = the timespan between current frame and the last frame in seconds.
	 *  i.e. the amount of time has passed since we last called GameView.render()
	 *  so in other words, how much we need to move the game forward.
	 */
	public void update(float dt) {
		gameState.update(dt);
	}
	
	public void draw() {
		gameState.draw();
	}
	
}
