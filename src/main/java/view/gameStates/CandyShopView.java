package view.gameStates;


import com.badlogic.gdx.graphics.Texture;
import model.Model;
import model.CandyShop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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

    private Texture candyShop;
    private SpriteBatch spriteBatch;

	private CandyShop cs;
	
	private OrthographicCamera cam;
	private float width;
	private float height;
	private static final GlyphLayout layout = new GlyphLayout();
	private float layoutWidth;
	
	private static final SpriteBatch batch = new SpriteBatch();
	private BitmapFont titleFont;
	private BitmapFont moneyFont;
	private BitmapFont candyFont;
	private BitmapFont propertyFont;
	private BitmapFont playerFont;
	private BitmapFont finishFont;
	private BitmapFont infoFont;
	
	private Color[] infoColours = new Color[3];
	private Color marker;

	private String title;
	private String[] colourGuide = new String[3];
	
	@SuppressWarnings("deprecation")
	public CandyShopView (OrthographicCamera cam, Model model, float width, float height) {
		this.cam = cam;
		this.cs = model.getCandyShop();
		this.width = width;
		this.height = height;
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
			Gdx.files.internal("src/main/resources/fonts/OpenSans-CondLight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 2;
        parameter.size = 50;
		titleFont = gen.generateFont(parameter);
        parameter.size = 30;
		candyFont = gen.generateFont(parameter);
        parameter.size = 25;
        moneyFont = gen.generateFont(parameter);
		propertyFont = gen.generateFont(parameter);
		playerFont = gen.generateFont(parameter);
		finishFont = gen.generateFont(parameter);
        parameter.size = 15;
        parameter.borderWidth = 1;
		infoFont = gen.generateFont(parameter);

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

        spriteBatch = new SpriteBatch();
        loadTextures();
	}
    private void loadTextures(){
        candyShop = new Texture(Gdx.files.internal("images/candyshop.png"));
    }

    private void drawCandyshop(){
        spriteBatch.draw(candyShop,0,0, 640, 480);
    }
	@Override
	public void render(float delta) {		
		drawUnselectableThings();
		
		int currentRow = cs.getCurrentRow();
		int currentCol = cs.getCurrentCol();

		// Draw Player name
		String player = "Player 1";	// cs.getPlayerName();											// TODO
		layout.setText(candyFont, player);
		layoutWidth = layout.width;
		if (currentRow == -2) { playerFont.setColor(marker); }
		else { playerFont.setColor(Color.WHITE); }
		playerFont.draw(batch, player, (width - layoutWidth)/2, height-100);
		
		// Draw selected candy
		String candy = cs.getSelectedCandy();
		layout.setText(candyFont, candy);
		layoutWidth = layout.width;
		if (currentRow == -1) { candyFont.setColor(marker); }
		else { candyFont.setColor(Color.WHITE); }
		candyFont.draw(batch, candy, (width - layoutWidth)/2, height-140);
		
		// Draw candy property names
		String prop;
		for (int col = 1; col <= 4; col++) {
			prop = cs.getPropName(col);
			layout.setText(propertyFont, prop);
			layoutWidth = layout.width;
			if (currentRow == 0 && currentCol == col) { propertyFont.setColor(marker); }
			else { propertyFont.setColor(Color.WHITE); }
			propertyFont.draw(batch, prop, (col-1)*width/4 + (width/4-layoutWidth)/2, height-190);
		}

		String status;
		String upgradeName;
		for (int row = 1; row <= 4; row++) {
			for (int col = 1; col <= 4; col++) {
				if (currentRow == row && currentCol == col) { 
					propertyFont.setColor(marker); 
				}
				else {
					status = cs.getStatus(row, col);
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
				upgradeName = row + "";
				layout.setText(propertyFont, upgradeName);
				layoutWidth = layout.width;
				propertyFont.draw(batch, upgradeName, 
						(col-1)*width/4 + (width/4-layoutWidth)/2, height-190-30*row);
			}
		}
		
		// Draw Start Next Level
		String text = "Start Next Level";
		layout.setText(candyFont, text);
		layoutWidth = layout.width;
		if (currentRow == 5) { finishFont.setColor(marker); }
		else { finishFont.setColor(Color.WHITE); }
		finishFont.draw(batch, text, (width - layoutWidth)/2, height-370);
		
		batch.end();
	}
	
	private void drawUnselectableThings() {
        //render background
        spriteBatch.begin();
        drawCandyshop();
        spriteBatch.end();

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
		moneyFont.draw(batch, "$: " + cs.getMoney() , width-120, height-70);
		
		// Draw arrows around player
		playerFont.setColor(Color.WHITE);
		playerFont.draw(batch, "<", width/2 - 70, height-100);
		playerFont.draw(batch, ">", width/2 + 70, height-100);
		
		// Draw arrows around candy
		candyFont.setColor(Color.WHITE);
		candyFont.draw(batch, "<", width/2 - 80, height-140);
		candyFont.draw(batch, ">", width/2 + 80, height-140);
		
		// Draw info
		String info = "Welcome to the candy shop! Move around with arrow keys and press enter while marking an \n"
					+ "upgrade to purchase it.";
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
