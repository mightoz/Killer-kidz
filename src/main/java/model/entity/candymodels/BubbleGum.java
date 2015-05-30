package model.entity.candymodels;

/**
 * Created by Oscar on 28/04/15.
 */
public class BubbleGum extends Candy {

    private float travelledLength;
    private float maxTravelRange;
    private boolean expired;

    public BubbleGum(float x, float y, int[] candyStatus) {
        super(x,y);
        expired = false;
        radius = 10;
        type = "BubbleGum";
        generateId();
        switch (candyStatus[0]) {
            case 0:
                damage = 5;
                break;
            case 1:
                damage = 10;
                break;
            case 2:
                damage = 20;
                break;
            case 3:
                damage = 40;
                break;
        }

        switch (candyStatus[1]) {
            case 0:
                maxTravelRange = 250;
                break;
            case 1:
                maxTravelRange = 300;
                break;
            case 2:
                maxTravelRange = 400;
                break;
            case 3:
                maxTravelRange = 600;
                break;
        }
    }

    /**
     * returns the damage of the thrown candy.
     * @return damage.
     */
    public int getDamage(){
        return damage;
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
     * @param deltaTime
     */
    @Override
    public void update(double deltaTime) {
        double delta = deltaTime*150;
        if(travelledLength < maxTravelRange){
            xPos += 3 * delta;
            travelledLength += 3 * delta;
        }else{
            expired = true;
        }
    }

}
