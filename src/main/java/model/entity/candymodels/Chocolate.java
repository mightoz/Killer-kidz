package model.entity.candymodels;

/**
 * Created by Matilda on 2015-05-30.
 */
public class Chocolate extends Candy {

    private boolean expired;
    private double maxTravelLength;
    private double travelledLength;

    public Chocolate(float x, float y, int[] candyStatus){
        super(x, y);
        type = "Chocolate";
        expired = false;
        radius = 8;

        switch(candyStatus[0]){
            case 0:
                damage = 1;
                break;
            case 1:
                damage = 2;
                break;
            case 2:
                damage = 3;
                break;
            case 3:
                damage = 4;
                break;
        }

        switch(candyStatus[1]){
            case 0:
                maxTravelLength = 150;
                break;
            case 1:
                maxTravelLength = 200;
                break;
            case 2:
                maxTravelLength = 250;
                break;
            case 3:
                maxTravelLength = 300;
                break;
        }

    }

    @Override
    public boolean isExpired() {
        return expired;
    }

    @Override
    public void update(double delta) {

    }
}
