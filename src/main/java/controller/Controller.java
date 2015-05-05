package controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import model.Model;
import view.GameManager;



/*
 * Class for Kim, used it from start, but will be removed as soon as View:s
 * dependency on it, is removed and fixed.
 * 
 */
public class Controller implements InputProcessor {
	
	Model model;
	GameManager gv;
//	LwjglApplication app;
	
	/*
	 * Temporary fields, that controller (or model) will send to view, because
	 * view should not do calculations.
	 */
	private int x = 0;
	private int y = 0;
	private int player = 1;
	
	public Controller() {
		
	}
	
	public Controller(Model model, GameManager gv) {
		this.model = model;
//		this.gv = gv;
		this.gv = gv;
//		new LwjglApplication(new GameView(), cfg);
		System.out.println("Controller:created");
	}

	
	
//	public void KeyEvent() {
//		if(player == 1) {
//			
//			if(Gdx.input.isKeyPressed(Keys.UP)){;
//			y += 1;
//				System.out.println("1");
//			}
//			
//			if(Gdx.input.isKeyPressed(Keys.DOWN)){
//				y -= 1;
//			}
//			
//			if(Gdx.input.isKeyPressed(Keys.LEFT)){
//				x -= 1;
//			}
//			
//			if(Gdx.input.isKeyPressed(Keys.RIGHT)){
//				x += 1;
//			}
//			
//			gv.movePlayer(player, x, y);
//		}
//		
//	}

	public boolean keyDown(int keycode) {
		if (player == 1) {

			if (keycode == Keys.UP) {
				y += 1;
				System.out.println("u");
			}

			if (keycode == Keys.DOWN) {
				y -= 1;
				System.out.println("d");
			}

			if (keycode == Keys.LEFT) {
				x -= 1;
				System.out.println("l");
			}

			if (keycode == Keys.RIGHT) {				
				x += 1;
				System.out.println("r");
			}

//			System.out.println("test");
//			System.out.println("x,y = " + x + ", " + y);
//			System.out.println("Player: " + player);
//			System.out.println("gv: " + gv);
//			gv.movePlayer(player, x, y);
		}
		
		return true;
	}

	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	
//	// We have pressed a key.
//	public void keyPressed(KeyEvent e) {
//			if(player == 1) {
//			
//			if(Gdx.input.isKeyPressed(Keys.UP)){;
//			y += 1;
//				System.out.println("1");
//			}
//			
//			if(Gdx.input.isKeyPressed(Keys.DOWN)){
//				y -= 1;
//			}
//			
//			if(Gdx.input.isKeyPressed(Keys.LEFT)){
//				x -= 1;
//			}
//			
//			if(Gdx.input.isKeyPressed(Keys.RIGHT)){
//				x += 1;
//			}
//			
//			gv.movePlayer(player, x, y);
//		}
//	}
//
//	// We have released a key.
//	public void keyReleased(KeyEvent e) {
//			if(player == 1) {
//			
//			if(Gdx.input.isKeyPressed(Keys.UP)){;
//			y += 1;
//				System.out.println("1");
//			}
//			
//			if(Gdx.input.isKeyPressed(Keys.DOWN)){
//				y -= 1;
//			}
//			
//			if(Gdx.input.isKeyPressed(Keys.LEFT)){
//				x -= 1;
//			}
//			
//			if(Gdx.input.isKeyPressed(Keys.RIGHT)){
//				x += 1;
//			}
//			
//			gv.movePlayer(player, x, y);
//		}
//	}
//	
//	public void keyTyped(KeyEvent e) {}
}
