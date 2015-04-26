package controller;

import java.util.Timer;
import java.util.TimerTask;

public class TimeController {
	private Model model;
	private Timer timer;
	
	public TimeController(Model model) {
		this.model = model;
		timer = new Timer();
		TimerTask updater = new UpdateGame();
		timer.schedule(updater, 0, 1000);
	}
	
	private class UpdateGame extends TimerTask {
		@Override
		public void run() {
			model.updateGame();
		}		
	}
}