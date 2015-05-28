package view.gameStates;


import model.Model;

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
public class CandyShopView implements Screen {

	private OrthographicCamera cam;
	private float width;
	private float height;
	
	private Model model;
	
	private SpriteBatch batch;
	private BitmapFont htpFont;
	private BitmapFont okFont;
	
	@SuppressWarnings("deprecation")
	public CandyShopView (OrthographicCamera cam, Model model, float width, float height) {
		this.cam = cam;
		this.width = width;
		this.height = height;
		
		batch = new SpriteBatch();
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
			Gdx.files.internal("src/main/resources/fonts/OpenSans-CondLight.ttf"));
		htpFont = gen.generateFont(15);
		okFont = gen.generateFont(35);
		htpFont.setColor(Color.WHITE);
		okFont.setColor(Color.RED);
		
	}
	
	@Override
	public void render(float delta) {
		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Start drawing
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		htpFont.draw(batch, "You're in the candy shop :)", 250, 450);
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
