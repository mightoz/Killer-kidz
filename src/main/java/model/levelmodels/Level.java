package model.levelmodels;

import model.Model;

import java.util.Random;

/**
 * Created by Matilda on 2015-05-03.
 *
 * This class decides when to create kid objects, representing a level
 */
public abstract class Level {

    protected double timePassed;
    protected double nextSpawnTime;

    protected int currentWave;
    protected int spawnedKids;

    protected int kidsInStore;
    protected int kidsKilled;
    protected int kidsRemoved;
    protected Random random;


    public Level(){
        timePassed = 0.0;
        kidsInStore = 0;
        random = new Random();
        currentWave = 1;
        spawnedKids = 0;
    }

    public void kidRemoved(){
        kidsRemoved++;
    }

    public void enteredStore(){
        kidsInStore++;
        kidRemoved();
    }

    public void killedByCandy(){
        kidsKilled++;
        kidRemoved();
    }

    /**
     * Checks if the player is done with the level
     * @return
     */
    public abstract boolean levelDone();

    /**
     * Updates the positions of all the kids in the game
     */
    public abstract void update(double delta);

    /**
     * Checks if the player has failed
     * @return
     */
    public abstract boolean levelFailed();

}
