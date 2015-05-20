package controller;

import java.util.Timer;
import java.util.TimerTask;
import model.Model;

public class TimeController {
	private Model model;
	private Timer timer;
    private boolean runFlag;
    private double nextTime;
	
	public TimeController(Model model) {
		this.model = model;
        runFlag = false;
		timer = new Timer();
		TimerTask updater = new UpdateGame();
        nextTime = (double)System.nanoTime()/1000000000.0;
		timer.schedule(updater, 0, 20);
	}
	
	private class UpdateGame extends TimerTask {

		@Override
		public void run() {
            runFlag = true;
            double currentTime = (double)System.nanoTime()/1000000000.0;
            if(currentTime >= nextTime){
                double delta = (currentTime - nextTime);
                model.updateGame(delta);
                model.notifyObserver();
                nextTime += delta;
            }else{
                int sleepTime = (int)(1000.0*(nextTime-currentTime));
                if(sleepTime > 0) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                    }
                }
            }
		}		
	}
}

//    function mainloop() {
//        double time_passed = 0;
//        double delta_time = 0;
//
//        while (running) { // keep running
//
//            // update game logic based on time passed
//            updateDynamicStep(delta_time);
//
//            // update game logic once for every tick passed
//            while (time_passed >= time_per_timestep) {
//                updateFixedStep();
//                time_passed -= time_per_timestep;
//                // You might limit the number of iterations here (like 10)
//                // to not get stuck due to processing taking too long (and time adding up)
//            }
//
//            // draw screen content
//            drawStuff(delta_time);
//
//            // update timing
//            delta_time = getTimePassedAndResetTimer();
//            time_passed += delta_time;
//        }
//    }