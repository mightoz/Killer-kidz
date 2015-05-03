import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import controller.ViewController;
import model.Model;
import view.GameView;

public class Main {

	public static void main(String[] args) {
		System.out.println("Start");
		LwjglApplicationConfiguration cfg =
				new LwjglApplicationConfiguration();
		
		cfg.title = GameView.TITLE;
		cfg.width = GameView.WIDTH;
		cfg.height = GameView.HEIGHT;
		cfg.resizable = false;
		
		Model model = new Model("Player1"); // default constructor is missing.
		GameView gv = new GameView();
		
		new LwjglApplication(gv, cfg);		
		new ViewController(model, gv);
	}
}