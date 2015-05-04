package model;

import model.candymodels.Candy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oscar on 24/04/15.
 */
public class Model implements ObservedSubject {

    private ArrayList<Observer> observers;

    private Player player1;
    private Player player2;
    private Candy selectedCandy1;
    private Candy selectedCandy2;


    public Model(){

    }

    /**
     * Creates game with one player
     *
     * @param playerName
     */
    public Model(String playerName) {
        player1 = new Player(0, 0, playerName);
    }

    /**
     * Creates game with two players
     *
     * @param player1Name
     * @param player2Name
     */
    public Model(String player1Name, String player2Name) {
        player1 = new Player(0, 0, player1Name);
        player2 = new Player(0, 0, player2Name);
    }

    /**
     * Updates the player's position and tells the viewto update
     *
     * @param player
     * @param directions
     */
    public void movePlayer(int player, boolean[] directions) {

        if (player == 1) {
            player1.updateDir(directions);
        } else {
            player2.updateDir(directions);
        }
        notifyObserver();
    }

    /**
     * @param player
     */
    public void throwCandy(int player) {

        Candy candy;

        if (player == 1) {
            //Hur skapar man rätt candy?
            candy = player1.getNewCandy(player1.getSelectedCandy());

            //shouldnt we have one giant List containing all currently existing candy object
            selectedCandy1 = candy;
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


    @Override
    public void notifyObserver() {

        for(Observer observer: observers){
            observer.update();
        }

    }
}
