package view.inGameEntities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import model.entity.Entity;

public class CandyView extends VisibleObjects{

    public void render(Entity candy, ShapeRenderer sr){

        sr.setColor(1, 4, 2, 1);

        sr.begin(ShapeType.Filled);

        sr.circle(candy.getX(),candy.getY(),candy.getRadius());

        sr.end();

    }
}
