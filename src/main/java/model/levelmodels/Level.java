package model.levelmodels;

import model.Entity;

import java.util.ArrayList;

/**
 * Created by Matilda on 2015-05-03.
 *
 * This class create kid objects, representing a level
 */
public abstract class Level {

  //  protected static ArrayList<Entity> kids;
    protected int updates;
    protected int kidsInStore;
    protected int kidsInLevel;

    public Level(){
    //    kids = new ArrayList<Entity>();
        updates = 0;
        kidsInStore = 0;
    }

    /**
     * Checks if the player is done with the level
     * @return
     */
    public boolean levelDone(){

        //Om ett kid blir träffad tas objektet bort ur listan och sätter kidsInLevel--
        if(kidsInLevel == 0){
            return true;
        }else{
            return false;
        }
    }

//    public static ArrayList<Entity> getKids(){
//        return kids;
//    }
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
