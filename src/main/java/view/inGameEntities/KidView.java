package view.inGameEntities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class KidView extends VisibleObjects{
	
	// player id looks like (p.1) or something ------------------------------------ Kom fram till ett id-system eller använd objekt i anrop.
	private String id;
	
	public KidView(String id, float width, float height) {
		
		this.id = id;

		x = width / 4;
		y = height / 2;

		shapeX = new float[4];
		shapeY = new float[4];

		radians = MathUtils.PI / 2;
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
		
		shapeX[0] = x - MathUtils.cos(radians - 4 * MathUtils.PI / 5) * 32;
		shapeY[0] = y + MathUtils.sin(radians) * 32;
		
		shapeX[1] = x + MathUtils.cos(radians - 4 * MathUtils.PI / 5) * 32;
		shapeY[1] = y + MathUtils.sin(radians) * 32;

		shapeX[2] = x + MathUtils.cos(radians - 4 * MathUtils.PI / 5) * 32;
		shapeY[2] = y + MathUtils.sin(radians - 4 * MathUtils.PI / 5) * 32;

		shapeX[3] = x + MathUtils.cos(radians + 4 * MathUtils.PI / 5) * 32;
		shapeY[3] = y + MathUtils.sin(radians + 4 * MathUtils.PI / 5) * 32;
	}

	public String getId(){
		return id;
	}
}