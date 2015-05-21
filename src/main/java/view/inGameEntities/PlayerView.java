package view.inGameEntities;

import view.GameManager;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

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

		x = width / 4;
		y = height / 2;

		shapeX = new float[3];
		shapeY = new float[3];

		radians = MathUtils.PI / 2;
	}

	// Updates players position, called by model (through interface).
	public void update(float newXPos, float newYPos) {

		x = newXPos;
		y = newYPos;
	}

	// --------------------------------------------------------------------------- Dessa streck-gubbar skall bort, och ersättas med sprites.
	public void render(ShapeRenderer sr) {
		
		// first set the shape to draw.
		
		sr.setColor(1, 1, 1, 1);

		// Then draw the new player-figure.
		sr.begin(ShapeType.Filled);

		sr.triangle(x - 10, y - 10, x, y + 15, x + 10, y - 10);

		sr.end();
	}

}