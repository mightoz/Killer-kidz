package view.inGameEntities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import model.entity.Entity;

public class PlayerView extends VisibleObjects {

    public void render(Entity player, ShapeRenderer sr){

        sr.setColor(1, 1, 1, 1);

        sr.begin(ShapeType.Filled);

        sr.triangle(player.getX() - 10, player.getY() - 10, player.getX(), player.getY() + 15, player.getX() + 10, player.getY() - 10);

        sr.end();

    }
}