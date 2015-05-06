package model;

import model.candymodels.Candy;
import model.candymodels.JellyBean;

import java.util.ArrayList;

import java.util.ArrayList;

/**
 * Created by Oscar on 24/04/15.
 */
public class Model implements ObservedSubject {

    private ArrayList<Observer> observers;

    private ArrayList<> objects;

    private Player player1;
    private Player player2;


    public Model(){
        observers = new ArrayList<>();
        objects = new ArrayList<>();
    }

    /**
     * Creates game with one player
     *
     * @param playerName
     */

    public Model(String playerName){
        this();
        player1 = new Player(400, 500, playerName);
    }


    /**
     * Creates game with two players
     *
     * @param player1Name
     * @param player2Name
     */
    public Model(String player1Name, String player2Name){
        this();
        player1 = new Player(400, 500, player1Name);
        player2 = new Player(400, 800, player2Name);
    }

    /**
     * Updates the player's directions
     * @param player what player to update
     * @param directions the new directions
     */
    public void movePlayer(int player, boolean[] directions) {

        if (player == 1) {
            player1.updateDir(directions);
        }else{
            player2.updateDir(directions);
        }
        notifyObserver();
    }

    /**
     * Creates the currently selected candy for the specified player.
     *
     * @param player which player to throw the candy
     */
    public void throwCandy(int player) {

        Candy candy;

        if(player == 1){
            switch(player1.getSelectedCandy()){
                case 0:
                    ArrayList<int[]> tmpData1 = player1.getCandyData();
                    candy = new JellyBean(tmpData1.get(0), player1.getX(), player1.getY());
                    break;
                case 1:
                    ArrayList<int[]> tmpData2 = player1.getCandyData();
                    candy = new Skittle(tmpData2.get(1), player1.getX(), player1.getY());
                    break;
                case 2:
                    ArrayList<int[]> tmpData3 = player1.getCandyData();
                    candy = new HubbaBubba(tmpData3.get(2), player1.getX(), player1.getY());
                    break;
                case 3:
                    ArrayList<int[]> tmpData4 = player1.getCandyData();
                    candy = new FerroRoscher(tmpData4.get(3), player1.getX(), player1.getY());
                    break;
            }
        }else{
            switch(player2.getSelectedCandy()) {
                case 0:
                    ArrayList<int[]> tmpData1 = player2.getCandyData();
                    candy = new JellyBean(tmpData1.get(0), player2.getX(), player2.getY());
                    break;
                case 1:
                    ArrayList<int[]> tmpData2 = player2.getCandyData();
                    candy = new Skittle(tmpData2.get(1), player2.getX(), player2.getY());
                    break;
                case 2:
                    ArrayList<int[]> tmpData3 = player2.getCandyData();
                    candy = new HubbaBubba(tmpData3.get(2), player2.getX(), player2.getY());
                    break;
                case 3:
                    ArrayList<int[]> tmpData4 = player2.getCandyData();
                    candy = new FerroRoscher(tmpData4.get(3), player2.getX(), player2.getY());
                    break;
            }

        }

    }

    public void updateGame() {
        // assuming delta is one second
        int delta = 1000;
        player1.update(delta);

        if (selectedCandy1 != null) {
            selectedCandy1.update(delta);
        }
    }

    //returns selectedCandy1, currently this is the only way to access our candy.
    public Candy getSelectedCandy1() {
        return selectedCandy1;
    }

    //returns player1, currently this is the only way to access our player.
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Adds a new observer
     * @param newObserver
     */
    @Override
    public void register(Observer newObserver) {

        if(newObserver == null){
            throw new IllegalArgumentException("Tries to add null object as observer");
        }

       if(!observers.contains(newObserver)){
           observers.add(newObserver);
       }
    }

    /**
     * Removes an observer
     * @param observer
     */
    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all the observers that a change has occurred
     */
    @Override
    public void notifyObserver() {

        for(Observer observer: observers){

            for(object: objects){
                observer.update(String id, float posX, float posY);
            }

        }

    }
}
