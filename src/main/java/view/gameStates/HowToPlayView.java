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
 * This screen tells you how to play the game.
 * @author  MarieKlevedal
 * @version 1.0
 */
public class HowToPlayView implements Screen {

	private OrthographicCamera cam;
	private final float WIDTH;
	private final float HIGHT;
	
	private static final GlyphLayout LAYOUT = new GlyphLayout();
	private float layoutWidth;
	private static final SpriteBatch BATCH = new SpriteBatch();
	
	private BitmapFont titleFont;
	private BitmapFont headerFont;
	private BitmapFont htpFont;
	private BitmapFont okFont;
	
	private String title;
	private String[] instructions;
	
	@SuppressWarnings("deprecation")
	public HowToPlayView (OrthographicCamera cam, float WIDTH, float HIGHT) {
		this.cam = cam;
		this.WIDTH = WIDTH;
		this.HIGHT = HIGHT;
		
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
		BATCH.setProjectionMatrix(cam.combined);
		BATCH.begin();
		
		// Draw title
		LAYOUT.setText(titleFont, title);
		layoutWidth = LAYOUT.width;
		titleFont.draw(BATCH, title, (WIDTH-layoutWidth)/2, HIGHT-30);
		
		// Draw instructions for one player
		String str = "One player";
		LAYOUT.setText(headerFont, str);
		layoutWidth = LAYOUT.width;
		headerFont.draw(BATCH, str, WIDTH/4 - layoutWidth/2, HIGHT-100);
		
		String instr = instructions[0];
		LAYOUT.setText(htpFont, instr);
		layoutWidth = LAYOUT.width;
		htpFont.draw(BATCH, instr, WIDTH/4 - layoutWidth/2, HIGHT-135);
		
		// Draw instructions for two players
		str = "Two players";
		LAYOUT.setText(headerFont, str);
		layoutWidth = LAYOUT.width;
		headerFont.draw(BATCH, str, WIDTH/2 + WIDTH/4 - layoutWidth/2, HIGHT-100);
		
		instr = instructions[1];
		LAYOUT.setText(htpFont, instr);
		layoutWidth = LAYOUT.width;
		htpFont.draw(BATCH, instr, WIDTH/2 + WIDTH/4 - layoutWidth/2, HIGHT-110);
		
		// Draw instructions for how to go to candy shop
		instr = instructions[2];
		LAYOUT.setText(htpFont, instr);
		layoutWidth = LAYOUT.width;
		htpFont.draw(BATCH, instr, (WIDTH-layoutWidth)/2, HIGHT-340);
		
		// Draw "I understand"
		String ok = "I understand";
		LAYOUT.setText(okFont, ok);
		layoutWidth = LAYOUT.width;
		okFont.draw(BATCH, ok, (WIDTH-layoutWidth)/2, HIGHT-410);
		
		BATCH.end();
	}
	
	@Override
	public void show() {}
	@Override
	public void resize(int WIDTH, int HIGHT) {}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void hide() {}
	@Override
	public void dispose() {}

}
