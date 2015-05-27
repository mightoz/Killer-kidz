package view.inGameEntities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import model.entity.Entity;

public class KidView extends VisibleObjects{

    public void render(Entity kid, ShapeRenderer sr){

        sr.setColor(1, 1, 5, 1);

        sr.begin(ShapeType.Filled);

        sr.circle(kid.getX(), kid.getY(), kid.getRadius());

        sr.end();

    }
}