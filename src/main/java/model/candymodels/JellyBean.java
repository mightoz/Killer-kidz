package model.candymodels;

/**
 * Created by Oscar on 28/04/15.
 */
public class JellyBean extends Candy {

    int[]candyStatus;
    float xPos;
    float yPos;

    int damage;

    public JellyBean(int[]candyStatus, float x, float y){

        this.candyStatus = candyStatus;
        xPos = x;
        yPos = y;

        switch(candyStatus[0]) {
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

    }

    @Override
    public void update(int delta) {

        switch(candyStatus[1]){
            case 0:
                    xPos += 3*delta;
                break;
            case 1:
                    xPos += 3*delta;
                break;
            case 2:
                    xPos += 3*delta;
                break;
            case 3:
                    xPos += 3*delta;
                break;

        }


    }
}
