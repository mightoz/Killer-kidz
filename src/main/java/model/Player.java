package model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by Oscar on 24/04/15.
 */
public class Player {

    private float x, y;
    private String name;
    private ArrayList candyData = new ArrayList();



    public Player(float x, float y, String name){

        this.x = x;
        this.y = y;
        this.name = name;

    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
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

    /**
     * Updates the position of the player.
     * @param directions array of booleans that tells what keys are pressed. Index 0 - 4 corresponds to the keys: left, up, right and down.
     */
    public void updatePos(boolean[] directions){

        boolean leftKeyPressed = directions[0];
        boolean upKeyPressed = directions[1];
        boolean rightKeyPressed = directions[2];
        boolean downKeyPressed = directions[3];
        boolean leftAndRight = (!leftKeyPressed && !rightKeyPressed) || (leftKeyPressed && rightKeyPressed);
        boolean upAndDown = (!upKeyPressed && !downKeyPressed) || (upKeyPressed && downKeyPressed);

        //moves player up/down if up/down key is pressed and both left and right keys are pressed at the same time,
        //or both left and right keys are not pressed at all.
        if(leftAndRight && !upAndDown){
            if(upKeyPressed)
                y += delta;
            else
                y -= delta;
        }
        //moves player left/right if left/right key is pressed and both up and down keys are pressed at the same time,
        //or both up and down keys are not pressed at all.
        if(!leftAndRight && upAndDown){
            if (rightKeyPressed)
                x += delta;
            else
                x -= delta;
        }
        //moves player diagonally at the same speed as all other axis.
        if(!leftAndRight && !upAndDown){
            if(upKeyPressed && rightKeyPressed){
                x += sqrt(2 * Math.pow(delta, 2));
                y += sqrt(2 * Math.pow(delta, 2));
            }else if(upKeyPressed){
                x -= sqrt(2 * Math.pow(delta, 2));
                y += sqrt(2 * Math.pow(delta, 2));
            }else if(rightKeyPressed){
                x += sqrt(2 * Math.pow(delta, 2));
                y -= sqrt(2 * Math.pow(delta, 2));
            }else{
                x -= sqrt(2 * Math.pow(delta, 2));
                y -= sqrt(2 * Math.pow(delta, 2));
            }

        }

    }



}
