import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import controller.MainMenuController;
import model.Model;
import view.GameManager;

public class Main {

	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final String TITLE = "KillerKids";
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg =
				new LwjglApplicationConfiguration();
		
		Model model = new Model("Player1", WIDTH, HEIGHT);
		GameManager gm = new GameManager(model, WIDTH, HEIGHT, TITLE);
		
		cfg.title = gm.title;
		cfg.width = gm.getWidth();
		cfg.height = gm.getHeight();
		cfg.resizable = false;
		cfg.samples = 16;
		
		new LwjglApplication(gm, cfg);		
		new MainMenuController(model, gm);
	}
}
