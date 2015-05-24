package view.inGameEntities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class CandyView extends VisibleObjects{

    private String id;

    public CandyView(String id, float x, float y){

        this.id = id;
        this.x = x;
        this.y = y;

    }

    public void update(float newXPos, float newYPos){
        x = newXPos;
        y = newYPos;
    }

    public String getId(){
        return id;
    }

    public void render(ShapeRenderer sr){
        sr.setColor(1, 1, 5, 1);

        sr.begin(ShapeType.Filled);

        sr.circle(x,y,5);

        sr.end();

    }


}
