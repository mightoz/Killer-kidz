package view.gameStates;


import model.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * CandyShopView
 * @author  MarieKlevedal
 * @version 1.0
 */
public class CandyShopView implements Screen {

	//private CandyShop cs;																			// TODO
	
	private OrthographicCamera cam;
	private float width;
	private float height;
	private static final GlyphLayout layout = new GlyphLayout();
	private float layoutWidth;
	
	private static final SpriteBatch batch = new SpriteBatch();;
	private BitmapFont titleFont;
	private BitmapFont moneyFont;
	private BitmapFont candyFont;
	private BitmapFont propertyFont;
	private BitmapFont infoFont;
	
	private Color[] infoColours = new Color[3];
	private Color marker;

	private String title;
	private String[] colourGuide = new String[3];
	private String[] propertyNames = new String[4];		// Remove if different candies have different properties
	
	@SuppressWarnings("deprecation")
	public CandyShopView (OrthographicCamera cam, Model model, float width, float height) {
		this.cam = cam;
		// this.cs = model.getCandyShop();																// TODO
		this.width = width;
		this.height = height;
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
			Gdx.files.internal("src/main/resources/fonts/OpenSans-CondLight.ttf"));
		titleFont = gen.generateFont(50);
		moneyFont = gen.generateFont(25);
		candyFont = gen.generateFont(30);
		propertyFont = gen.generateFont(25);
		infoFont = gen.generateFont(15);
		titleFont.setColor(Color.PURPLE);
		moneyFont.setColor(Color.YELLOW);
		
		infoColours[0] = Color.GREEN;
		infoColours[1] = Color.YELLOW;
		infoColours[2] = Color.RED;
		marker = Color.BLUE;
		
		title = "Candy Shop";
		colourGuide[0] = "You already have this upgrade";
		colourGuide[1] = "You can buy this upgrade";
		colourGuide[2] = "You can't buy this upgrade";
		propertyNames[0] = "Speed";						// Remove if different candies have different properties
		propertyNames[1] = "Damage";
		propertyNames[2] = "Spread";
		propertyNames[3] = "Penetration";
		
	}
	
	@Override
	public void render(float delta) {		
		drawUnselectableThings();
		
		int currentRow = -1; //cs.getCurrentRow();													// TODO
		int currentCol = 3;	//cs.getCurrentCol();													// TODO
		
		// Draw selected candy
		String candy = "Jelly Bean";	//cs.getSelectedCandy();									// TODO
		layout.setText(candyFont, candy);
		layoutWidth = layout.width;
		if (currentRow == -1) { candyFont.setColor(marker); }
		else { candyFont.setColor(Color.WHITE); }
		candyFont.draw(batch, candy, (width - layoutWidth)/2, height-100);
		
		// Draw candy property names
		String prop;
		for (int col = 1; col <= 4; col++) {
			prop = propertyNames[col-1];
			layout.setText(propertyFont, prop);
			layoutWidth = layout.width;
			if (currentRow == 0 && currentCol == col) { propertyFont.setColor(marker); }
			else { propertyFont.setColor(Color.WHITE); }
			propertyFont.draw(batch, prop, (col-1)*width/4 + (width/4-layoutWidth)/2, height-150);
		}
		
		// Draw candy upgrade statuses
		String[][] statuses = {{"have", "have", "have", "not"}, 								// Remove later
							   {"have", "buy", "buy", "not"},
							   {"buy", "not", "not", "not"},
							   {"not", "not", "not", "not"}};
		String status;
		String upgradeName;
		for (int row = 1; row <= 4; row++) {
			for (int col = 1; col <= 4; col++) {
				if (currentRow == row && currentCol == col) { 
					propertyFont.setColor(marker); 
				}
				else {
					status = statuses[row-1][col-1]; //cs.getStatus(row, col);							// TODO
					switch (status) {
					case "have": 
						propertyFont.setColor(Color.GREEN);
						break;
					case "buy": 
						propertyFont.setColor(Color.YELLOW);
						break;
					case "not": 
						propertyFont.setColor(Color.RED);
						break;
					default: 
						System.out.println("Invalid status");
					}
				}
				upgradeName = row + "";		// cs.getUpgradeName(row, col);								// TODO
				layout.setText(propertyFont, upgradeName);
				layoutWidth = layout.width;
				propertyFont.draw(batch, upgradeName, 
						(col-1)*width/4 + (width/4-layoutWidth)/2, height-150-30*row);
			}
		}
		
		// Draw Start Next Level
		String text = "Start Next Level";
		layout.setText(candyFont, text);
		layoutWidth = layout.width;
		if (currentRow == 5) { candyFont.setColor(marker); }
		else { candyFont.setColor(Color.WHITE); }
		candyFont.draw(batch, text, (width - layoutWidth)/2, height-350);
		
		batch.end();
	}
	
	private void drawUnselectableThings() {
		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Start drawing
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		// Draw title
		layout.setText(titleFont, title);
		layoutWidth = layout.width;
		titleFont.draw(batch, title, (width - layoutWidth)/2, height-30);
		
		// Draw colour guide
		infoFont.setColor(Color.WHITE);
		infoFont.draw(batch, "Colour Guide:", 20, height-30);
		for (int i = 0; i < 3; i++) {
			infoFont.setColor(infoColours[i]);
			infoFont.draw(batch, colourGuide[i], 20, height-50-20*i);			
		}
		
		// Draw money status
		moneyFont.draw(batch, "$: " + "1000" /* cs.getMoney() */, width-100, height-70);			// TODO
		
		// Draw arrows around candy
		candyFont.setColor(Color.WHITE);
		candyFont.draw(batch, "<", width/2 - 80, height-100);
		candyFont.draw(batch, ">", width/2 + 80, height-100);
		
		// Draw info
		String info = "Welcome to the candy shop! Move around with arrow keys and press enter while marking an \n"
					+ "upgrade to purchase it. Press enter while marking a candy property to view info about it.";
		//String info = cs.getInfo();																// TODO
		layout.setText(infoFont, info);
		layoutWidth = layout.width;
		infoFont.setColor(Color.WHITE);
		infoFont.draw(batch, info, (width - layoutWidth)/2, height-420);
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