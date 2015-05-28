package core;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import controller.MainMenuController;
import model.Model;

/**
 * Main
 * This class responsibility is to start the game, which is an LWJGL 
 * (LightWeight Java Game Library) application, which uses its graphics from
 * libGDX.
 * 
 * @author  Kim Berger
 * @version 1.0
 */

public class Main {

	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg =
				new LwjglApplicationConfiguration();
		
		/*
		 * The engine/brain behind our game, which connects most(all?) logic and
		 * data together before it shows its result to the player.
		 */
		Model model = new Model("Player1", WIDTH, HEIGHT);
		
		/*
		 * This is the "manager of the views" and its job is to manage which 
		 * view(state) to show by using an StatePattern, and then tells that 
		 * specific view to render.
		 */
		GameManager gm = new GameManager(model, WIDTH, HEIGHT);
		
		/*
		 * This is an configure to start the application, where most of it, 
		 * is obvius, except samples, which is Multisample Anti-Aliasing (MSAA)
		 * Which makes edges much more smoother.
		 */
		cfg.title = "KillerKidz";
		cfg.width = WIDTH;
		cfg.height = HEIGHT;
		cfg.resizable = false;
		cfg.samples = 16;
		
		new LwjglApplication(gm, cfg);
		new MainMenuController(model, gm);
	}
}
