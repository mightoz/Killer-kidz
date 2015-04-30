package com.edu.guchl.killerKids.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Model implements ActionListener {

	Player player = new Player();

	/*
	 * parameters: direction -  1,2,3,4 = up,down,left,right
	 * movingState - 1=moving, 0 = stop moving.
	 */
	public void movePlayer(int direction, int movingState) {
		
		if (movingState == 1) {
//			switch(direction)
//			player.setNewPosition(1, 2);
			
		} else {
			player.StopMovingPlayer(direction);
		}

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
