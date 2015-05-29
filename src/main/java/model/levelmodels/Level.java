package model.levelmodels;

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
    protected Random random;


    public Level(){
        timePassed = 0.0;
        kidsInStore = 0;
        random = new Random();
        currentWave = 1;
        spawnedKids = 0;
        activeKids = new ArrayList<>();
    }

    public void kidRemoved(){
        kidsRemoved++;
    }

    private void enteredStore(){
        kidsInStore++;
        kidRemoved();
    }

    private void killedByCandy(){
        kidsKilled++;
        kidRemoved();
    }

    public int getKills(){
        return kidsKilled;
    }
    /**
     * Updates the positions of all the kids in the game
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


    public ArrayList<Kid> getActiveKids(){
        return activeKids;
    }

    protected abstract void updateLevel(double delta);

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
