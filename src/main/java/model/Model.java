package model;

/**
 * Created by Oscar on 24/04/15.
 */
public class Model {

    private Player player1;
    private Player player2;

    public Model(String playerName){
        player1 = new Player(0, 0, playerName);
    }

    public Model(String player1Name, String player2Name){
        player1 = new Player(0, 0, player1Name);
        player2 = new Player(0, 0, player2Name);
    }

    public void movePlayer(boolean[] directions, int player){

        if(player == 1) {
            player1.updatePos(directions);
        }else{
            player2.updatePos(directions);
        }



    }

    public void throwCandy(int player, int candyType){

    }

}
