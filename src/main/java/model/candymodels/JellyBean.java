package model.candymodels;

/**
 * Created by Oscar on 28/04/15.
 */
public class JellyBean implements Candy {

    int[]candyStatus;
    int xPos;
    int yPos;

    int damage;

    public JellyBean(int[]candyStatus, int x, int y){

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
    public void update() {

        switch(candyStatus[1]){
            case 0:
                for(int i = 0; i < 500; i++)
                    xPos += 3*delta;
                break;
            case 1:
                for(int i = 0; i < 800; i++)
                    xPos += 3*delta;
                break;
            case 2:
                for(int i = 0; i < 1200; i++)
                    xPos += 3*delta;
                break;
            case 3:
                for(int i = 0; i < 1700; i++)
                    xPos += 3*delta;
                break;

        }

    }
}
