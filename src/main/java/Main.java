import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import controller.ViewController;
import model.Model;
import view.GameManager;

public class Main {

	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg =
				new LwjglApplicationConfiguration();
		
		cfg.title = GameManager.TITLE;
		cfg.width = GameManager.WIDTH;
		cfg.height = GameManager.HEIGHT;
		cfg.resizable = false;
		
		Model model = new Model("Player1");
		GameManager gv = new GameManager();
		
		new LwjglApplication(gv, cfg);		
		new ViewController(model, gv);
	}
}