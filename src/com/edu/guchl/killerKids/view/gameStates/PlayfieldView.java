package com.edu.guchl.killerKids.view.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
	
	

	// for now, only paints the player and updates 
	@Override
	public void update(float dt) {
		
		handleInput();
		
		player.update(dt);
	}

	@Override
	public void draw() {
		player.draw(sr);
	}

	/*
	 * Temporärt bara lyssnar på key-events, får flytta bort hel senare
	 * 
	 */
	@Override
	public void handleInput() {
		player.setUp(Gdx.input.isKeyPressed(Keys.UP));
		player.setDown(Gdx.input.isKeyPressed(Keys.DOWN));
		player.setLeft(Gdx.input.isKeyPressed(Keys.LEFT));
		player.setRight(Gdx.input.isKeyPressed(Keys.RIGHT));
	}

	@Override
	public void dispose() {}

}
