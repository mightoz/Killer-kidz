package com.edu.guchl.killerKids.view.gameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.edu.guchl.killerKids.view.GameView;
import com.edu.guchl.killerKids.view.ViewGameStateManager;

public class MainMenu extends GameState {

//	private GameView gv = new GameView();
	
	private ShapeRenderer sr;
	
	// For the text
	private SpriteBatch batch;
	private BitmapFont font;
	int viewportHeight;
	BitmapFont titleFont;
	BitmapFont textFont;
	
	private int buttonWidth = 150;
	private int buttonHeight = 70;
	private String title = "KillerKids";
	
	
//	private int button1[]
	
	public MainMenu(ViewGameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		sr = new ShapeRenderer();
		batch = new SpriteBatch();
//		font = new BitmapFont();
//		font.setColor(Color.BLUE);
//		int fontSize = (int)(28 * Gdx.graphics.getDensity());
		
//		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/OpenSans-CondLight.ttf"));
		
//        font = createFont(generator, 64);
//        generator.dispose();

	}

	// for now, only paints the player and then updates
	@Override
	public void update(float dt) {

	}

	public void draw() {

		// Start to draw all buttons.
		sr.begin(ShapeType.Filled);
		sr.setColor(1, 1, 0, 1);

		// all drawing should go between this and sr.end() at bottom.
		sr.rect((GameView.W_WIDTH / 2) - (buttonWidth / 2), GameView.W_HEIGHT / 2, buttonWidth, buttonHeight);
		sr.rect((GameView.W_WIDTH / 2) - (buttonWidth / 2), (GameView.W_HEIGHT / 2) - 100, buttonWidth, buttonHeight);
		sr.rect((GameView.W_WIDTH / 2) - (buttonWidth / 2), (GameView.W_HEIGHT / 2) - 200, buttonWidth, buttonHeight);
		FileHandle handle = Gdx.files.internal("data/myfile.txt");
		
		sr.end();
		
		// Start to draw strings.
		batch.begin();
//		font.draw(batch, title, (GameView.W_WIDTH / 2) - (buttonWidth / 2), ((GameView.W_HEIGHT / 3) * 2));
//		font.draw(batch, title, 100, 100 );
		
		batch.end();
		
	}

	@Override
	public void dispose() {}
	
	
	private BitmapFont createFont(FreeTypeFontGenerator gen, float dp)
    {
		FileHandle fontFile = Gdx.files.internal("data/Roboto-Bold.ttf");
	    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
	    FreeTypeFontParameter parameter = new FreeTypeFontParameter();
	    parameter.size = 12;
	    textFont = generator.generateFont(parameter);
	    parameter.size = 24;
	    titleFont = generator.generateFont(parameter);
	    generator.dispose();
		return generator.generateFont(parameter);
    }

	@Override
	public void handleInput(int playerX, int newPosX, int newPosY) {}
}
