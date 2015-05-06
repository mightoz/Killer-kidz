package view.gameStates;

import model.Observer;
import view.GameManager;
import view.inGameEntities.PlayerView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PlayfieldView implements Screen, Observer {

	private ShapeRenderer sr;
	private PlayerView[] player;
	private GameManager gm; // ------------------------------------ Användas senare?
	
	public PlayfieldView(GameManager gm) {
		sr = new ShapeRenderer();
		player = new PlayerView[2];
		player[0] = new PlayerView("P.1", gm);
		this.gm = gm;
	}

	@Override
	public void render(float delta) {
//		System.out.println("playField.render...");
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		player[0].render(sr);
		
		// --------------------------------------------------------------------- Lägg till alla rutor som skall visas, t.ex. "combat-area", candy-bar, curr.level, etc.
	}
	
	// -------------------------------------------------------------------------- Metod som model skall anropa för uppdatera spelare, godis, barn, m.m.
	@Override
	public void update(String objectID, float newXPos, float newYPos){
		
		/*
		 * Bortse koden under om det bråkar, och istället gör:
		 * 1) kolla vilket objekt som skall updateras (skicka med objekt i parameter?)
		 * 2) säg till respektive "viewObjekt" att updatera dess position utifrån
		 * 	  modelsObjekt, tex:
		 * 			CandyViewObj.update(CandyModel.getPos())
		 *    som då alltså säger till ett viewobjek att uppdateras sin position
		 *    ifrån models.
		 */
		
		switch(objectID.substring(0, 1)) {
		case "P": // Player objects	
				  if(objectID.equals("P.1")) {
					  player[0].update(newXPos, newYPos);
					  break;
					  
				  } else if(objectID.equals("P.2")) {
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