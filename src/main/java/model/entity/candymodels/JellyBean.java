package model.entity.candymodels;

import java.util.Random;
import com.badlogic.gdx.graphics.Color;


/**
 * Created by Oscar on 28/04/15.
 */
public class JellyBean extends Candy {

    private float travelledLength;
    private float maxTravelRange;
    private boolean expired;
    
    // used for beans to 
    private Color color;
    private final Color[] colorPallet = new Color[] 
			{ 
			Color.RED,    Color.GREEN,  Color.BLUE, Color.YELLOW,
			Color.ORANGE, Color.CYAN,   Color.MAGENTA, 
			Color.WHITE,  Color.PURPLE, Color.BLACK 
			};

    public JellyBean(float x, float y, int[] candyStatus) {
        super(x,y);
        expired = false;
        radius = 5;
        slowRate = 0.0;
        type = "JellyBean";
        generateId();
        switch (candyStatus[0]) {
            case 0:
                damage = 10;
                break;
            case 1:
                damage = 20;
                break;
            case 2:
                damage = 40;
                break;
            case 3:
                damage = 80;
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid upgrade");
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
            default:
                throw new IndexOutOfBoundsException("Invalid upgrade");
        }

        switch (candyStatus[3]){
            case 0:
                penCapacity = 0;
                break;
            case 1:
                penCapacity = 1;
                break;
            case 2:
                penCapacity = 2;
                break;
            case 3:
                penCapacity = 3;
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid upgrade");
        }
		
		Random rnd = new Random();
		color = colorPallet[rnd.nextInt(10)];
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
    
    public Color getColor() { return color; }

}
