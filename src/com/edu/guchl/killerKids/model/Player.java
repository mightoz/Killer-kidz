package com.edu.guchl.killerKids.model;


public class Player {
	
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	
	private int posX = 0;
	private int posY = 0;
	
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;

	public void setNewPosition(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	public int movePlayer(int direction) {
		
		switch (direction) {
		
		case (UP):
			System.out.println("UP");
			up = true;
			return UP;

		case (DOWN):
			System.out.println("Down");
			down = true;
			return DOWN;

		case (LEFT):
			System.out.println("Left");
			left = true;
			return LEFT;
			
		case (RIGHT):
			System.out.println("Right");
			right = true;
			return RIGHT;
		}
		return 0;
	}

	public void StopMovingPlayer(int direction) {
		
		switch (direction) {
		
		case (UP):
			up = false;
			break;

		case (DOWN):
			down = false;
			break;

		case (LEFT):
			left = false;
			break;
			
		case (RIGHT):
			right = false;
			break;
		}
	}
}
