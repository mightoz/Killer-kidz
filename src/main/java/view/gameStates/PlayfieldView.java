package view.gameStates;

import model.Entity;
import model.Observer;
import view.GameManager;

import view.gameStates.playfieldGUI.CurrentLevel_Bar;
import view.gameStates.playfieldGUI.GUI;
import view.gameStates.playfieldGUI.Money_Bar;
import view.gameStates.playfieldGUI.ShopToProtect;

import view.inGameEntities.CandyView;
import view.inGameEntities.KidView;
import view.inGameEntities.PlayerView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class PlayfieldView implements Screen, Observer {

	private ShapeRenderer sr;
	private PlayerView[] player;
	private GameManager gm; // ------------------------------------ Användas senare?

    private ArrayList<CandyView> candies;
	private ArrayList<KidView> kidViews;

	private float width;
	private float height;
	
	private GUI gui;
	private ShopToProtect shop;
	
	private Money_Bar money;
	private CurrentLevel_Bar level;

	
	public PlayfieldView(GameManager gm) {
		
		sr = new ShapeRenderer();
		this.gm = gm;
		
		width = gm.getWidth();
		height = gm.getHeight();

		gui = new GUI(width, height);
		shop = new ShopToProtect(gm, gui, width, height);
		kidViews = new ArrayList<>();
		
		money = new Money_Bar(gm, width, height);
		level = new CurrentLevel_Bar(gm ,width, height);
		
		player = new PlayerView[2];
		player[0] = new PlayerView("P.1", width, height);

        candies = new ArrayList();
	}

	/*
	 * Order of painting:
	 * Background
	 * Entities (kids, player, candy)
	 * Shop "forbidden zone"
	 * ActionBar
	 * All text above & selected Candy
	 * 
	 * Reason to draw entities first, is we want them to run "under the shop"
	 * and the actionBar, because we want it to be like a "building" with the
	 * shop, and i think it will look better with the GUI on top.
	 */
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		player[0].render(sr);

        for(int i = 0; i<candies.size();i++){
            candies.get(i).render(sr);
        }

        for(int i = 0; i<kidViews.size();i++){
            kidViews.get(i).render(sr);
        }
		
		shop.render(sr);
		gui.render(sr);
		
		money.render();
		level.render();
		
	}
	
	/*
	 * Method model will use to tell view to update its contents.
	 */
	@Override
	public void update(Entity entity, float newXPos, float newYPos){
        /*
		 * Bortse koden under om det bråkar, och istället gör:
		 * 1) kolla vilket objekt som skall updateras (skicka med objekt i parameter?)
		 * 2) säg till respektive "viewObjekt" att updatera dess position utifrån
		 * 	  modelsObjekt, tex:
		 * 			CandyViewObj.update(CandyModel.getPos())
		 *    som då alltså säger till ett viewobjek att uppdateras sin position
		 *    ifrån models.
		 */

        String id = entity.getId();

		switch(entity.getId().substring(0, 1)) {
		case "p": // Player objects
				  if(entity.getId().equals("p0")) {
					  player[0].update(newXPos, newYPos);
                      break;
				  } else if(entity.getId().equals("p1")) {
					  player[1].update(newXPos, newYPos);
					  break;
			}
		/*
		Iterates over a linked list of candyViews.
		If a candy is thrown and updated in model, but is still not added as a view,
		adds the candy to views. Otherwise, updates the positions of the candy.
		 */
		case "c": // Candy object
            boolean newCandy = true;

            for(CandyView candy: candies){
               if(candy.getId().equals(id)){
                   candy.update(newXPos, newYPos);
                   newCandy = false;
                   break;
               }
            }
            if(newCandy) {
                candies.add(new CandyView(entity.getId(), newXPos, newYPos));
            }

		case "k": // Kid object
			boolean isNew = true;
			for(KidView kidView: kidViews){
				if(kidView.getId().equals(id)){
					kidView.update(entity, newXPos, newYPos);
					isNew = false;
					break;
				}
			}
			if(isNew){
				kidViews.add(new KidView(entity.getId(), newXPos, newYPos));
			}
		}
	}

    /**
     * removes an object from a list of viewobjects, specified by the entity id.
     * @param entity
     */
    public void removeEntity(Entity entity){
        String id = entity.getId();
        switch (id.substring(0, 1)){
            case "p":
                break;

            case "c":

                for(CandyView candy: candies){
                    if(candy.getId().equals(id)){
                        candies.remove(candy);
                        break;
                    }
                }

            case "k":

                for(KidView kid: kidViews){
                    if(kid.getId().equals(id)){
                        kidViews.remove(kid);
                        break;
                    }
                }

        }
    }
	
	@Override
	public void hide() { }
	@Override
	public void show() { }
	@Override
	public void resize(int x, int y) { }
	@Override
	public void pause() { }
	@Override
	public void resume() { }
	@Override
	public void dispose() { }
}