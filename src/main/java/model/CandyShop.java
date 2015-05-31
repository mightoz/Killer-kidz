package model;

import model.entity.players.Player;

import java.util.ArrayList;

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

    private Player player;

    private int currentRow;
    private int currentCol;
    private String selectedCandyInShop;

    private CandyShop() {
        currentRow = 1;
        currentCol = 1;
        selectedCandyInShop = "Jellybean";
    }

    public void changePlayer(Player p) {
        player = p;
    }

    public void changeSelectedCandy(String c) {
        selectedCandyInShop = c;
    }

    public static CandyShop getInstance() {
        if (cs == null)
            cs = new CandyShop();
        return cs;
    }

    public Player getBrowsingPlayer() {
        return player;
    }

    public void move(int step) {
        switch (step) {
            case 0:
                if (currentCol > 1)
                    currentCol--;
                break;
            case 1:
                if (currentRow > -2)
                    currentRow--;
                break;
            case 2:
                if (currentCol < 4)
                    currentCol++;
                break;
            case 3:
                if (currentRow < 5)
                    currentRow++;
                break;
            default:
                throw new IllegalArgumentException("Invalid key");
        }
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public String getSelectedCandy() {
        return selectedCandyInShop;
    }

    public String getStatus(int row, int col) {
        if (row == 5) return "Next level";
        ArrayList<int[]> candyData = player.getCandyData();
        int[] data;
        switch (selectedCandyInShop) {
            case "Jellybean":
                if (candyData.size() > 0) {
                    data = candyData.get(0);
                } else {
                    return "not";
                }
                break;
            case "Hubbabubba":
                if (candyData.size() > 1) {
                    data = candyData.get(1);
                } else {
                    return "not";
                }
                break;
            case "Chocolate":
                if (candyData.size() > 2) {
                    data = candyData.get(2);
                } else {
                    return "not";
                }
                break;
            default:
                data = candyData.get(0);
                break;
        }

        if (data[col - 1] >= (row - 1)) {
            return "have";
        } else if (getMoney() >= row * 1000 && data[col - 1] >= (row - 2)) {
            return "buy";
        } else {
            return "not";
        }
    }

    public String getStatus() {
        return getStatus(currentRow, currentCol);
    }

    public int getMoney() {
        return player.getMoney();
    }

    public void buyUpgrade() {
        ArrayList<int[]> candyData = player.getCandyData();
        int[] data;
        switch (selectedCandyInShop) {
            case "Jellybean":
                data = candyData.get(0);
                data[currentCol - 1] = (currentRow - 1);
                player.upgradeCandy(0, data);
                player.spendMoney((currentRow - 1) * 1000);
                break;
            case "Hubbabubba":
                data = candyData.get(1);
                data[currentCol - 1] = (currentRow - 1);
                player.upgradeCandy(1, data);
                player.spendMoney((currentRow - 1) * 1000);
                break;
            case "Chocolate":
                data = candyData.get(2);
                data[currentCol - 1] = (currentRow - 1);
                player.upgradeCandy(2, data);
                player.spendMoney((currentRow - 1) * 1000);
                break;
            default:
                throw new IllegalArgumentException("No candy selected");
        }
    }

    public String getPropName(int row){
        switch(selectedCandyInShop) {
            case "Jellybean":
                switch (row) {
                    case 1:
                        return "Damage";
                    case 2:
                        return "Distance";
                    case 3:
                        return "Multiplier";
                    case 4:
                        return "Penetration";
                    default:
                        throw new IllegalArgumentException("Illegal row");
                }
            case "Hubbabubba":
                switch (row) {
                    case 1:
                        return "Damage";
                    case 2:
                        return "Distance";
                    case 3:
                        return "Slow";
                    case 4:
                        return "Size";
                    default:
                        throw new IllegalArgumentException("Illegal row");
                }
            case "Chocolate":
                switch (row) {
                    case 1:
                        return "Damage";
                    case 2:
                        return "Distance";
                    case 3:
                        return "Damage multiplier";
                    case 4:
                        return "Distance multiplier";
                    default:
                        throw new IllegalArgumentException("Illegal row");
                }
            default:
                throw new IllegalArgumentException("Candy does not exist");
        }
    }

}
