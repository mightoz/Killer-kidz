import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import controller.MainMenuController;
import model.Model;
import view.GameManager;

public class Main {

	
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg =
				new LwjglApplicationConfiguration();
		
		Model model = new Model("Player1");
		GameManager gm = new GameManager();
		
		cfg.title = gm.TITLE;
		cfg.width = gm.getWidth();
		cfg.height = gm.getHeight();
		cfg.resizable = false;
		
		new LwjglApplication(gm, cfg);		
		new MainMenuController(model, gm);
	}
}

