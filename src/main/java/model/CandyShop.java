package model;

public class CandyShop {

	/*
	 * No data in view, so info about what item in the shop that is marked (currentRow/Col) must be here.
	 * Use the following rows/cols in view:
	 * 				JellyBean						row = -1
	 * Speed	Damage	Spread	Penetration			row = 0
	 *   1		  2		  3			4				row = 1
	 *   1		  2		  3			4				row = 2
	 *   1		  2		  3			4				row = 3
	 *   1		  2		  3			4				row = 4
	 *   		  StartNewLevel 					row = 5
	 * col=1   col=2    col=3    col=4
	 */
	
	/*
	 * Wishlist on methods
	 * 
	 * getCandyShop()		in Model, that returns reference to this object
	 * 
	 * int getCurrentRow()
	 * int getCurrentCol()
	 * String getSelectedCandy()
	 * 
	 * String getStatus(int row, int col)	is only called for row=1-4 (i.e. upgrades), returns a String 
	 * 										("have"/"buy"/"not") depending on the status of the upgrade
	 * String getUpgradeName(int row, int col)	returns the name of the row:th upgrade for property col
	 * 
	 * int getMoney()		returns the amount of money that the player has
	 * 
	 * String getInfo()		returns info (e.g. info about a candy). Should return a welcome message (see hard coded 
	 * 						info in view) before user chooses to view info about something else.
	 * 
	 * move(int)			that takes 0-3 representing LURD, and changes currentRow/Col (if row = -1, it changes candy)
	 * choose()				that buys the upgrade if an upgrade is marked, and sets info if property is marked				
	 * 
	 */
    private static CandyShop cs;

	private CandyShop(){

    }

    public static CandyShop getInstance(){
        return cs;
    }



}
