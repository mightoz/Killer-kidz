package com.edu.guchl.killerKids;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.edu.guchl.killerKids.controller.Controller;
import com.edu.guchl.killerKids.model.Model;
import com.edu.guchl.killerKids.view.GameView;

public class Game {
	
	

	public static void main(String[] args) {
		System.out.println("Start");
		LwjglApplicationConfiguration cfg =
				new LwjglApplicationConfiguration();
		
		cfg.title = GameView.TITLE;
		cfg.width = GameView.W_WIDTH;
		cfg.height = GameView.W_HEIGHT;
		cfg.resizable = false;
		
		Model model = new Model();
		GameView gv = new GameView();
		
		new LwjglApplication(gv, cfg);
//		LwjglApplication app = new LwjglApplication(gv, cfg);
		
		new Controller(model, gv);
	}
}