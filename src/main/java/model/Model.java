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

    private ArrayList<Player> players;

    private Level level;
    private int currentLevel;


    public Model(int width, int height) {
        objects = new ArrayList();
        players = new ArrayList();
        this.width = (float) width;
        this.height = (float) height - 62;
        currentLevel = 2;
        Entity.setBoundaries(45, this.width, this.height, 0);
    }

    /**
     * Creates game with one player
     *
     * @param playerName
     */

    public Model(String playerName, int width, int height) {
        this(width, height);
        Player player1 = new Player(100, 250, playerName);
        players.add(player1);
        for(Player player: players){
            objects.add(player);
        }
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
        Player player1 = new Player(400, 500, player1Name);
        Player player2 = new Player(400, 800, player2Name);
        players.add(player1);
        players.add(player2);
        for(Player player: players){
            objects.add(player);
        }
        startLevel(currentLevel);
    }

    /**
     * Updates the player's directions
     *
     * @param playerNum     what player to update
     * @param directions the new directions
     */
    public void movePlayer(int playerNum, boolean[] directions) {
        boolean updated = false;
        for(Player player: players){
            if(player.getId().substring(1,2).equals(Integer.toString(playerNum))){
                player.updateDir(directions);
                updated = true;
                break;
            }
        }
        if(!updated){
            throw new IllegalArgumentException("Illegal player number");
        }
    }

    public void changeCandy(int player, int candy) {
        System.out.println("Player" + player + " changed candy to " + candy);
    }

    /**
     * Creates the currently selected candy for the specified player.
     *
     * @param playerNum which player to throw the candy
     */
    public void throwCandy(int playerNum) {
        boolean candyThrown = false;
        for(Player player: players){
            if(player.getId().substring(1,2).equals(Integer.toString(playerNum))){
                player.throwCandy();
                candyThrown = true;
                break;
            }
        }
        if(!candyThrown){
            throw new IllegalArgumentException("Illegal player number");
        }

    }


    /**
     * Starts a new level
     *
     * @param levelNbr
     */
    public void startLevel(int levelNbr) {
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

        for(int x = 0; x < players.size(); x++) {
            ArrayList<Candy> candyList = players.get(x).getActiveCandies();
            for (int i = 0; i < candyList.size(); i++) {
                if (candyList.get(i) != null) {
                    if (!candyList.get(i).isExpired()) {
                        candyList.get(i).update(delta);
                        ArrayList<Kid> kidList = level.getActiveKids();
                        for (int j = 0; j < kidList.size(); j++) {
                            float deltaX = kidList.get(j).getX() - candyList.get(i).getX();
                            float deltaY = kidList.get(j).getY() - candyList.get(i).getY();
                            float combinedR = kidList.get(j).getRadius() + candyList.get(i).getRadius();
                            if (Math.pow(deltaX, 2) + Math.pow(deltaY, 2) <= Math.pow(combinedR, 2)) {
                                int kills = level.getKills();
                                kidList.get(j).hitByCandy(candyList.get(i).getType(), candyList.get(i).getDamage());
                                if (level.getKills() > kills && j > 0) j--;
                                candyList.remove(candyList.get(i));
                                if (i > 0) i--;
                            }
                        }
                    }
                }
            }
        }

        for(int z = 0; z < players.size(); z++) {
            players.get(z).update(delta);
        }
        level.update(delta);
        updateObjectList();

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
        ArrayList<Entity> newEntities = new ArrayList<>();

        for(int i = 0; i < players.size(); i++) {
            for(int j = 0; j < players.get(i).getActiveCandies().size(); j++){
                newEntities.add(players.get(i).getActiveCandies().get(j));
            }
        }

        for (Kid kid : level.getActiveKids()) {
            newEntities.add(kid);
        }

        for(int j = 0; j < players.size(); j++) {
            newEntities.add(players.get(j));
        }

        objects = newEntities;

    }

    public ArrayList<Entity> getEntities() {
        return objects;
    }

    public CandyShop getCandyShop(){
        return CandyShop.getInstance();
    }



}
