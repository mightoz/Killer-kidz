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
                damage = 20;
                break;
            case 1:
                damage = 40;
                break;
            case 2:
                damage = 70;
                break;
            case 3:
                damage = 90;
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

        switch(candyStatus[2]){
            case 0:
                damage *= 1.1;
                break;
            case 1:
                damage *= 1.2;
                break;
            case 2:
                damage *= 1.3;
                break;
            case 3:
                damage *= 1.4;
                break;
        }

        switch(candyStatus[3]){
            case 0:
                maxTravelLength *= 1.1;
                break;
            case 1:
                maxTravelLength *= 1.2;
                break;
            case 2:
                maxTravelLength *= 1.3;
                break;
            case 3:
                maxTravelLength *= 1.4;
                break;
        }

    }

    @Override
    public void update(double deltaTime) {
        double delta = deltaTime*150;
        if(travelledLength < maxTravelLength){
            xPos += 3 * delta;
            travelledLength += 3 * delta;
        }else{
            expired = true;
        }
    }

    @Override
    public boolean isExpired() {
        return expired;
    }

}
