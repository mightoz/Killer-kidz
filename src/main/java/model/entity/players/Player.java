package model.entity.players;


import model.entity.candymodels.Candy;
import model.entity.candymodels.CandyFactory;
import model.entity.Entity;

import java.util.ArrayList;


/**
 * Created by Oscar on 24/04/15.
 */
public class Player extends Entity {


    private String name;
    private ArrayList<int[]> candyData;
    private ArrayList<Candy> activeCandies;
    private boolean leftKeyPressed;
    private boolean upKeyPressed;
    private boolean rightKeyPressed;
    private boolean downKeyPressed;
    private int selectedCandy;
    private static int pIdGenerator;
    private final String pId;
    private int money;
    private float defaultXPos;
    private float defaultYPos;

    public Player(float x, float y, String name){
        super(x,y);

        pId = generateId();
        defaultXPos = x;
        defaultYPos = y;
        xPos = x;
        yPos = y;
        this.name = name;

        candyData = new ArrayList();
        int[] jellyBean = new int[4];
        for(int i = 0; i < 4; i++){
            jellyBean[i] = 0;
        }
        candyData.add(0,jellyBean);

        activeCandies = new ArrayList();

        leftKeyPressed = false;
        upKeyPressed = false;
        rightKeyPressed = false;
        downKeyPressed = false;
        selectedCandy = 0;

        radius = 10;
        money = 5000;

    }

    /**
     * Add a new throwable candy to a players kit.
     *
     * @param index what candy should be added.
     * @param data the upgrades of the candy added.
     */
    public void addCandy(int index, int[] data){
        candyData.add(index, data);
    }

    /**
     * Changes/upgrades the attributes of a candy currently in a players kit.
     *
     * @param index what candy should be changed
     * @param data how the candy should be updated.
     */
    public void upgradeCandy(int index, int[] data){
        candyData.set(index, data);
    }

    public ArrayList getCandyData(){
        return candyData;
    }

    public void setSelectedCandy(int candy){
        selectedCandy = candy;
    }

    public void throwCandy(){

        ArrayList<Candy> tmp = CandyFactory.throwCandy(selectedCandy, candyData, xPos, yPos);
        for(Candy candies: tmp){
            activeCandies.add(candies);
        }

    }



    /**
     * Updates the direction of the player.
     * @param directions array of booleans that tells what keys are pressed. Index 0 - 4 corresponds to the keys: left, up, right and down.
     */
    public void updateDir(boolean[] directions){

        leftKeyPressed = directions[0];
        upKeyPressed = directions[1];
        rightKeyPressed = directions[2];
        downKeyPressed = directions[3];

    }

    /**
     * Updates the position of the player based on the directions.
     * @param deltaMovement
     */
    public void update(double deltaMovement){
        double delta = deltaMovement * 200;
        boolean leftAndRight = (!leftKeyPressed && !rightKeyPressed) || (leftKeyPressed && rightKeyPressed);
        boolean upAndDown = (!upKeyPressed && !downKeyPressed) || (upKeyPressed && downKeyPressed);

        //moves player up/down if up/down key is pressed and both left and right keys are pressed at the same time,
        //or both left and right keys are not pressed at all.
        if(leftAndRight && !upAndDown){
            if (upKeyPressed)
                yPos += delta;
            else
                yPos -= delta;


            if(yPos <= lowerBoundary) {
                yPos += delta;
            }else if(yPos >= upperBoundary) {
                yPos -= delta;
            }

        }
        //moves player left/right if left/right key is pressed and both up and down keys are pressed at the same time,
        //or both up and down keys are not pressed at all.
        if(!leftAndRight && upAndDown){
            if (rightKeyPressed)
                xPos += delta;
            else
                xPos -= delta;


            if(xPos <= leftBoundary) {
                xPos += delta;
            }else if(xPos >= rightBoundary) {
                xPos -= delta;
            }
        }
        //moves player diagonally at the same speed as all other axis.
        if(!leftAndRight && !upAndDown){
            if(upKeyPressed && rightKeyPressed){
                xPos += Math.sqrt((delta*delta)/2);
                yPos += Math.sqrt((delta*delta)/2);
            }else if(upKeyPressed){
                xPos -= Math.sqrt((delta*delta)/2);
                yPos += Math.sqrt((delta*delta)/2);
            }else if(rightKeyPressed){
                xPos += Math.sqrt((delta*delta)/2);
                yPos -= Math.sqrt((delta*delta)/2);
            }else {
                xPos -= Math.sqrt((delta * delta) / 2);
                yPos -= Math.sqrt((delta * delta) / 2);
            }

            if(yPos <= lowerBoundary){
                yPos += Math.sqrt((delta*delta)/2);
            }else if(yPos >= upperBoundary){
                yPos -= Math.sqrt((delta*delta)/2);
            }else if(xPos <= leftBoundary){
                xPos += Math.sqrt((delta*delta)/2);
            }else if(xPos >= rightBoundary){
                xPos -= Math.sqrt((delta*delta)/2);
            }else if(yPos >= upperBoundary && xPos <= leftBoundary){
                yPos -= Math.sqrt((delta*delta)/2);
                xPos += Math.sqrt((delta*delta)/2);
            }else if(yPos >= upperBoundary && xPos >= rightBoundary){
                    yPos -= Math.sqrt((delta*delta)/2);
                    xPos -= Math.sqrt((delta*delta)/2);
            }else if(yPos <= lowerBoundary && xPos <= leftBoundary){
                yPos += Math.sqrt((delta*delta)/2);
                xPos += Math.sqrt((delta*delta)/2);
            }else if(yPos <= lowerBoundary && xPos >= rightBoundary){
                yPos += Math.sqrt((delta*delta)/2);
                xPos -= Math.sqrt((delta*delta)/2);

            }
        }
    }

    /**
     * Returns the selected candy
     * @return
     */
    public int getSelectedCandy(){
        return selectedCandy;
    }

    @Override
    public String generateId() {

        if(pIdGenerator==0)pIdGenerator = 1;
        int tmp = pIdGenerator;
        pIdGenerator++;
        return "p"+tmp;
    }

    public ArrayList<Candy> getActiveCandies(){
        return activeCandies;
    }

    public boolean isExpired(){
        return false;
    }

    public String getId(){
        return pId;
    }

    public int getMoney(){
        return money;
    }

    public void spendMoney(int cost){
        money -= cost;
    }

    public void resetPos(){
        boolean[] dir = {false, false, false, false};
        updateDir(dir);
        xPos = defaultXPos;
        yPos = defaultYPos;
    }
}
