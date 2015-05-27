package view.gameStates;

import java.util.ArrayList;

import model.Entity;
import model.Observer;
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
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PlayfieldView implements Screen, Observer {

	private ShapeRenderer sr;
	private PlayerView[] player;

    private ArrayList<CandyView> candyViews;
	private ArrayList<KidView> kidViews;
	
	private GUI gui;
	private ShopToProtect shop;
	
	private Money_Bar money;
	private CurrentLevel_Bar level;

	
	public PlayfieldView(OrthographicCamera cam, int width, int height) {
		
		sr = new ShapeRenderer();

		gui = new GUI(width, height);
		shop = new ShopToProtect(cam, gui, height);
		kidViews = new ArrayList();
		
		money = new Money_Bar(cam, width, height);
		level = new CurrentLevel_Bar(cam ,width, height);
		
		player = new PlayerView[2];
		player[0] = new PlayerView("P.1", width, height);

        candyViews = new ArrayList();
	}

	/*
	 * Order of painting:
	 * Background
	 * Entities (kids, player, candy)
	 * Shop "forbidden zone"
	 * ActionBar
	 * All text on top of GUI & selected Candy
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

        for(int i = 0; i<candyViews.size();i++){
            candyViews.get(i).render(sr);
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

        String id = entity.getId();
        
        switch(entity.getId().substring(0, 1)) {
        
        // Player objects
		case "p": if(entity.getId().equals("p0")) {
					  player[0].update(newXPos, newYPos);
                      break;
				  } 
				  
				  else if(entity.getId().equals("p1")) {
					  player[1].update(newXPos, newYPos);
					  break;
			}
				  
		/*
		Loops over ArrayList of candyViews.
		If a candy is thrown and updated in model, but is still not added as a view,
		adds the candy to views. Otherwise, updates the positions of the candy.
		 */
		case "c": // Candy object
            boolean newCandy = true;
//            System.out.println(id);
            for(CandyView candy: candyViews){
               if(candy.getId().equals(id)){
                   candy.update(newXPos, newYPos);
                   newCandy = false;
               }
            }
            if(newCandy) {
                candyViews.add(new CandyView(entity.getId(), newXPos, newYPos));
            }
            break;

		case "k": // Kid object
            boolean isNew = true;
			for(KidView kidView: kidViews){
				if(kidView.getId().equals(id)){
					kidView.update(newXPos, newYPos);
					isNew = false;
				}
			}
			if(isNew){
				kidViews.add(new KidView(entity.getId(), newXPos, newYPos));
			}
            break;
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

                for(CandyView candy: candyViews){
                    if(candy.getId().equals(id)){
                        candyViews.remove(candy);
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