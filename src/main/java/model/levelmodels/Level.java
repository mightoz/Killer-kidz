package model.levelmodels;

import java.util.ArrayList;

/**
 * Created by Matilda on 2015-05-03.
 */
public abstract class Level {

    protected ArrayList<Kid> kids;
    protected int frames;
    protected int kidsInStore;
    protected int kidsInLevel;

    public Level(){
        kids = new ArrayList<Kid>();
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
