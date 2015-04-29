package com.edu.guchl.killerKids.view;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.edu.guchl.killerKids.controller.Controller;


public class GameView implements ApplicationListener {

	public static final String TITLE = "KillerKids";
	public static int W_WIDTH = 640;
	public static int W_HEIGHT = 480;
	
	Controller controller = new Controller(); // buttonlistener-handling.
	
	// change gameStates
	private ViewGameStateManager gsm;
	
	// We need this camera to see our game.
	public static OrthographicCamera cam;
	
	
	// Called one time at startup
	public void create() {
		
		W_WIDTH = Gdx.graphics.getWidth();
		W_HEIGHT = Gdx.graphics.getHeight();
		
		/*
		 *  default cam look at origo with a box: (-1, -1) to (1, 1)
		 *  so we make it our resolution-size with parameters,
		 *  and then move camera to center of our window with translate,
		 *  and lastly we have to update camera to see the change.
		 */
		cam = new OrthographicCamera(W_WIDTH, W_HEIGHT);
		cam.translate(W_WIDTH / 2, W_HEIGHT / 2);
		cam.update();
		
		// initiate our GameStateManager
		gsm = new ViewGameStateManager();
		
		Gdx.input.setInputProcessor(controller);
		
	}

	// "Gameloop" - you want to update gamelogic and draw stuff in here
	// This is the main-renderer for our project.
	public void render() {
		
		// clears the screen to black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// getDeltaTime - info in ViewGameStateManager.update(dt);
		gsm.update(Gdx.graphics.getDeltaTime());
		
		gsm.draw();
		tempMove();
//		controller.KeyEvent();
		
	}
	
	// takes new position for the player, and forwards it through the "Pipe"
	// to the Player object.
	public void movePlayer(int playerX, int newPosX, int newPosY) {
		gsm.updatePlayerPos(playerX, newPosX, newPosY);
	}
	
	/*
	 * Temporary until rest is working
	 */
	int playerPosX = W_WIDTH/3;
	int playerPosY = W_HEIGHT/2;
	public void tempMove() {
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			playerPosY += 3;
		}

		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			playerPosY -= 3;

		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			playerPosX -= 3;

		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			playerPosX += 3;

		}
		movePlayer(1, playerPosX, playerPosY);
	}

	public void pause() {}
	public void resume() {}
	public void dispose() {}
	public void resize(int width, int height) {}


}