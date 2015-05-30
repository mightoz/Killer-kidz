package view.inGameEntities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import model.entity.Entity;
import model.entity.candymodels.Candy;
import model.entity.candymodels.JellyBean;

public class CandyView extends VisibleObjects{

    public void render(Entity candy, ShapeRenderer sr){

    	sr.begin(ShapeType.Filled);
    	
    	switch(((Candy)candy).getType()){
    	case "JellyBean":
    		sr.setColor(((JellyBean)candy).getColor());
    		sr.ellipse(candy.getX(), candy.getY(), candy.getRadius()*1.70f, candy.getRadius());
    		break;
    	
    	case "Hubbabubba":
    		sr.setColor(Color.PINK);
    		sr.circle(candy.getX(),candy.getY(),candy.getRadius());
    		break;
    		
    	default:
    		System.out.println("CandyView.render: tried to render an unknown candy-type.");
    	}

        sr.end();

    }
}
