package controller;

import model.Model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Oscar on 20/05/15.
 */

/**
 * A dynamic timer with two threads that are run: A logic thread that udates all the logic of the game as often as possible,
 * and a render thread that renders all graphic each 20th milli second. If the computer that is running the program lags,
 * the logic thread will compensate by updating all logic with a calculated delta, based on the time since the last update.
 *
 */
public class TimeController {

    private LogicThread logicUpdater;
    private RenderThread renderer;
    private Model model;
    private Timer timer;
    private TimerTask updater;

    private boolean isRunning;
    private double nextTime;

    public TimeController(Model model){

        this.model = model;
        logicUpdater = new LogicThread();
        renderer = new RenderThread();
        isRunning = false;
        timer = new Timer();
        updater = new RenderThread();
        timer.schedule(updater,0,20);
        nextTime = (double)System.nanoTime()/1000000000.0;
    }

    /**
     * tells the logic thread to start updating.
     */
    public void startLogic(){
        if(!isRunning){
            isRunning = true;
            logicUpdater.start();
        }

    }

    /**
     * tells the logic thread to stop updating.
     */
    public void stopLogic(){
        isRunning = false;
    }

    /**
     * logic thread.
     */
    private class LogicThread extends Thread{

        public void run(){
            while(isRunning) {
                double currentTime = (double) System.nanoTime() / 1000000000.0;
                double delta = (currentTime - nextTime);
                model.updateGame(delta);
                nextTime += delta;

            }
        }
    }

    /**
     * render thread.
     */
    private class RenderThread extends TimerTask{

        public void run(){
            model.notifyObserver();
        }
    }
}
