package view.gameStates;


import model.entity.Entity;
import model.entity.players.Player;
import model.Model;
import view.gameStates.playfieldGUI.Candy_Bar;
import view.gameStates.playfieldGUI.CurrentLevel_Bar;
import view.gameStates.playfieldGUI.GUI_Foundation;
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

/**
 * PlayfieldView
 * This class is responsible to tell all sub-categories like GUI, currentLevel,
 * shopToProtect, etc. to be painted in a specific order (to avoid kids running
 * "on top of" the GUI for an example) when the player is in the "action-part"
 * of the game, aka. playfield.
 *
 * @author Kim Berger
 * @version 1.0
 */
public class PlayfieldView implements Screen {

    private ShapeRenderer sr;

    private Model model;

    private CandyView candyView;
    private KidView kidView;
    private PlayerView playerView;
    private Player playerObject;

    private GUI_Foundation gui;
    private ShopToProtect shop;

    private Money_Bar money;
    private CurrentLevel_Bar level;

    private Candy_Bar candy_bar;


    public PlayfieldView(OrthographicCamera cam, Model model, float width, float height) {

        sr = new ShapeRenderer();
        this.model = model;

        kidView = new KidView();
        candyView = new CandyView();
        playerView = new PlayerView();

        gui = new GUI_Foundation(width, height);
        shop = new ShopToProtect(cam, gui, height);

        money = new Money_Bar(cam, width, height);
        level = new CurrentLevel_Bar(cam, width, height);

    	// Gets the reference to our playerObject, to be used in Candy_Bar.
        for (Entity entity : model.getEntities()) {
            if (entity.getId().substring(0, 1).equals("p")) {
                playerObject = (Player)entity;
            }
        }

        candy_bar = new Candy_Bar(cam, gui, playerObject);
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

        

        for (Entity entity : model.getEntities()) {
            switch (entity.getId().substring(0, 1)) {
                // Player objects
                case "p":
                	playerObject = (Player)entity;
                    playerView.render(entity, sr);
                    break;

                // Candy objects
                case "c":
                    candyView.render(entity, sr);
                    break;

                // Kid objects
                case "k":
                    kidView.render(entity, sr);
                    break;
            }
        }

        shop.render(sr);
        gui.render(sr);

        money.render();
        level.render();

        // wait to render candy_bar until the playerObject is set.
        if(playerObject != null){
        	candy_bar.render(sr);
        }
    }


    @Override
    public void hide() {
    }

    @Override
    public void show() {
    }

    @Override
    public void resize(int x, int y) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}