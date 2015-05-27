package view.gameStates;

import model.entity.Entity;
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

    private CandyView candyView;
	private KidView kidView;
    private PlayerView playerView;

	private float width;
	private float height;
	
	private GUI gui;
	private ShopToProtect shop;
	
	private Money_Bar money;
	private CurrentLevel_Bar level;

	
	public PlayfieldView(GameManager gm) {
		
		sr = new ShapeRenderer();
		
		width = gm.getWidth();
		height = gm.getHeight();

		gui = new GUI(width, height);
		shop = new ShopToProtect(gm, gui, width, height);

		kidView = new KidView();
        candyView = new CandyView();
        playerView = new PlayerView();
		
		money = new Money_Bar(gm, width, height);
		level = new CurrentLevel_Bar(gm ,width, height);
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
		
		shop.render(sr);
		gui.render(sr);
		
		money.render();
		level.render();
		
	}
	
	/*
	 * Method model will use to tell view to update its contents.
	 */
	@Override
	public void update(Entity entity){
        float newXPos = entity.getX();
        float newYPos = entity.getY();
        String id = entity.getId();

        switch (id.substring(0,1)){
            case "p":
                playerView.render(entity, sr);
                break;
            case "c":
                candyView.render(entity, sr);
                break;
            case "k":
                kidView.render(entity, sr);
                break;
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