package view.gameStates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import model.ObservedSubject;
import model.Observer;
import view.ViewGameStateManager;
import view.inGameEntities.PlayerView;

public class PlayfieldView extends GameState implements Observer {

	private ShapeRenderer sr;
	private PlayerView player;	
	
	public PlayfieldView(ViewGameStateManager gsm) {

		super(gsm);

	}

	@Override
	public void init() {
		sr = new ShapeRenderer();
		player = new PlayerView();
	}

	@Override
	public void draw() {
		player.draw(sr);
	}

//	// Forwards the new playerPos to given player.
//	@Override
//	public void handleInput(int playerX, int newPosX, int newPosY) {
//		player.update(newPosX, newPosY);
//	}

	@Override
	public void dispose() { }

	@Override
	public void update(float dt) {
		player.update(dt);
	}
	
	// Gives the player a new position, and then update the view.
	public void updatePlayer(int playerX, int newPosX, int newPosY) {
		player.update(playerX, newPosX, newPosY);
	}

	@Override
	public void handleInput() {
	}


	//Observer methods

	@Override
	public void update(String id, float posX, float posY) {

	}

	@Override
	public void setSubject(ObservedSubject sub) {

	}
}
