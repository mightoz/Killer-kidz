package model.levelmodels;

import model.entity.Entity;
import model.entity.kids.Kid;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Matilda on 2015-05-03.
 *
 * This class decides when to create kid objects, representing a level
 */
public abstract class Level {

    protected ArrayList<Kid> activeKids;

    protected double timePassed;
    protected double nextSpawnTime;

    protected int currentWave;
    protected int spawnedKids;

    protected int kidsInStore;
    protected int kidsKilled;
    protected int kidsRemoved;
    protected int maxKidsInStore;
    protected Random random;



    public Level(){
        timePassed = 0.0;
        kidsInStore = 0;
        random = new Random();
        currentWave = 1;
        spawnedKids = 0;
        activeKids = new ArrayList<>();
    }

    /**
     * Updates the positions of all kids in the game
     * @param delta
     */
    public void update(double delta){

        for(int i = 0; i < activeKids.size();i++){
            if(!activeKids.get(i).isExpired()){
                activeKids.get(i).update(delta);
            }else{
                if(activeKids.get(i).enteredStore()){
                    enteredStore();
                }else{
                    killedByCandy();
                }
                activeKids.remove(activeKids.get(i));
                if(i>0)i--;
            }
        }
        updateLevel(delta);
    }

    /**
     * Generates a valid spawn position for the kids
     * @param distance
     * @return
     */
    protected float generateSpawnPos(int distance){
        float pos = random.nextFloat()* Entity.getUpperBoundary()-distance;
        while(pos < Entity.getLowerBoundary()+10){
            pos = random.nextFloat()*Entity.getUpperBoundary()-distance;
        }
        return pos;
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

    public int getKills(){
        return kidsKilled;
    }

    public int getKidsInStore(){
        return kidsInStore;
    }

    public int getMaxKidsInStore(){
        return maxKidsInStore;
    }

    public ArrayList<Kid> getActiveKids(){
        return activeKids;
    }

    /**
     * Checks if it is time to spawn a new kid and what type of kid to be spawned
     * @param delta
     */
    protected abstract void updateLevel(double delta);

    /**
     * Changes to the next wave and resets spawned kids
     */
    protected abstract void changeWave();

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
