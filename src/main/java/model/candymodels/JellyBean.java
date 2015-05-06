package model.candymodels;

/**
 * Created by Oscar on 28/04/15.
 */
public class JellyBean extends Candy {

    private int[] candyStatus;
    private int[] extraCandyStatus;
    private int damage;
    private float xPos;
    private float yPos;
    private float travelledLength;
    private float maxTravelRange;
    private boolean expired;



    public JellyBean(int[] candyStatus, float x, float y) {

        this.candyStatus = candyStatus;
        xPos = x;
        yPos = y;
        expired = false;
        extraCandyStatus = candyStatus;
        extraCandyStatus[2] = 0;

        switch (candyStatus[0]) {
            case 0:
                damage = 10;
                break;
            case 1:
                damage = 30;
                break;
            case 2:
                damage = 60;
                break;
            case 3:
                damage = 100;
                break;
        }

        switch (candyStatus[1]) {
            case 0:
                maxTravelRange = 500;
                break;
            case 1:
                maxTravelRange = 700;
                break;
            case 2:
                maxTravelRange = 1000;
                break;
            case 3:
                maxTravelRange = 1400;
                break;
        }

        /**
         * Throws more candies, the higher the upgrade.
         */
        switch (candyStatus[2]) {
            case 0:
                break;
            case 1:
                Candy extraCandy = new JellyBean(extraCandyStatus, xPos, yPos+10);
                break;
            case 2:
                Candy extraCandy1 = new JellyBean(extraCandyStatus, xPos, yPos+10);
                if(extraCandyStatus[0] > 0)
                    extraCandyStatus[0] -= 1;
                Candy extraCandy2 = new JellyBean(extraCandyStatus, xPos-10, yPos+10);
                Candy extraCandy3 = new JellyBean(extraCandyStatus, xPos-10, yPos);
                break;
            case 3:
                //todo: make a big jellybean that explodes into more jellybeans
                break;
        }
    }

    /**
     * returns a boolean that decides if this candy object is expired or not.
     * @return
     */
    public boolean isExpired(){
        return expired;
    }

    /**
     * Update method for candy position. Candy travels different distances depending on how much it has been upgraded.
     * @param delta
     */
    @Override
    public void update(int delta) {
        if(travelledLength < maxTravelRange){
            xPos += 3 * delta;
            travelledLength += 3 * delta;
        }else{
            expired = true;
        }
    }
}
