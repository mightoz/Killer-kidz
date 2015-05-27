package view.inGameEntities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import model.entity.Entity;

/**
 * CurrentLevel_Bar
 * This class is responsible for painting the player(s) when the user has 
 * started a new game.
 * 
 * @author  Kim Berger
 * @version 1.0
 */
public class PlayerView extends VisibleObjects {

    public void render(Entity player, ShapeRenderer sr){

        if(player.getId().substring(1,2).equals("0")){
            x = player.getRightBoundary() / 4;
            y = (player.getUpperBoundary() / 3) * 2;
        }else{
            x = player.getRightBoundary() / 4;
            y = (player.getUpperBoundary() /3);
        }
        sr.setAutoShape(true);

        sr.setColor(1, 1, 1, 1);

        sr.begin(ShapeType.Filled);

        sr.triangle(x - 10, y - 10, x, y + 15, x + 10, y - 10);

        sr.end();

    }
}