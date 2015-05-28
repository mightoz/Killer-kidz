package view.gameStates;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * HowToPlayView
 * @author  MarieKlevedal
 * @version 1.0
 */
public class HowToPlayView implements Screen {

	private OrthographicCamera cam;
	
	private SpriteBatch batch;
	private BitmapFont htpFont;
	private BitmapFont okFont; 
	private String howToPlay;
	
	@SuppressWarnings("deprecation")
	public HowToPlayView (OrthographicCamera cam) {
		this.cam = cam;
		
		batch = new SpriteBatch();
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
			Gdx.files.internal("src/main/resources/fonts/OpenSans-CondLight.ttf"));
		htpFont = gen.generateFont(15);
		okFont = gen.generateFont(35);
		htpFont.setColor(Color.WHITE);
		okFont.setColor(Color.RED);
		
		FileHandle handle = Gdx.files.internal("src/main/resources/HowToPlay");
		howToPlay = handle.readString();
	}
	
	@Override
	public void render(float delta) {
		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Start drawing
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		htpFont.draw(batch, howToPlay, 250, 450);
		okFont.draw(batch, "I UNDERSTAND", 245, 100);
		
		batch.end();
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
