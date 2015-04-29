package model;

import model.candymodels.Candy;

/**
 * Created by Oscar on 24/04/15.
 */
public class Model {

    private Player player1;
    private Player player2;
    private Candy selectedCandy1;
    private Candy selectedCandy2;

    public Model(String playerName){
        player1 = new Player(0, 0, playerName);
    }

    public Model(String player1Name, String player2Name){
        player1 = new Player(0, 0, player1Name);
        player2 = new Player(0, 0, player2Name);
    }

    public void movePlayer(boolean[] directions, int player){

        if(player == 1) {
            player1.updateDir(directions);
        }else{
            player2.updateDir(directions);
        }

    }

    public void throwCandy(int player){

        Candy candy;

        if(player == 1){
            //Hur skapar man rätt candy?
            candy = player1.getNewCandy(player1.getSelectedCandy());

            //shouldnt we have one giant List containing all currently existing candy object
            selectedCandy1 = candy;
        }

    }

    public void updateGame(){
        // assuming delta is one second
        int delta = 1000;
        player1.update(delta);

        if(selectedCandy1 != null){
            selectedCandy1.update(delta);
        }
    }
    //returns selectedCandy1, currently this is the only way to access our candy.
    public Candy getSelectedCandy1(){
        return selectedCandy1;
    }
    //returns player1, currently this is the only way to access our player.
    public Player getPlayer1(){
        return player1;
    }

}
