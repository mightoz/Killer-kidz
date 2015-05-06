package view.gameStates;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import view.GameManager;
import view.inGameEntities.PlayerView;

public class PlayfieldView implements Screen {

	private ShapeRenderer sr;
	private PlayerView[] player;	
	
	private GameManager gm;
	
	public PlayfieldView(GameManager gm) {
		sr = new ShapeRenderer();
		player = new PlayerView[2];
		player[0] = new PlayerView("P.1");
		this.gm = gm;
	}

	@Override
	public void render(float delta) {
		player[0].render(sr);
		
		// --------------------------------------------------------------------- Lägg till alla rutor som skall visas, t.ex. "combat-area", candy-bar, curr.level, etc.
	}
	
	// -------------------------------------------------------------------------- Metod som model skall anropa för uppdatera spelare, godis, barn, m.m.
	public void update(String objectID, float newXPos, float newYPos){
		
		switch(objectID.substring(0, 1)){
		case "P": // Player objects	
				  if(objectID.equals("P.1")){
					  player[0].update(newXPos, newYPos);
					  break;
					  
				  } else if(objectID.equals("P.2")){
					  player[1].update(newXPos, newYPos);
					  break;
			}
					
		case "C": // Candy object
//			int temp = Integer.parseInt(objectID.substring(2, 5)); // 999 objects
//			for()
			
		case "K": // Kid object	
			// Do stuff
		}
		
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