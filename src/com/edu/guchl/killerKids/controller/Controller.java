package com.edu.guchl.killerKids.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
//import com.edu.guchl.killerKids.view.gameStates.PlayfieldView;
import com.edu.guchl.killerKids.model.Model;
import com.edu.guchl.killerKids.model.Player;

public class Controller implements KeyListener {
	Model model = new Model();
	
	public void KeyEvent() {
		if(Gdx.input.isKeyPressed(Keys.UP)){;
		model.movePlayer(Player.UP, 1);
			
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)){
			model.movePlayer(Player.DOWN, 1);
		}
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			model.movePlayer(Player.LEFT, 1);
		}
		
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			model.movePlayer(Player.RIGHT, 1);
		}
	}

	
	// We have pressed a key.
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_UP:
			System.out.println("UP");
			model.movePlayer(Player.UP, 1);
			break;

		case KeyEvent.VK_DOWN:
			System.out.println("DOWN");
			model.movePlayer(Player.DOWN, 1);
			break;

		case KeyEvent.VK_LEFT:
			System.out.println("LEFT");
			model.movePlayer(Player.LEFT, 1);
			break;

		case KeyEvent.VK_RIGHT:
			System.out.println("Right");
			model.movePlayer(Player.RIGHT, 1);
			break;
		}
	}

	// We have released a key.
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_UP:
			System.out.println("UP");
			model.movePlayer(Player.UP, 0);
			break;

		case KeyEvent.VK_DOWN:
			System.out.println("DOWN");
			model.movePlayer(Player.DOWN, 0);
			break;

		case KeyEvent.VK_LEFT:
			System.out.println("LEFT");
			model.movePlayer(Player.LEFT, 0);
			break;

		case KeyEvent.VK_RIGHT:
			System.out.println("Right");
			model.movePlayer(Player.RIGHT, 0);
			break;
		}
	}
	
	public void keyTyped(KeyEvent e) {}
}
