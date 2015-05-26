package view.gameStates;

import view.GameManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * HowToPlayView
 * @author  MarieKlevedal
 * @version 1.0
 */
public class HowToPlayView implements Screen {

	private GameManager gm;
	
	private SpriteBatch batch;
	private BitmapFont font;
	
	@SuppressWarnings("deprecation")
	public HowToPlayView (GameManager gm) {
		this.gm = gm;
		
		batch = new SpriteBatch();
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
			Gdx.files.internal("src/main/java/view/fonts/OpenSans-CondLight.ttf"));
		font = gen.generateFont(20);
		font.setColor(Color.BLUE);
	}
	
	@Override
	public void render(float delta) {
		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Start drawing
		batch.setProjectionMatrix(gm.getCam().combined);
		batch.begin();
		
		font.draw(batch, "hello", 100, 450);
		
		batch.end();
	}
	
	// Called from controller when user presses ENTER
	public void pressedEnter() {
		gm.dispose();
		gm.setScreen(gm.getMainMenu());
	}
	
	@Override
	public void show() {}
	@Override
	public void resize(int width, int height) {}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void hide() {}
	@Override
	public void dispose() {}

}
