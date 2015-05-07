package model.levelmodels;

import java.util.ArrayList;

/**
 * Created by Matilda on 2015-05-03.
 */
public abstract class Level {

    private ArrayList<Kid> kids;
    private int frames;
    private int kidsInStore;

    public Level(){
        kids = new ArrayList<>();
        frames = 0;
        kidsInStore = 0;
    }

    /**
     * Updates the positions of all the kids in the game
     */
    public abstract void update();

    /**
     * Checks if the player is done with the level
     * @return
     */
    public abstract boolean levelDone();

    /**
     * Checks if the player has failed
     * @return
     */
    public abstract boolean levelFailed();

}
