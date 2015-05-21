package view.inGameEntities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class KidView extends VisibleObjects{
	
	// player id looks like (p.1) or something ------------------------------------ Kom fram till ett id-system eller använd objekt i anrop.
	private String id;
	private float radius;
	
	public KidView(String id, float width, float height) {
		
		this.id = id;

		x = width / 4;
		y = height / 2;

		shapeX = new float[4];
		shapeY = new float[4];

		radians = MathUtils.PI / 2;
		
		radius = 10f;
	}

	// Updates players position, called by model (through interface).
	public void update(float newXPos, float newYPos) {

		x = newXPos;
		y = newYPos;
	}

	// --------------------------------------------------------------------------- Dessa streck-gubbar skall bort, och ersättas med sprites.
	public void render(ShapeRenderer sr) {
		
		sr.setColor(0, 1, 0, 1);

		// Then draw the new player-figure.
		sr.begin(ShapeType.Filled);
		
		sr.circle(x, y, radius);

		sr.end();
	}

	public String getId(){
		return id;
	}
}