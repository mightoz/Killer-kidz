package view.gameStates;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import view.GameManager;
import view.inGameEntities.PlayerView;

public class PlayfieldView implements Screen {

	private ShapeRenderer sr;
	private PlayerView player;	
	
	private GameManager gm;
	
	public PlayfieldView(GameManager gvm) {
		sr = new ShapeRenderer();
		player = new PlayerView();
		this.gm = gvm;
	}

	@Override
	public void render(float delta) {
		player.render(sr);
		
		// --------------------------------------------------------------------- Lägg till alla rutor som skall visas, t.ex. "combat-area", candy-bar, curr.level, etc.
	}
	
	@Override
	public void hide() {}
	@Override
	public void show() {}
	@Override
	public void resize(int x, int y) {}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void dispose() {}

}

//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import view.GameViewStateManager;
//import view.inGameEntities.PlayerView;
//
//public class PlayfieldView extends GameState {
//
//	private ShapeRenderer sr;
//	private PlayerView player;	
//	
//	public PlayfieldView(GameViewStateManager gsm) {
//		super(gsm);
//	}
//
//	@Override
//	public void init() {
//		sr = new ShapeRenderer();
//		player = new PlayerView();
//	}
//
//	@Override
//	public void draw() {
//		player.draw(sr);
//	}
//
//	@Override
//	public void dispose() { }
//
//	@Override
//	public void update(float dt) {
//		player.update(dt);
//	}
//	
//	// Gives the player a new position, and then update the view.
//	public void updatePlayer(int playerX, float newPosX, float newPosY) {
//		player.update(playerX, newPosX, newPosY);
//	}
//
//	@Override
//	public void handleInput() {
//	}
//}