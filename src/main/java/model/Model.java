package model;

import model.entity.players.Player;
import model.entity.candymodels.Candy;
import model.entity.kids.Kid;
import model.entity.Entity;
import model.levelmodels.Level;
import model.levelmodels.LevelOne;
import model.levelmodels.LevelThree;
import model.levelmodels.LevelTwo;

import java.util.ArrayList;


/**
 * Created by Oscar on 24/04/15.
 */
public class Model {

    private static ArrayList<Entity> objects;
    public static float width;
    public static float height;

    private Player player1;
    private Player player2;

    private Level level;
    private int currentLevel;
    
    // boolean used to make view wait until model is done modyfing the EntityArray.
    private boolean updatingEntityArray = true;


    public Model(int width, int height) {
        objects = new ArrayList<Entity>();
        this.width = (float) width;
        this.height = (float) height - 62;
        currentLevel = 1;
        Entity.setBoundaries(45, this.width, this.height, 0);
    }

    /**
     * Creates game with one player
     *
     * @param playerName
     */

    public Model(String playerName, int width, int height) {
        this(width, height);
        player1 = new Player(100, 250, playerName);
        
        updatingEntityArray = true;
        objects.add(player1);
        updatingEntityArray = false;
        
        startLevel(currentLevel);
    }

    /**
     * Creates game with two players
     *
     * @param player1Name
     * @param player2Name
     */
    public Model(String player1Name, String player2Name, int width, int height) {
        this(width, height);
        player1 = new Player(400, 500, player1Name);
        player2 = new Player(400, 800, player2Name);
        
        updatingEntityArray = true;
        objects.add(player1);
        objects.add(player2);
        updatingEntityArray = false;
    }

    /**
     * Updates the player's directions
     *
     * @param player     what player to update
     * @param directions the new directions
     */
    public void movePlayer(int player, boolean[] directions) {

        if (player == 1) {
            player1.updateDir(directions);
        } else {
            player2.updateDir(directions);
        }
    }

    public void changeCandy(int player, int candy) {
        System.out.println("Player" + player + " changed candy to " + candy);
    }

    /**
     * Creates the currently selected candy for the specified player.
     *
     * @param player which player to throw the candy
     */
    public void throwCandy(int player) {
        switch (player) {
            case 1:
                player1.throwCandy();
                break;
            case 2:
                player2.throwCandy();
                break;
        }

    }


    /**
     * Starts a new level
     *
     * @param levelNbr
     */
    public void startLevel(int levelNbr) {
        //    kids.clear();
        switch (levelNbr) {
            case 1:
                level = new LevelOne();
                break;
            case 2:
                level = new LevelTwo();
                break;
            case 3:
                level = new LevelThree();
                break;
        }
    }

    /**
     * Updates the list of active objects and notifies view. Removes objects that have expired.
     */
    public void updateGame(double delta) {

        ArrayList<Candy> candyList = player1.getActiveCandies();
        for (Candy candy : candyList) {
            if (candy != null) {
                if (!candy.isExpired()) {
                    candy.update(delta);
                    ArrayList<Kid> kidList = level.getActiveKids();
                    for (Kid kid : kidList) {
                        float deltaX = kid.getX() - candy.getX();
                        float deltaY = kid.getY() - candy.getY();
                        float combinedR = kid.getRadius() + candy.getRadius();
                        if (Math.pow(deltaX, 2) + Math.pow(deltaY, 2) <= Math.pow(combinedR, 2)) {
                            kid.hitByCandy(candy.getType(), candy.getDamage());
                            candyList.remove(candy);
                        }
                    }
                }
            }
        }
        updatingEntityArray = true;
        level.update(delta);
        updateObjectList();
        updatingEntityArray = false;

        if (level.levelFailed()) {
            System.out.println("Level failed");
        } else if (level.levelDone()) {
            System.out.println("Level done");
        }
    }


    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    private void updateObjectList() {
    	updatingEntityArray = true;
        ArrayList<Entity> newEntities = new ArrayList<>();

        for (Candy candy : player1.getActiveCandies()) {
            newEntities.add(candy);
        }

        for (Kid kid : level.getActiveKids()) {
            newEntities.add(kid);
        }
        newEntities.add(player1);
        
        objects = newEntities;
        
        updatingEntityArray = false;
    }
    
    public ArrayList<Entity> getEntitys() { return objects; }
    public boolean getupdatingEntityArray() { return updatingEntityArray; }

}
