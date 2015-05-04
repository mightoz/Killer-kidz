//import edu.chl.change2projectname.controller.ProjectController;
//import edu.chl.change2projectname.model.Project;
//import edu.chl.change2projectname.view.ProjectView;
//import javax.swing.SwingUtilities;
//
///*
//  Application entry class (if using standard java and Swing)
//*/
//public final class Main {
//	private Main() {
//		/* No instances allowed! */
//	}
//
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(() -> {
//                    final Project project = new Project();
//                    final ProjectView projectView = new ProjectView(project);
//                    
//                    ProjectController.create(project, projectView);
//                    projectView.setVisible(true);
//                });
//	}
//}

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import controller.Controller;
import model.Model;
import view.GameView;

public class Main {
	
	

	public static void main(String[] args) {
		System.out.println("Start");
		LwjglApplicationConfiguration cfg =
				new LwjglApplicationConfiguration();
		
		cfg.title = GameView.TITLE;
		cfg.width = GameView.W_WIDTH;
		cfg.height = GameView.W_HEIGHT;
		cfg.resizable = false;
		
		Model model = new Model(); // default constructor is missing.
		GameView gv = new GameView();
		Model.register(gv);
		
		new LwjglApplication(gv, cfg);
//		LwjglApplication app = new LwjglApplication(gv, cfg);
		
		new Controller(model, gv);
	}
}