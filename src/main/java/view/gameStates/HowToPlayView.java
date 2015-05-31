package view.gameStates;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * HowToPlayView
 * @author  MarieKlevedal
 * @version 1.0
 */
public class HowToPlayView implements Screen {

	private OrthographicCamera cam;
	private float width;
	private float height;
	
	private static final GlyphLayout layout = new GlyphLayout();
	private float layoutWidth;
	private SpriteBatch batch = new SpriteBatch();
	
	private BitmapFont titleFont;
	private BitmapFont headerFont;
	private BitmapFont htpFont;
	private BitmapFont okFont;
	
	private String title;
	private String[] instructions;
	
	@SuppressWarnings("deprecation")
	public HowToPlayView (OrthographicCamera cam, float width, float height) {
		this.cam = cam;
		this.width = width;
		this.height = height;
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
			Gdx.files.internal("src/main/resources/fonts/OpenSans-CondLight.ttf"));
		titleFont = gen.generateFont(50);
		headerFont = gen.generateFont(25);
		htpFont = gen.generateFont(17);
		okFont = gen.generateFont(35);
		titleFont.setColor(Color.YELLOW);
		headerFont.setColor(Color.ORANGE);
		htpFont.setColor(Color.WHITE);
		okFont.setColor(Color.RED);
		
		title = "How to play";
		FileHandle handle = Gdx.files.internal("src/main/resources/HowToPlay");
		String str = handle.readString();
		instructions = str.split("SPLIT");
	}
	
	@Override
	public void render(float delta) {
		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Start drawing
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		// Draw title
		layout.setText(titleFont, title);
		layoutWidth = layout.width;
		titleFont.draw(batch, title, (width-layoutWidth)/2, height-30);
		
		// Draw instructions for one player
		String str = "One player";
		layout.setText(headerFont, str);
		layoutWidth = layout.width;
		headerFont.draw(batch, str, width/4 - layoutWidth/2, height-100);
		
		String instr = instructions[0];
		layout.setText(htpFont, instr);
		layoutWidth = layout.width;
		htpFont.draw(batch, instr, width/4 - layoutWidth/2, height-135);
		
		// Draw instructions for two players
		str = "Two players";
		layout.setText(headerFont, str);
		layoutWidth = layout.width;
		headerFont.draw(batch, str, width/2 + width/4 - layoutWidth/2, height-100);
		
		instr = instructions[1];
		layout.setText(htpFont, instr);
		layoutWidth = layout.width;
		htpFont.draw(batch, instr, width/2 + width/4 - layoutWidth/2, height-110);
		
		// Draw instructions for how to go to candy shop
		instr = instructions[2];
		layout.setText(htpFont, instr);
		layoutWidth = layout.width;
		htpFont.draw(batch, instr, (width-layoutWidth)/2, height-340);
		
		// Draw "I understand"
		String ok = "I understand";
		layout.setText(okFont, ok);
		layoutWidth = layout.width;
		okFont.draw(batch, ok, (width-layoutWidth)/2, height-410);
		
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
