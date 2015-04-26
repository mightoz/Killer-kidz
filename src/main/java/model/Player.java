package model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

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

    public void update(KeyEvent event){
        

    }




}
