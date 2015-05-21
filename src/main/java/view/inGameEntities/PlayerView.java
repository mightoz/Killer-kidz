package view.inGameEntities;

import view.GameManager;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/*
 * Slog ihop denna med Models temporärt, så den kunde läsa korrekt data
 * visa spelarens nya koordinater.
 */

public class PlayerView extends VisibleObjects {

	private GameManager gm;
	
	// player id looks like (p.1) or something ------------------------------------ Kom fram till ett id-system eller använd objekt i anrop.
	private String id;

	public PlayerView(String id, float width, float height) {
		
		this.id = id;
		
		if(id == "1"){
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

	// --------------------------------------------------------------------------- Dessa streck-gubbar skall bort, och ersättas med sprites.
	public void render(ShapeRenderer sr) {
		
		sr.setColor(1, 1, 1, 1);

		// Then draw the new player-triangle.
		sr.begin(ShapeType.Filled);

		sr.triangle(x - 10, y - 10, x, y + 15, x + 10, y - 10);

		sr.end();
	}

}