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

//        if(id.equals("1")){
//            x = width / 4;
//            y = (height / 3) * 2;
//        }else{
//            x = width / 4;
//            y = (height /3);
//        }

        sr.setColor(1, 1, 1, 1);

        sr.begin(ShapeType.Filled);

        sr.triangle(x - 10, y - 10, x, y + 15, x + 10, y - 10);

        sr.end();

    }
}