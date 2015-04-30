package com.edu.guchl.killerKids.view.gameStates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.edu.guchl.killerKids.view.ViewGameStateManager;
import com.edu.guchl.killerKids.view.inGameEntities.PlayerView;

public class PlayfieldView extends GameState {

	private ShapeRenderer sr;
	private PlayerView player;	
	
	public PlayfieldView(ViewGameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		sr = new ShapeRenderer();
		player = new PlayerView();
	}

	// Paints the player and updates for now (later it will also update arrays
	// with kids and candy)
	public void update(float dt, int newPosX, int newPosY) {
		player.update(dt, newPosX, newPosY);
	}

	@Override
	public void draw() {
		player.draw(sr);
	}

//	// Forwards the new playerPos to given player.
//	@Override
//	public void handleInput(int playerX, int newPosX, int newPosY) {
//		player.update(newPosX, newPosY);
//	}

	@Override
	public void dispose() { }

	@Override
	public void update(float dt) {
		player.update(dt);
	}

//	@Override
	public void handleInput(int playerX, int newPosX, int newPosY) {
		update(1, newPosX, newPosY);
	}
}
