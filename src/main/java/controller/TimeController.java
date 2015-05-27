package controller;

import model.Model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Oscar on 20/05/15.
 */

/**
 * A timer that calls a run method every x milliseconds. Calculates the time it difference between each update and
 * updates model with the calculated delta as argument.
 *
 */
public class TimeController {

    private Timer timer;
    private Model model;

    private boolean isRunning;
    private double nextTime;

    public TimeController(Model model){

        this.model = model;
        isRunning = false;
        timer = new Timer();

    }

    /**
     * tells the logic thread to start updating.
     */
    public void startLogic(){

        if(!isRunning){
            isRunning = true;
            nextTime = (double)System.nanoTime()/1000000000.0;
            timer.schedule(new UpdateGame(), 0, 2);
        }

    }

    /**
     * tells the logic thread to stop updating.
     */
    public void stopLogic(){

        isRunning = false;
        timer.cancel();

    }

    /**
     * Run method for updating the game. Is called by a schedule.
     */
    private class UpdateGame extends TimerTask{

        public void run(){
            double currentTime = (double) System.nanoTime() / 1000000000.0;
            double delta = (currentTime - nextTime);
            model.updateGame(delta);
            nextTime += delta;
        }
    }
}
