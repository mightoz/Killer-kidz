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
	
	// player id looks like (p.1) or something ------------------------------------ Kom fram till ett id-system.
	private String id;
	
	public PlayerView(String id, GameManager gm) {
		
		this.gm = gm;
		this.id = id;
		System.out.println(gm);
		x = gm.getWidth() / 4;
		y = gm.getHeight() / 2;

		shapeX = new float[3];
		shapeY = new float[3];

		radians = 3.1415f / 2;
		speed = 5;
	}

	// Updates players position, called by model (through interface).
	public void update(float newXPos, float newYPos) {

		x = newXPos;
		y = newYPos;
		setShape(); // update the "player-shape" with new coordinates.
	}

	// --------------------------------------------------------------------------- Dessa streck-gubbar skall bort, och ersättas med sprites.
	public void render(ShapeRenderer sr) {
		
		// first set the shape to draw.
		setShape();
		
		sr.setColor(1, 0, 0, 1);

		// Then draw the new player-figure.
		sr.begin(ShapeType.Line);

		for (int i = 0, j = shapeX.length - 1; i < shapeX.length; j = i++) {

			sr.line(shapeX[i], shapeY[i], shapeX[j], shapeY[j]);
		}

		sr.end();
	}
	
	private void setShape() {
		shapeX[0] = x + MathUtils.cos(radians) * 32;
		shapeY[0] = y + MathUtils.sin(radians) * 32;

		shapeX[1] = x + MathUtils.cos(radians - 4 * 3.1415f / 5) * 32;
		shapeY[1] = y + MathUtils.sin(radians - 4 * 3.1415f / 5) * 32;

		shapeX[2] = x + MathUtils.cos(radians + 4 * 3.1415f / 5) * 32;
		shapeY[2] = y + MathUtils.sin(radians + 4 * 3.1415f / 5) * 32;
	}
}