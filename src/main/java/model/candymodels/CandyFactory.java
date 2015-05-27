package model.candymodels;

import java.util.ArrayList;

/**
 * Created by Oscar on 26/05/15.
 */
public abstract class CandyFactory {

    /**
     * Creates all objects of candies generated by throwing a candy projectile, adds them to a list
     * and then returns the list.
     */
    public static ArrayList<Candy> throwCandy(int selectedCandy, ArrayList<int[]> candyData, float xPos, float yPos){
        ArrayList<Candy> candyList = new ArrayList();
        switch(selectedCandy){
            case 1:
                int[] candyStatus = candyData.get(0);
                int[] tmpStatus = candyStatus;
                switch (candyStatus[2]){
                    case 0:
                        candyList.add(new JellyBean(xPos, yPos, tmpStatus));
                        break;
                    case 1:
                        candyList.add(new JellyBean(xPos, yPos, tmpStatus));
                        if(tmpStatus[0]>0)
                            tmpStatus[0]--;
                        candyList.add(new JellyBean(xPos - 10, yPos, tmpStatus));
                        break;
                    case 2:
                        candyList.add(new JellyBean(xPos, yPos + 5, tmpStatus));
                        candyList.add(new JellyBean(xPos, yPos - 5, tmpStatus));
                        if(tmpStatus[0]>0)
                            tmpStatus[0]--;
                        candyList.add(new JellyBean(xPos - 10, yPos + 5, tmpStatus));
                        candyList.add(new JellyBean(xPos - 10, yPos - 5, tmpStatus));
                        break;
                    case 3:
                        break;
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;

        }
        return candyList;
    }
}