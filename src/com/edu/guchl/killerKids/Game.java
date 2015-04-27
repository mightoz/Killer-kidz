package com.edu.guchl.killerKids;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.edu.guchl.killerKids.view.GameView;

public class Game {

	public static void main(String[] args) {
		
		LwjglApplicationConfiguration cfg =
				new LwjglApplicationConfiguration();
		
		cfg.title = GameView.TITLE;
		cfg.width = GameView.W_WIDTH;
		cfg.height = GameView.W_HEIGHT;
		cfg.resizable = false;
		
		new LwjglApplication(new GameView(), cfg);
	}
}
