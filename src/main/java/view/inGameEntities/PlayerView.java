package view.inGameEntities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * CurrentLevel_Bar
 * This class is responsible for painting the player(s) when the user has 
 * started a new game.
 * 
 * @author  Kim Berger
 * @version 1.0
 */
public class PlayerView extends VisibleObjects {

	public PlayerView(String id, float width, float height) {
		
		if(id.equals("1")){
			x = width / 4;
			y = (height / 3) * 2;
		} else{
			x = width / 4;
			y = (height / 3);
		}
	}

	// Updates players position, called by model (through interface).
	public void update(float newXPos, float newYPos) {

		x = newXPos;
		y = newYPos;
	}

	public void render(ShapeRenderer sr) {
		
		sr.setColor(1, 1, 1, 1);

		// paint the new player(triangle).
		sr.begin(ShapeType.Filled);

		sr.triangle(x - 10, y - 10, x, y + 15, x + 10, y - 10);

		sr.end();
	}

}